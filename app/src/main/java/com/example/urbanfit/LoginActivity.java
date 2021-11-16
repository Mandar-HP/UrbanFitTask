package com.example.urbanfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
    }

    public void signInprocess(View view) {
        Intent intntObj = new Intent(this,MainScreenActivity.class);
        startActivity(intntObj);
    }

}