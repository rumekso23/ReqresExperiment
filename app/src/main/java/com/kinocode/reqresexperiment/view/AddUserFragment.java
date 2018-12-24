package com.kinocode.reqresexperiment.view;


import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.kinocode.reqresexperiment.R;
import com.kinocode.reqresexperiment.api.APIClient;
import com.kinocode.reqresexperiment.api.APIInterface;
import com.kinocode.reqresexperiment.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddUserFragment extends Fragment {

    TextInputLayout etName, etJob;
    Button btnSubmit;
    APIInterface apiInterface;

    public AddUserFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_user, container, false);


        etName = (TextInputLayout) view.findViewById(R.id.et_name);
        etJob = (TextInputLayout) view.findViewById(R.id.et_job);
        btnSubmit = (Button) view.findViewById(R.id.btn_submit);

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

                        Toast.makeText(getContext(), newUser.name + " " + newUser.job + " " + newUser.id + " " + newUser.createdAt, Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Log.d("TAG", "Add_User Failure = " + t.toString());
                    }
                });

            }
        });

        return view;

    }

}
