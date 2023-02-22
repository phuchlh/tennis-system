package com.example.tennis_booking_app;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tennis_booking_app.PhucHLH.ReadyLogin;

public class DangXuat extends AppCompatActivity {
    Button btDangxuat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_xuat);
        btDangxuat = (Button) findViewById(R.id.btDangxuat);
        btDangxuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogDX();
            }
        });
    }

    private void DialogDX(){
       Dialog dialog=new Dialog(this);
       dialog.setContentView(R.layout.dialog_dang_xuat);
       dialog.setCanceledOnTouchOutside(false);

       Button btYes=(Button) dialog.findViewById(R.id.btYes);
       Button btNo=(Button) dialog.findViewById(R.id.btNo);

       btYes.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(DangXuat.this, ReadyLogin.class);
               startActivity(intent);
           }
       });

       btNo.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               dialog.dismiss();
           }
       });

       dialog.show();
    }
}