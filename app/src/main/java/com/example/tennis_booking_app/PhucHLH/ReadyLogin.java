package com.example.tennis_booking_app.PhucHLH;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.tennis_booking_app.R;
import com.example.tennis_booking_app.Register;
import com.example.tennis_booking_app.StartsActivity;

public class ReadyLogin extends AppCompatActivity {
    RelativeLayout layoutWait;

    Button btnLogin, btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ready_login);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        layoutWait = (RelativeLayout) findViewById(R.id.layoutWaiting);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReadyLogin.this, StartsActivity.class);
                startActivity(intent);
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReadyLogin.this, Register.class);
                startActivity(intent);
            }
        });
    }
}