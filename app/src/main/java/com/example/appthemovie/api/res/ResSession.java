package com.example.appthemovie.api.res;

import com.google.gson.annotations.SerializedName;

public class ResSession {
    @SerializedName("session_id")
    public String sessionId;
    public boolean success;

    @Override
    public String toString() {
        return "ResSession{" +
                "sessionId='" + sessionId + '\'' +
                ", success=" + success +
                '}';
    }
}
