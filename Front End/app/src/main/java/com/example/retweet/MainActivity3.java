package com.example.retweet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
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
    
    public void getTweet(){
        String url = base_url + "view_all_tweets.php";
        request = new StringRequest(Request.Method.GET, url, this::onResponse, this::onError);
        queue.add(request);
    }

    private void onError(VolleyError error) {
        Toast.makeText(this, "Error Showing Tweets!", Toast.LENGTH_SHORT).show();
    }

    private void onResponse(String s) {

    }

    public void addTweet(){

    }


}