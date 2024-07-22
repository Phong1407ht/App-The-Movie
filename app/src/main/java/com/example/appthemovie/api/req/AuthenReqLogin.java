package com.example.appthemovie.api.req;

public class AuthenReqLogin {
    public String username;
    public String password;
    public String request_token;

    public AuthenReqLogin(String password, String request_token, String username) {
        this.password = password;
        this.request_token = request_token;
        this.username = username;
    }
}
