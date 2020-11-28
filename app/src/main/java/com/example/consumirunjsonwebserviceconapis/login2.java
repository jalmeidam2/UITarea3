package com.example.consumirunjsonwebserviceconapis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class login2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        Bundle bundle=this.getIntent().getExtras();
        Login(bundle);
    }
       private void Login(Bundle bundle)
    {

        //http://uealecpeterson.net/ws/login.php?usr="+user+"&pass="+pass
        String url= ""+bundle.getString("user")+"&pass="+bundle.getString("pass");
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        StringRequest stringRequest= new StringRequest(Request.Method.POST,url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                TextView txtestado= (TextView)findViewById(R.id.lblEstadoLogin);
                txtestado.setText(" login: "+response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) ;
        requestQueue.add(stringRequest);

    }
}