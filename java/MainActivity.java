package com.example.hello;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {    // onCreate() : 시작점 역할
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}