package com.example.tennis_booking_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tennis_booking_app.activity.home.HomeActivity;

public class SignUpSuccess extends AppCompatActivity {
     private Button btnSuccess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_success);
        btnSuccess = (Button) findViewById(R.id.btnSuccess);
        btnSuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpSuccess.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}