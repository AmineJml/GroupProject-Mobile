package com.example.retweet;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpClientStack;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/*
    Activity 6 --> We have now moved to the settings page
                    where the user can modify their own
                    attributes, and it gets modifies in
                    the db.
 */
public class MainActivity5 extends AppCompatActivity {

    String base_url = "http://192.168.0.101/GroupProject/Back End/";
    EditText fnameET, lnameET, userET, passET;
    String fname, lname, user, pass;
    Button btnUpdate;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        fnameET = (EditText) findViewById(R.id.changefname);
        lnameET = (EditText) findViewById(R.id.changelname);
        userET = (EditText) findViewById(R.id.changeuser);
        passET = (EditText) findViewById(R.id.changepassword);
        btnUpdate = (Button) findViewById(R.id.updateSettings);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            fname = bundle.getString("FName");
            lname = bundle.getString("LName");
            user = bundle.getString("Username");
            pass = bundle.getString("Password");

            fnameET.setText(fname);
            lnameET.setText(lname);
            userET.setText(user);
            passET.setText(pass);

        }else{
            Toast.makeText(this, "Data Not Recieved!", Toast.LENGTH_SHORT).show();
        }

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fname_change = fnameET.getText().toString();
                String lname_change = lnameET.getText().toString();
                String user_change = userET.getText().toString();
                String pass_change = passET.getText().toString();

                StringRequest request = new StringRequest(Request.Method.POST, base_url + "edit.profile.php", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(MainActivity5.this, response.toString(), Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity5.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }){

                    @Nullable
                    @Override
                    protected Map<String, String> getParams(){
                        Map<String,String> param = new HashMap<String,String>();
                        param.put("FName", fnameET.getText().toString());
                        param.put("LName", lnameET.getText().toString());
                        param.put("Username", userET.getText().toString());
                        param.put("Password", passET.getText().toString());
                        return param;
                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(MainActivity5.this);
                requestQueue.add(request);
            }
        });
    }

    public void logout(View view) {
        startActivity(new Intent(MainActivity5.this, MainActivity1.class));
    }

    public void goHome(View view) {
        startActivity(new Intent(MainActivity5.this, MainActivity3.class));
    }

    public void goAccount(View view) {
        startActivity(new Intent(MainActivity5.this, MainActivity4.class));
    }
}
