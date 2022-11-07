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

public class Add_Delete_Tweet extends AppCompatActivity {

    String base_url = "http://192.168.0.101/GroupProject/Back End/";
    Button add;
    TextView username;
    EditText tweet, display_user;
    StringRequest request;
    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_delete_tweet);
        add = (Button) findViewById(R.id.button);
        username = (TextView) findViewById(R.id.displayUser);
        tweet = (EditText) findViewById(R.id.displayTweet);
        display_user = (EditText)findViewById(R.id.username);
    }

    public void addTweetToServer(String username, String tweet_content){
        String url = base_url + "register.php";

        request = new StringRequest(Request.Method.POST, url, this::onResponse, this::onError) {
            public Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Username", username);
                params.put("Tweet", tweet_content);
                return params;
            }
        };
        queue.add(request);
    }

    public void onError(VolleyError error){
        Toast.makeText(Add_Delete_Tweet.this, "Error", Toast.LENGTH_LONG).show();
    }

    public void onResponse(String response){
        Toast.makeText(Add_Delete_Tweet.this, "Tweet Added to the Server", Toast.LENGTH_SHORT).show();
        try{
            JSONObject json = new JSONObject((response));
            Log.d("Response", json.toString());
        }catch(Exception e){
            Log.i("Error", Arrays.toString(e.getStackTrace()));
        }
    }

    public void addTweet(View view){
        addTweetToServer(display_user.getText().toString(), tweet.getText().toString());
    }

    public void goSettings(View view){
        startActivity(new Intent(Add_Delete_Tweet.this, MainActivity5.class));
    }

    public void goAccount(View view) {
        startActivity(new Intent(Add_Delete_Tweet.this, MainActivity4.class));
    }

    public void goHome(View view) {
        startActivity(new Intent(Add_Delete_Tweet.this, MainActivity3.class));
    }
}
