package com.example.appthemovie.viewmodel;

public interface OnAPICallBack {
    void apiSuccess(Object data,String key);
    void apiFailed(Object error, String key, int code);
    void apiException(Throwable error ,String key);
}
