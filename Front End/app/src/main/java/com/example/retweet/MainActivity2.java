package com.example.retweet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    Activity 3 --> We have now moved to the register page
                    for a new user to create a new account
                    by filling in their fname, lname, and
                    username and password.
 */


public class MainActivity2 extends AppCompatActivity {
    EditText fname, lname, user, pass, confirm_pass;
    ProgressBar pb;
    Button btn;
    String base_url="http://192.168.0.101/GroupProject/Back End/";
    StringRequest request;
    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        fname = (EditText) findViewById(R.id.fname);
        lname = (EditText) findViewById(R.id.lname);
        user = (EditText) findViewById(R.id.user);
        pass = (EditText) findViewById(R.id.pass);
        confirm_pass = (EditText) findViewById(R.id.confirm_pass);
        //btn = (Button) findViewById(R.id.register);
        pb = (ProgressBar) findViewById(R.id.progressBar); //if equal success

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //register("amine", "jamal", "AA", "123");
    }
    public void Register(){
    pb.setVisibility(View.VISIBLE);
    btn.setVisibility(View.GONE);

    String fname=this.fname
    String lname;
    String user;
    String pass;
    String c_pass;
    }
//    public void register(String FName, String LName, String Username, String Password){
//        String url = base_url + "register.php";
//
//
//        request = new StringRequest(Request.Method.POST, url, this::onResponse, this::onError) {
//            public Map<String, String> getParams() {
//                Map<String, String> params = new HashMap<String, String>();
//                params.put("FName", FName);
//                params.put("LName", LName);
//                params.put("Username", Username);
//                params.put("Password", Password);
//                return params;
//            }
//        };
//        queue.add(request);
//    }
//
//    public void onError(VolleyError error){
//        Toast.makeText(MainActivity2.this, "Error", Toast.LENGTH_LONG).show();
//    }
//
//    public void onResponse(String response){
//        Toast.makeText(MainActivity2.this, "Data Retreived from the Server", Toast.LENGTH_SHORT).show();
//        try{
//            JSONObject json = new JSONObject((response));
//            Log.d("Response", json.toString());
//        }catch(Exception e){
//            Log.i("Error", Arrays.toString(e.getStackTrace()));
//        }
//
//    }


//    public void getStarted(View view){
//
//
//    String pass_val = pass.getText().toString();
//    String cpass_val = confirm_pass.getText().toString();
//
//    if(pass_val.equals(cpass_val)){
//        Log.d("IMHere", pass_val + "  " + cpass_val);
//
//        //save all input in db
//        //register(fname.getText().toString() , lname.getText().toString(), user.getText().toString(), pass.getText().toString());
//
//        Toast.makeText(this, "Welcome @"+user+"!", Toast.LENGTH_SHORT).show();
//        startActivity(new Intent(MainActivity2.this, MainActivity3.class));
//
//    }else if(user.equals(fname)){ //change if condition
//        //check all input if already exist in db
//        Toast.makeText(this, "Existing user! Please login!", Toast.LENGTH_SHORT).show();
//    }else{
//        Toast.makeText(this, "Passwords aren't the same!", Toast.LENGTH_SHORT).show();
//
//    }
//
//    }
}