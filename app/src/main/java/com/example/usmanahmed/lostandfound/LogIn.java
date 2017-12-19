package com.example.usmanahmed.lostandfound;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogIn extends Activity {

    EditText Etemail, Etpass;
    Button BtnSignin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
       BtnSignin=findViewById(R.id.Btnsignin);


        BtnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Etemail = findViewById(R.id.Etmail);
                Etpass = findViewById(R.id.Etpass);


            }
        });


    }
}
