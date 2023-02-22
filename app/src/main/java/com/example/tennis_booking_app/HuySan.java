package com.example.tennis_booking_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HuySan extends AppCompatActivity {
    Button btGui;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huy_san);
        btGui=(Button) findViewById(R.id.btGui);
        btGui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HuySan.this,ThanhCong.class);
                startActivity(intent);
            }
        });
    }
}