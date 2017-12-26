package com.example.usmanahmed.lostandfound;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Usman Ahmed on 25/12/2017.
 */

public class GetRetrofit {

    public static final String BASE_URL = "http://192.168.10.40/test/public/api/";
    private static Retrofit retrofit;
    static {
        OkHttpClient.Builder builder=new OkHttpClient.Builder();
        Retrofit.Builder builder1=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());
        retrofit =builder1.client(builder.build()).build();
    }
    public static Retrofit getRetrofit()
    {
        return retrofit;
    }
}
