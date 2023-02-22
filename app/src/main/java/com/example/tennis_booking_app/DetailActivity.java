package com.example.tennis_booking_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView txtTenSan, txtSanSoBaoNhieu;
    ImageView imgHinhSan;
    Intent intent;
    Button btnDanhGia, btnHuy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txtTenSan = (TextView) findViewById(R.id.txtTenSan);
        txtSanSoBaoNhieu = (TextView) findViewById(R.id.txtSanSoBaoNhieu);
        imgHinhSan = (ImageView) findViewById(R.id.imgHinhSan);
        btnDanhGia = (Button)findViewById(R.id.btnDanhGia);
        btnHuy = (Button)findViewById(R.id.btnHuy);
        intent = getIntent();

        History history = (History) intent.getSerializableExtra("detailBooking");

        txtTenSan.setText(history.getTen());
        btnDanhGia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this,SendFeedback.class);
                startActivity(intent);
            }
        });
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this,HuySan.class);
                startActivity(intent);
            }
        });
    }
}