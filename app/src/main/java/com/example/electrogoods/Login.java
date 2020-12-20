package com.example.electrogoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void button_phone (View view) {
        startActivity(new Intent(getApplicationContext(), loginwphone.class));
    }

    public void button_google (View view) {
        startActivity(new Intent(getApplicationContext(), loginwgoogle.class));
    }
}
