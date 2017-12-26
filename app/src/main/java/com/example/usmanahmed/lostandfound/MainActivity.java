package com.example.usmanahmed.lostandfound;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
Button btnAddFound_Lost,btnLogout;;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        final RecyclerView recyclerView=(RecyclerView) findViewById(R.id.list);
        btnLogout=findViewById(R.id.btnLogout);
        recyclerView.setLayoutManager(layoutManager);
        final MyView[] myView= new  MyView[1];
        btnAddFound_Lost=findViewById(R.id.btnAddFound_Lost);
        btnAddFound_Lost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),LostOrFound.class));
            }
        });
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getSharedPreferences("My",MODE_PRIVATE);
                //sharedPreferences.edit().putString("user",getIntent().getStringExtra("user")).clear();


                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                finish();
                startActivity(new Intent(getApplicationContext(),LogIn.class));


            }
        });
    }
}
