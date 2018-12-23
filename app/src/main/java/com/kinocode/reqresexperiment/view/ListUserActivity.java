package com.kinocode.reqresexperiment.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.kinocode.reqresexperiment.R;
import com.kinocode.reqresexperiment.adapter.UserListAdapter;
import com.kinocode.reqresexperiment.api.APIClient;
import com.kinocode.reqresexperiment.api.APIInterface;
import com.kinocode.reqresexperiment.model.Datum;
import com.kinocode.reqresexperiment.model.UserList;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListUserActivity extends AppCompatActivity {

    APIInterface apiInterface;

    UserListAdapter userListAdapter;
    List<Datum> datumList;
    RecyclerView rvListUser;
    ProgressDialog progressDialog;

    Spinner spinPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);

        apiInterface = APIClient.getClient().create(APIInterface.class);

        spinPage = (Spinner) findViewById(R.id.spin_page);
        rvListUser = (RecyclerView) findViewById(R.id.rv_listUser);

        progressDialog = new ProgressDialog(this);

        List<String> pages = new ArrayList<String>();
        pages.add("1");
        pages.add("2");
        pages.add("3");
        pages.add("4");
        ArrayAdapter<String> pagesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, pages);

        pagesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinPage.setAdapter(pagesAdapter);

        spinPage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();

                Call<UserList> apiService = apiInterface.doGetUserList(item);
                apiService.enqueue(new Callback<UserList>() {
                    @Override
                    public void onResponse(Call<UserList> call, Response<UserList> response) {
                        progressDialog.setMessage("Loading Data.. Please wait");
                        progressDialog.setIndeterminate(false);
                        progressDialog.setCancelable(false);
                        progressDialog.show();

                        if (response.isSuccessful()){

                            progressDialog.dismiss();
                            datumList = response.body().getData();
                            Log.d("TAG", "Response = " + datumList);
                            userListAdapter = new UserListAdapter(getApplicationContext(), datumList);
                            RecyclerView.LayoutManager layoutmanager = new LinearLayoutManager(getApplicationContext());
                            rvListUser.setLayoutManager(layoutmanager);
                            rvListUser.setItemAnimator(new DefaultItemAnimator());
                            rvListUser.setAdapter(userListAdapter);

                        }

                    }

                    @Override
                    public void onFailure(Call<UserList> call, Throwable t) {
                        Log.d("TAG", "Response Failure = " + t.toString());
                        progressDialog.dismiss();
                    }
                });

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
