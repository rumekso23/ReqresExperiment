package com.kinocode.reqresexperiment.view;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.kinocode.reqresexperiment.R;
import com.kinocode.reqresexperiment.api.APIClient;
import com.kinocode.reqresexperiment.api.APIInterface;
import com.kinocode.reqresexperiment.model.User;
import com.kinocode.reqresexperiment.model.UserList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddUserActivity extends AppCompatActivity {

    TextInputLayout etName, etJob;
    Button btnSubmit;


    APIInterface apiInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        etName = (TextInputLayout) findViewById(R.id.et_name);
        etJob = (TextInputLayout) findViewById(R.id.et_job);
        btnSubmit = (Button) findViewById(R.id.btn_submit);

        apiInterface = APIClient.getClient().create(APIInterface.class);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = etName.getEditText().getText().toString();
                final String job = etJob.getEditText().getText().toString();
                User user = new User(name, job);
                Call<User> apiService = apiInterface.createUser(user);
                apiService.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        User newUser = response.body();
                        Log.d("TAG", "Response = " + newUser);

                        Toast.makeText(getApplicationContext(), newUser.name + " " + newUser.job + " " + newUser.id + " " + newUser.createdAt, Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Log.d("TAG", "Add_User Failure = " + t.toString());
                    }
                });

            }
        });
    }

}
