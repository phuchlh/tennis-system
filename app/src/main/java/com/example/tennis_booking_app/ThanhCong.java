package com.example.tennis_booking_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tennis_booking_app.activity.home.HomeActivity;

import java.util.Timer;
import java.util.TimerTask;

public class ThanhCong extends AppCompatActivity {
    Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanh_cong);


        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(ThanhCong.this, HomeActivity.class);
                startActivity(intent);
            }
        }, 1000);

    }
}