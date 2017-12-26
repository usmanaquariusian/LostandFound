package com.example.usmanahmed.lostandfound;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SignUp extends Activity {
    EditText Etname,Etemail,Etpass;
    Button BtnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        BtnSignup=findViewById(R.id.Btnsignup);
        final Retrofit retrofit=GetRetrofit.getRetrofit();
        final RetrofitClient client=retrofit.create(RetrofitClient.class);


        BtnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Etname=findViewById(R.id.Etname);
                Etemail=findViewById(R.id.Etmail);
                Etpass=findViewById(R.id.Etpass);
                Call<Model> signup=client.signup(new Model(Etname.getText().toString(),Etpass.getText().toString(),Etemail.getText().toString()));
                signup.enqueue(new Callback<Model>() {
                    @Override
                    public void onResponse(Call<Model> call, Response<Model> response) {
                        Toast.makeText(SignUp.this, response.message(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Model> call, Throwable t) {
                        Toast.makeText(SignUp.this, "User Creation failed", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });
    }
}
