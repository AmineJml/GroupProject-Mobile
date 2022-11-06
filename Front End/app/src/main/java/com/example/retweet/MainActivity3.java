package com.example.retweet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MainActivity3 extends AppCompatActivity {

    String base_url = "http://192.168.0.108.";
    RequestQueue queue;
    StringRequest request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        queue = Volley.newRequestQueue(MainActivity3.this);
        Button add_tweet = (Button) findViewById(R.id.addTweet);

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
        TextView response = (TextView) findViewById(R.id.response);
        Toast.makeText(MainActivity3.this, "Data Retreived from the Server", Toast.LENGTH_SHORT).show();
        try
        {JSONObject json = new JSONObject((String) response.getText());
            Log.i("Response", json.toString());
        }catch(Exception e){
            Log.i("Error", Arrays.toString(e.getStackTrace()));
        }
    }

    public void addTweet(String user_id, String username, String tweet){
        String url = base_url + "add_article.php";


        request = new StringRequest(Request.Method.POST, url, this::onResponse, this::onError) {

            public Map<String, String> getParams() {

                Map<String, String> params = new HashMap<String, String>();
                params.put("User_id", user_id);
                params.put("username", username);
                params.put("Tweet", tweet);
                return params;
            }
        };
        queue.add(request);
        }
    }
}