package com.example.tennis_booking_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Retrieval extends AppCompatActivity {
    private EditText tvNhapp;
    private EditText tvNhappp;
    private Button  btnContinue1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieval);
        tvNhapp = (EditText) findViewById(R.id.tvNhapp);
        tvNhappp = (EditText) findViewById(R.id.tvNhappp);
        btnContinue1 = (Button) findViewById(R.id.btnContinue1);
        btnContinue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Retrieval.this, SignUpSuccess.class);
                startActivity(intent);
            }
        });
    }
}