package com.example.tennis_booking_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tennis_booking_app.Clients.ApiClient;
import com.example.tennis_booking_app.Models.Token;
import com.example.tennis_booking_app.ViewModels.Login.LoginRequest;
import com.example.tennis_booking_app.ViewModels.Login.LoginResponse;
import com.example.tennis_booking_app.activity.home.HomeActivity;
import com.google.gson.Gson;

import java.io.Serializable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StartsActivity extends AppCompatActivity {
    private EditText etUsername;
    private EditText etPassword;
    private Button btnContinue;
    private TextView tvforgotPassword;
    LoadingDialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starts);

        etUsername = (EditText) findViewById(R.id.txtUsername);
        etPassword = (EditText) findViewById(R.id.txtPassword);
        btnContinue = (Button) findViewById(R.id.btnLoginAcocunt);
        loadingDialog = new LoadingDialog(StartsActivity.this);

//        tvforgotPassword.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(StartsActivity.this, Retrieval.class);
//                startActivity(intent);
//            }
//        });

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etUsername.getText().toString()) || TextUtils.isEmpty(etPassword.getText().toString())) {
                    Toast.makeText(StartsActivity.this, "Username / Password Required", Toast.LENGTH_LONG).show();
                } else {
                    login();
                }
            }
        });

    }

    public void login() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(etUsername.getText().toString());
        loginRequest.setPassword(etPassword.getText().toString());
        System.out.println("username + password " + etUsername.getText().toString() + " - " + etPassword.getText().toString());
        loginRequest.setClientId(3);
        loginRequest.setAutoSignIn(true);

        Call<LoginResponse> loginResponseCall = ApiClient.getUserService().userLogin(loginRequest);
        loadingDialog.startLoadingDialog();
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                if (response.isSuccessful()) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            loadingDialog.dissmisDialog();
                        }
                    }, 1500);

                    Toast.makeText(StartsActivity.this, response.body().getMessage(), Toast.LENGTH_LONG).show();
                    LoginResponse loginResponse = response.body();
                    Token token = loginResponse.getToken();

                    // save token to shared preferent
                    SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", 0);
                    SharedPreferences.Editor myEdit = sharedPreferences.edit();

                    Gson gson = new Gson();
                    String json = gson.toJson(token);
                    myEdit.putString("TOKEN", json);
                    myEdit.commit(); // save to shared preference

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
//                            startActivity(new Intent(StartsActivity.this, HomeActivity.class)putExtra("data", loginResponse.getToken().getUserName()));
                            Intent intent = new Intent(StartsActivity.this, HomeActivity.class);
                            intent.putExtra("data", loginResponse.getToken().getFullName());
                            startActivity(intent);
                        }
                    }, 700);

                } else {
                    Toast.makeText(StartsActivity.this, "Login Failed", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(StartsActivity.this, "Throwable " + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });


    }

    public void onLoginClick(View View) {
        startActivity(new Intent(this, HomeActivity.class));
        overridePendingTransition(R.anim.slide_in_right, R.anim.stay);
    }
}