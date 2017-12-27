package com.example.usmanahmed.lostandfound;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity {
    private RetrofitClient apiInterface;
    ArrayList<LostModel> own;
    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    ListView list;
    Button btnAddFound_Lost, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);

        own = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);


        //  final MyView[] myView= new  MyView[1];
        btnAddFound_Lost = findViewById(R.id.btnAddFound_Lost);
        btnAddFound_Lost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LostOrFound.class));
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("My", MODE_PRIVATE);
                //sharedPreferences.edit().putString("user",getIntent().getStringExtra("user")).clear();


                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                finish();
                startActivity(new Intent(getApplicationContext(), LogIn.class));


            }
        });

// getting values from api

        apiInterface = GetRetrofit.getRetrofit().create(RetrofitClient.class);
        Call<List<LostModel>> cal = apiInterface.getLostThings();
        RetrofitClient apiInterface = GetRetrofit.getRetrofit().create(RetrofitClient.class);
        cal.enqueue(new Callback<List<LostModel>>() {
            @Override
            public void onResponse(Call<List<LostModel>> call, Response<List<LostModel>> response) {
                List<LostModel> list = response.body();
                if (response.isSuccessful()) {
                    for (LostModel x : list) {
                        own.add(x);
                    }
                    Toast.makeText(MainActivity.this, "connection successfull", Toast.LENGTH_SHORT).show();
                    Log.d("MTAG", "onResponse: is successfully: " + response.body().get(1).getOwner_name());
                    adapter = new RecyclerAdapter(own);
                    recyclerView.setAdapter(adapter);
                }

            }

            @Override
            public void onFailure(Call<List<LostModel>> call, Throwable t) {
                //Log.d("MTAG", "onResponse: is Fail" + t.getLocalizedMessage());
                Toast.makeText(MainActivity.this, "connection fail", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
