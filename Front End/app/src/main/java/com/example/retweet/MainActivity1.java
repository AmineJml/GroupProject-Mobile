package com.example.retweet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
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
        Button btn = (Button)findViewById(R.id.signup);
        Button btn1 = (Button)findViewById(R.id.login);
    }

    public void login(View view){
        EditText user = (EditText) findViewById(R.id.username);
        EditText pass = (EditText)findViewById(R.id.password);
        String user_val = user.getText().toString();
        String pass_val = pass.getText().toString();

        //if user_val and pass_val exist in db then login
        Toast.makeText(this, "Welcome @" + user_val + "!", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity1.this, MainActivity3.class));
        //else if username exists in db but password wrong
        Toast.makeText(this, "Invalid Password!",Toast.LENGTH_SHORT).show();
        //else if neither exist
        Toast.makeText(this, "Invalid account, please sign up!", Toast.LENGTH_SHORT).show();
    }

    public void signUp(View view){
        startActivity(new Intent(MainActivity1.this, MainActivity2.class));
    }


}