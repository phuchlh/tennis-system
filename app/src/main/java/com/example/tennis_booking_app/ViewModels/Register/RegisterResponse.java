package com.example.tennis_booking_app.ViewModels.Register;

public class RegisterResponse {
    private boolean status;

    public RegisterResponse(boolean status) {
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
