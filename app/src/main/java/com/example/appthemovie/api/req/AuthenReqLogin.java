package com.example.appthemovie.api.req;

import com.google.gson.annotations.SerializedName;

public class AuthenReqLogin {
    @SerializedName("username")
    public String userName;
    @SerializedName("password")
    public String password;
    @SerializedName("request_token")
    public String requestToken;

    public AuthenReqLogin(String password, String requestToken, String userName) {
        this.password = password;
        this.requestToken = requestToken;
        this.userName = userName;
    }
}
