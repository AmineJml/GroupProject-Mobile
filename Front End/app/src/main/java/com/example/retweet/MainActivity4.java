package com.example.retweet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
/*
    Activity 5 --> We have now moved to the users account
                    page where it shoes their first,last
                    name and username with all their tweets.
 */
public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
    }

    //view USERS FIRST NAME, LAST NAME, USERNAME AND ALL TWEETS

    public void goHome(View view){
       startActivity(new Intent(MainActivity4.this, MainActivity3.class));
    }

    public void goSetting(View view){
        startActivity(new Intent(MainActivity4.this, MainActivity5.class));
    }
}