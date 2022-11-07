package com.cdev.accountview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/*
    Activity 4 --> We have now moved to the feed
                   which shows all tweets on the
                   db and the user can add their
                   tweet to the feed.
 */
public class MainActivity3 extends AppCompatActivity {

    String base_url = "http://192.168.0.101/GroupProject/Back End/";
    RequestQueue queue;
    StringRequest request;
    Adapter adapter;
    RecyclerView recyclerView;
    List<Tweet> list;
    Button add_tweet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        queue = Volley.newRequestQueue(MainActivity3.this);
        add_tweet = (Button) findViewById(R.id.goToAddTweet);
        recyclerView = findViewById(R.id.response);
        list = new ArrayList<>();
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        StringRequest request = new StringRequest(base_url + "get_view_tweets_id.php", new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array = new JSONArray(response);
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject object = array.getJSONObject(i);
                        list.add(new Tweet(object.getString("Username"),
                                object.getString("Tweet")));
                    }
                    adapter.notifyDataSetChanged();
                }
                catch(JSONException e){
                    Toast.makeText(MainActivity3.this, "Register Error!" + e.toString(), Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity3.this, "Register Error!" + error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        Volley.newRequestQueue(this).add(request);
    }

    public void goToAddTweet(View view){
        startActivity(new Intent(MainActivity3.this, Add_Delete_Tweet.class));
        //make activity
    }

    public void goSettings(View view){
        startActivity(new Intent(MainActivity3.this, MainActivity5.class));
    }

    public void goAccount(View view) {
        startActivity(new Intent(MainActivity3.this, MainActivity4.class));
    }

    //when the delete btn is pressed - the selected tweet will be deleted and the page will refresh afterwards
    public void delete(View v){
        //StringRequest request = new StringRequest(base_url + "delete_tweet.php", new Response.Listener<String>();
        //refersh page
    }
}

