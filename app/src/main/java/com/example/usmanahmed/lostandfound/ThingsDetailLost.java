package com.example.usmanahmed.lostandfound;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ThingsDetailLost extends Activity {
    Button btnpost;
    EditText etproduct,etcategory,etname,etno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_things_detail_lost);

        btnpost=findViewById(R.id.Btnpost);
        etproduct=findViewById(R.id.etproduct);
        etcategory=findViewById(R.id.etcategory);
        etname=findViewById(R.id.etusername);
        etno=findViewById(R.id.etno);

        btnpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
