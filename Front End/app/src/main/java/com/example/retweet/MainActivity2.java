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
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
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
    String base_url = "http://192.168.0.101/GroupProject/Back End/register.php";
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
        btn = (Button) findViewById(R.id.register);
        pb = (ProgressBar) findViewById(R.id.progressBar); //if equal success

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Register();
            }
        });
    }

    public void Register() {
        pb.setVisibility(View.VISIBLE);
        btn.setVisibility(View.GONE);

        String fname = this.fname.getText().toString();
        String lname = this.lname.getText().toString();
        String user = this.user.getText().toString();
        String pass = this.pass.getText().toString();
        String c_pass = this.confirm_pass.getText().toString();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, base_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            if (success.equals(true) && pass.equals(c_pass)) {
                                Toast.makeText(MainActivity2.this, "Registered Successfully!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(MainActivity2.this, MainActivity3.class));
                            }else{
                                Toast.makeText(MainActivity2.this, "Passwords don't match!", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            Toast.makeText(MainActivity2.this, "Register Error!" + e.toString(), Toast.LENGTH_SHORT).show();
                            e.printStackTrace();
                            pb.setVisibility(View.GONE);
                            btn.setVisibility(View.VISIBLE);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity2.this, "Register Error!" + error.toString(), Toast.LENGTH_SHORT).show();
                        pb.setVisibility(View.GONE);
                        btn.setVisibility(View.VISIBLE);
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("FName", fname);
                params.put("LName", lname);
                params.put("Username", user);
                params.put("Password", pass);
                return params;
          }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
