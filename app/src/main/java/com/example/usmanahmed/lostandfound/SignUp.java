package com.example.usmanahmed.lostandfound;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends Activity {
    EditText Etname,Etemail,Etpass;
    Button BtnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        BtnSignup=findViewById(R.id.Btnsignup);



        BtnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Etname=findViewById(R.id.Etname);
                Etemail=findViewById(R.id.Etmail);
                Etpass=findViewById(R.id.Etpass);

            }
        });
    }
}
