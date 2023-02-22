package com.example.tennis_booking_app.ViewModels.Login;

public class LoginRequest {
    private String Username;
    private String Password;
    private boolean AutoSignIn;
    private int ClientId;

    public LoginRequest() {

    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public boolean isAutoSignIn() {
        return AutoSignIn;
    }

    public void setAutoSignIn(boolean autoSignIn) {
        AutoSignIn = autoSignIn;
    }

    public int getClientId() {
        return ClientId;
    }

    public void setClientId(int clientId) {
        ClientId = clientId;
    }

    public LoginRequest(String username, String password, boolean autoSignIn, int clientId) {
        Username = username;
        Password = password;
        AutoSignIn = autoSignIn;
        ClientId = clientId;
    }
}
