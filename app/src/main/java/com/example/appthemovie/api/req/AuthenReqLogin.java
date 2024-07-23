package com.example.appthemovie.api.req;

import com.google.gson.annotations.SerializedName;

public class AuthenReqLogin {
    public String username;
    public String password;
    @SerializedName("request_token")
    public String requestToken;

    public AuthenReqLogin(String password, String requestToken, String username) {
        this.password = password;
        this.requestToken = requestToken;
        this.username = username;
    }
}
