package com.example.usmanahmed.lostandfound;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ThingsDetailLost extends Activity {
    Button btnpost,btnShowLostList,btnLogout;
    EditText etproduct,etcategory,etname,etno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_things_detail_lost);

        btnpost=findViewById(R.id.Btnpost);

        btnShowLostList=findViewById(R.id.btnShowLostList);

        btnShowLostList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent (ThingsDetailLost.this,MainActivity.class));
            }
        });
        btnLogout=findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getSharedPreferences("My",MODE_PRIVATE);
                //sharedPreferences.edit().putString("user",getIntent().getStringExtra("user")).clear();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                finish();
                startActivity(new Intent(ThingsDetailLost.this,LogIn.class));
            }
        });
        btnpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etproduct=findViewById(R.id.etproduct);
                etcategory=findViewById(R.id.etcategory);
                etname=findViewById(R.id.etusername);
                etno=findViewById(R.id.etno);


                LostModel lostModel= new LostModel(""+etproduct.getText().toString(),
                        ""+etcategory.getText().toString(),
                        ""+etname.getText().toString(),
                        ""+etno.getText().toString());
                RetrofitClient apiInterface = GetRetrofit.getRetrofit().create(RetrofitClient.class);
                Call<LostModel> call = apiInterface.postLostThings(lostModel);
                call.enqueue(new Callback<LostModel>() {
                    @Override
                    public void onResponse(Call<LostModel> call, Response<LostModel> response) {

                    }

                    @Override
                    public void onFailure(Call<LostModel> call, Throwable t) {
                        Toast.makeText(ThingsDetailLost.this, "Successfully post request", Toast.LENGTH_SHORT).show();



                    }
                });

            }
        });
    }
}
