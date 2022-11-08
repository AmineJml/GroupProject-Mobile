package com.example.retweet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
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
    Activity 5 --> We have now moved to the users account
                    page where it shoes their first,last
                    name and username with all their tweets.
 */
public class MainActivity4 extends AppCompatActivity {

    String base_url = "http://192.168.0.101/GroupProject/Back End/";
    RequestQueue queue;
    StringRequest request;
    Adapter adapter;
    RecyclerView recyclerView;
    List<Tweet> list;
    Button add_tweet;
    TextView display_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        queue = Volley.newRequestQueue(MainActivity4.this);
        add_tweet = (Button) findViewById(R.id.goToAddTweet);
        recyclerView = findViewById(R.id.account_view);
        list = new ArrayList<>();
        display_user = (TextView)findViewById(R.id.display_user);
        display_user.getText().toString();
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
                    Toast.makeText(MainActivity4.this, "Register Error!" + e.toString(), Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity4.this, "Register Error!" + error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        Volley.newRequestQueue(this).add(request);
    }

    public void goToAddTweet(View view){
        startActivity(new Intent(MainActivity4.this, Add_Delete_Tweet.class));
    }

    public void goHome(View view){
       startActivity(new Intent(MainActivity4.this, MainActivity3.class));
    }

    public void goSetting(View view){
        startActivity(new Intent(MainActivity4.this, MainActivity5.class));
    }
}