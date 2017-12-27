package com.example.usmanahmed.lostandfound;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Usman Ahmed on 19/11/2017.
 */

public interface RetrofitClient
{
    @GET("web")
    Call<List<Model>> getAllModel();

    @GET("web/{id}")
    Call<Model> getModel(@Body int id);

    @POST("web")
    Call<Model> signup(@Body Model model);


    @GET("lost")
    Call<List<LostAndFoundModel>> getLostThings();
    @POST("found")
    Call<LostAndFoundModel> createLostThings(@Body LostAndFoundModel lostAndFoundModel);

}
