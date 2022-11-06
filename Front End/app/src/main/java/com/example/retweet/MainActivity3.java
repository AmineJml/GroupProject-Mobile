package com.example.retweet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity3 extends AppCompatActivity {

    String base_url = "http://192.168.0.108.";
    RequestQueue queue;
    StringRequest request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        queue = Volley.newRequestQueue(MainActivity3.this);
    }





}