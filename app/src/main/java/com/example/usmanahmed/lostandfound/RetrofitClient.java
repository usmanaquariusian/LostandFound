package com.example.usmanahmed.lostandfound;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Usman Ahmed on 19/11/2017.
 */

public interface RetrofitClient
{
    @GET("/my_saved_schema.json?key=b085c1d0")
    Call<List<Model>> getModel();
}
