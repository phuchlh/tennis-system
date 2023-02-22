package com.example.tennis_booking_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.tennis_booking_app.activity.home.HomeActivity;

import java.util.Timer;
import java.util.TimerTask;

public class SendFeedback extends AppCompatActivity {
     private RatingBar ratingBar;
     private Button btnSuccess1;
    Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_feedback);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        btnSuccess1 = (Button) findViewById(R.id.btnSuccess1);

        btnSuccess1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplication(), "Tổng số ngôi sao:"+ratingBar.getNumStars()+" \nSố lượng đánh giá:"+ratingBar.getRating(), Toast.LENGTH_LONG).show();

                timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(SendFeedback.this, HomeActivity.class);
                        startActivity(intent);
                    }
                }, 1000);
            }
        });
    }
}