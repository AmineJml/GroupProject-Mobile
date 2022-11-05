package com.example.retweet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

/*
    Activity 3 --> We have now moved to the register page
                    for a new user to create a new account
                    by filling in their fname, lname, and
                    username and password.
 */
public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void getStarted(){
    EditText fname = (EditText) findViewById(R.id.fname);
    EditText lname = (EditText) findViewById(R.id.lname);
    EditText user = (EditText) findViewById(R.id.user);
    EditText pass = (EditText) findViewById(R.id.pass);
    EditText confirm_pass = (EditText) findViewById(R.id.confirm_pass);

    String pass_val = pass.getText().toString();
    String cpass_val = confirm_pass.getText().toString();

    if(pass_val!=cpass_val){
        Toast.makeText(this, "Passwords aren't the same!", Toast.LENGTH_SHORT).show();
    }else if(user.equals(fname)){ //change if condition
        //check all input if already exist in db
        Toast.makeText(this, "Existing user! Please login!", Toast.LENGTH_SHORT).show();
    }else{
        //save all input in db
        Toast.makeText(this, "Welcome @"+user+"!", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity2.this, MainActivity3.class));
        }
    }
}