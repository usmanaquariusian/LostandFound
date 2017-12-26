package com.example.usmanahmed.lostandfound;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class LogIn extends Activity {

    EditText Etemail, Etpass;
    Button BtnSignin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        BtnSignin = findViewById(R.id.btnsignin);
        SharedPreferences sharedPreferences=getSharedPreferences("My",MODE_PRIVATE);
        if(sharedPreferences.getString("user","").equals(""))
        {

        }
        else
        {
            startActivity((new Intent(this,LostOrFound.class)).putExtra("user",sharedPreferences.getString("user","")));
        }

        BtnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Etemail = findViewById(R.id.Etmail);
                final String email=Etemail.getText().toString();

                Etpass = findViewById(R.id.Etpass);
                final String pass=Etpass.getText().toString();
                final RetrofitClient client = GetRetrofit.getRetrofit().create(RetrofitClient.class);
                retrofit2.Call<List<Model>> allModel = client.getAllModel();
                allModel.enqueue(new Callback<List<Model>>() {
                    @Override
                    public void onResponse(retrofit2.Call<List<Model>> call, Response<List<Model>> response) {
                        Log.d("Mtag", "onResponse: "  + response.message() + response.isSuccessful());
                        if (response.isSuccessful()) {
                            List<Model> list = response.body();
                            for (int i = 1; i < list.size(); i++) {
                                if (email.equals(list.get(i).getEmail()) || pass.equals(list.get(i).getPassword())) {
                                    startActivity((new Intent(getApplicationContext(), LostOrFound.class)).putExtra("user", list.get(i).getname()));
                                    break;
                                }
                                else
                                {
                                    Log.d("Mtag", "onResponse: else");
                                }
                            }
                        }
                    }

                    @Override
                    public void onFailure(retrofit2.Call<List<Model>> call, Throwable t) {
                        Log.d("Mtag", "onFailure: faileed");
                    }
                });

            }
        });


    }

    public void Signup(View view) {
        startActivity(new Intent(this, SignUp.class));
    }

    public void Signin(View view) {
        startActivity(new Intent(this, SignUp.class));
    }
}
