package com.example.usmanahmed.lostandfound;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends Activity {

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        final RecyclerView recyclerView=(RecyclerView) findViewById(R.id.list);
        recyclerView.setLayoutManager(layoutManager);
        final MyView[] myView= new  MyView[1];



        OkHttpClient.Builder builder=new OkHttpClient.Builder();
        Retrofit.Builder builder1=new Retrofit.Builder()
                .baseUrl("https://my.api.mockaroo.com")
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit=builder1.client(builder.build()).build();

        RetrofitClient retrofitClient=retrofit.create(RetrofitClient.class);
        Call<List<Model>> call=retrofitClient.getModel();
        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
            myView[0]=new MyView((ArrayList<Model>) response.body());
            recyclerView.setAdapter(myView[0]);
            myView[0].notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {

            }
        });



    }
}
