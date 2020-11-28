package com.example.consumirunjsonwebserviceconapis.Retrofit.Interface;

import com.example.consumirunjsonwebserviceconapis.Retrofit.Model.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface JSONList {

    @GET("bankList")
    Call<List<Posts>> getPost(@Header("Public-Merchant-Id") String id);

}
