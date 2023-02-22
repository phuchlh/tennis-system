package com.example.tennis_booking_app.ViewModels.Login;


public class LoginResponse {
    private int StatusCode;
    private  String Message;
    com.example.tennis_booking_app.Models.Token Token;

    public LoginResponse(int statusCode, String message, com.example.tennis_booking_app.Models.Token token) {
        StatusCode = statusCode;
        Message = message;
        Token = token;
    }

    public int getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(int statusCode) {
        StatusCode = statusCode;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public com.example.tennis_booking_app.Models.Token getToken() {
        return Token;
    }

    public void setToken(com.example.tennis_booking_app.Models.Token token) {
        Token = token;
    }
}
