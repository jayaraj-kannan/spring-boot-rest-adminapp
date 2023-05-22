package com.expense.app.Model;

import org.springframework.security.core.userdetails.UserDetails;

public class LoginResponse {

    private String token;
    private UserDetails userDetails;

    // Constructors, getters, and setters

    public LoginResponse() {
    }

    public LoginResponse(String token, UserDetails userDetails) {
        this.token = token;
        this.userDetails = userDetails;
    }

    // Getters and setters

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }
}
