package com.example.metals;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView nameTV , symTV;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String mname = getIntent().getStringExtra("metal_names");
        String sname = getIntent().getStringExtra("symbols");


         nameTV = findViewById(R.id.resTe);
         symTV = findViewById(R.id.resSol);

         nameTV.setText(mname);
         symTV.setText(sname);


    }
}