package com.example.retweet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/*

    Activity 2 --> We have now moved to the login page
                   where a frequent user logs in. If
                   not, then the user has to register
                   for a new account.

 */
public class MainActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
    }


}