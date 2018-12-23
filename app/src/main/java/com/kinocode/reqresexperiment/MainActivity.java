package com.kinocode.reqresexperiment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kinocode.reqresexperiment.view.ListResourceActivity;
import com.kinocode.reqresexperiment.view.ListUserActivity;




public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnListUser, btnListResource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnListUser = (Button) findViewById(R.id.btn_listUser);
        btnListResource = (Button) findViewById(R.id.btn_listResource);

        btnListUser.setOnClickListener(this);
        btnListResource.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == btnListUser){
            startActivity(new Intent(this, ListUserActivity.class));
        }else if (v == btnListResource){
            startActivity(new Intent(this, ListResourceActivity.class));
        }
    }
}
