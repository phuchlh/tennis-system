package com.example.tennis_booking_app.Models;

import java.util.List;

public class UserError {
    private String[] FullName;
    private String[] Username;
    private String[] PhoneNumber;
    private String[] Email;

    public UserError(String[] fullName, String[] username, String[] phoneNumber, String[] email) {
        FullName = fullName;
        Username = username;
        PhoneNumber = phoneNumber;
        Email = email;
    }

    public UserError() {
    }

    public String[] getEmail() {
        return Email;
    }

    public void setEmail(String[] email) {
        Email = email;
    }

    public String[] getFullName() {
        return FullName;
    }

    public void setFullName(String[] fullName) {
        FullName = fullName;
    }

    public String[] getUsername() {
        return Username;
    }

    public void setUsername(String[] username) {
        Username = username;
    }

    public String[] getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String[] phoneNumber) {
        PhoneNumber = phoneNumber;
    }
}
