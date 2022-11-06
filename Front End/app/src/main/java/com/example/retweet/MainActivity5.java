package com.example.retweet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
/*
    Activity 6 --> We have now moved to the settings page
                    where the user can modify their own
                    attributes, and it gets modifies in
                    the db.
 */
public class MainActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
    }

    //Modify any user input with info in db

    public void logout(View view){
        startActivity(new Intent(MainActivity5.this, MainActivity1.class));
    }

    public void goHome(View view){
        startActivity(new Intent(MainActivity5.this, MainActivity3.class));
    }

    public void goAccount(View view){
        startActivity(new Intent(MainActivity5.this, MainActivity4.class));
    }
}
