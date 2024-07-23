package com.example.appthemovie.api.req;

import com.google.gson.annotations.SerializedName;

public class RequestToken {
    @SerializedName("request_token")
    public String requestToken;

    public RequestToken(String requestToken) {
        this.requestToken = requestToken;
    }
}
