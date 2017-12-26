package com.example.usmanahmed.lostandfound;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LostOrFound extends Activity {

    Button btnLost,btnfound,btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_or_found);
        SharedPreferences sharedPreferences=getSharedPreferences("My",MODE_PRIVATE);
        sharedPreferences.edit().putString("user",getIntent().getStringExtra("user")).apply();
        btnLost=findViewById(R.id.btnlost);
        btnfound=findViewById(R.id.btnfound);
        btnLogout=findViewById(R.id.btnLogout);
        btnLost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnfound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),ThingsDetailFound.class));

            }
        });

        btnLost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),ThingsDetailLost.class));

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
                startActivity(new Intent(LostOrFound.this,LogIn.class));


            }
        });
    }
}
