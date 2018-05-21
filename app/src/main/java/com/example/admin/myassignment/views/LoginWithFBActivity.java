package com.example.admin.myassignment.views;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.admin.myassignment.R;

public class LoginWithFBActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_with_fb);
    }
    public static void start(Context context) {
        Intent intent = new Intent(context, LoginWithFBActivity.class);
        context.startActivity(intent);
    }
}
