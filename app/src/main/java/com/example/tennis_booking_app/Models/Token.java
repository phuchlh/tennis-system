package com.example.tennis_booking_app.Models;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Token {
    private int UserId;
    private String UserName;
    private String FullName;
    private String AccessToken;
    private String RefreshToken;
    private String AccessTokenExp;
    private String RefreshTokenExp;
    ArrayList<Integer> RoleIds = new ArrayList<>();
    private String PhoneNumber;
    private String Avatar;
    private String Email;

    public Token(int userId, String userName, String fullName, String accessToken, String refreshToken, String accessTokenExp, String refreshTokenExp, ArrayList<Integer> roleIds, String phoneNumber, String avatar, String email) {
        UserId = userId;
        UserName = userName;
        FullName = fullName;
        AccessToken = accessToken;
        RefreshToken = refreshToken;
        AccessTokenExp = accessTokenExp;
        RefreshTokenExp = refreshTokenExp;
        RoleIds = roleIds;
        PhoneNumber = phoneNumber;
        Avatar = avatar;
        Email = email;
    }

    public Token() {

    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getAccessToken() {
        return AccessToken;
    }

    public void setAccessToken(String accessToken) {
        AccessToken = accessToken;
    }

    public String getRefreshToken() {
        return RefreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        RefreshToken = refreshToken;
    }

    public String getAccessTokenExp() {
        return AccessTokenExp;
    }

    public void setAccessTokenExp(String accessTokenExp) {
        AccessTokenExp = accessTokenExp;
    }

    public String getRefreshTokenExp() {
        return RefreshTokenExp;
    }

    public void setRefreshTokenExp(String refreshTokenExp) {
        RefreshTokenExp = refreshTokenExp;
    }

    public ArrayList<Integer> getRoleIds() {
        return RoleIds;
    }

    public void setRoleIds(ArrayList<Integer> roleIds) {
        RoleIds = roleIds;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getAvatar() {
        return Avatar;
    }

    public void setAvatar(String avatar) {
        Avatar = avatar;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
