package com.example.retweet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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
    Activity 2 --> We have now moved to the login page
                   where a frequent user logs in. If
                   not, then the user has to register
                   for a new account.
 */
public class MainActivity1 extends AppCompatActivity {

    String base_url="http://192.168.0.101/GroupProject/Back End/";
    StringRequest request;
    RequestQueue queue;
    EditText user, pass;
    Button btn, btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        user = (EditText) findViewById(R.id.username);
        pass = (EditText)findViewById(R.id.password);
        btn = (Button)findViewById(R.id.signup);
        btn1 = (Button)findViewById(R.id.login);
    }

    public void register(String FName, String LName, String Username, String Password){
        String url = base_url + "register.php";


        request = new StringRequest(Request.Method.POST, url, this::onResponse, this::onError) {
            public Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("FName", FName);
                params.put("LName", LName);
                params.put("Username", Username);
                params.put("Password", Password);
                return params;
            }
        };
        queue.add(request);
    }

    public void onError(VolleyError error){
        Toast.makeText(MainActivity1.this, "Error", Toast.LENGTH_LONG).show();
    }

    public void onResponse(String response){
        Toast.makeText(MainActivity1.this, "Data Retreived from the Server", Toast.LENGTH_SHORT).show();
        try{
            JSONObject json = new JSONObject((response));
            Log.d("Response", json.toString());
        }catch(Exception e){
            Log.i("Error", Arrays.toString(e.getStackTrace()));
        }

    }

    public void login(View view){
        String user_val = this.user.getText().toString();
        String pass_val = this.pass.getText().toString();

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