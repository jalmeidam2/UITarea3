package com.example.consumirunjsonwebserviceconapis;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.consumirunjsonwebserviceconapis.Retrofit.Interface.JSONList;
import com.example.consumirunjsonwebserviceconapis.Retrofit.Model.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView datos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

public void clickListado(View view)
{
    datos = (TextView)findViewById(R.id.DATOS);
    EnvioRtfrin();
}

    private void EnvioRtfrin()
    {
        Retrofit retrofits = new Retrofit.Builder().baseUrl("https://api-uat.kushkipagos.com/transfer-subscriptions/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JSONList jsonBLs = retrofits.create(JSONList.class);
        Call<List<Posts>> calls = jsonBLs.getPost("d7efe7b1d2ae4a8dbc7b9449b086f068");
        calls.enqueue(new Callback<List<Posts>>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                if(!response.isSuccessful())
                {
                    datos.setText("Código: "+response.code());
                }
                List<Posts> postListBanks= response.body();

                for (Posts posts: postListBanks)
                {
                    String cadena ="";
                    cadena +=posts.getName()+"\n";
                    datos.append(cadena);
                }
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {
                datos.setText(t.getMessage());
            }
        });


    }

}