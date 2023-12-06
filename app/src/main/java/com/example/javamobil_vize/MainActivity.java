package com.example.javamobil_vize;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button tanımlama

        Button randomBtn = findViewById(R.id.randomBtn);
        Button smsBtn = findViewById(R.id.smsBtn);
        Button convertorBtn = findViewById(R.id.convertorBtn);

        //Button Dinleme

        randomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RandomView.class);
                startActivity(intent);
            }
        });
        smsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SmsView.class);
                startActivity(intent);
            }
        });
        convertorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ConvertorView.class);
                startActivity(intent);
            }
        });

    }
}