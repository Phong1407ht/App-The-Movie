package com.example.appthemovie.viewmodel;

import android.util.Log;

import com.example.appthemovie.api.ApiService;
import com.example.appthemovie.api.req.AuthenReqLogin;
import com.example.appthemovie.api.req.RequestToken;
import com.example.appthemovie.api.res.ResAuthen;
import com.example.appthemovie.api.res.ResSession;

public class M001LoginVM extends BaseViewModel {
    public static final String KEY_REQUEST_TOKEN = "KEY_REQUEST_TOKEN";
    public static final String KEY_CREATE_SESSION = "KEY_CREATE_SESSION";
    public static final String KEY_LOGIN = "KEY_LOGIN";
    private String userName, pass;
    private String requestToken;

    public void getUser(String userName, String pass) {
        this.userName = userName;
        this.pass = pass;

        ApiService apiService = getAPI().create(ApiService.class);
        apiService.requestToken().enqueue(initResponding(KEY_REQUEST_TOKEN));
    }

    private void login(String requestToken){
        ApiService apiService = getAPI().create(ApiService.class);
        apiService.login(new AuthenReqLogin(userName,pass,requestToken)).enqueue(initResponding(KEY_LOGIN));
    }

    private void createSession(String requestToken) {
        ApiService apiService = getAPI().create(ApiService.class);
        apiService.createSession(new RequestToken(requestToken)).enqueue(initResponding(KEY_CREATE_SESSION));
    }

    @Override
    protected <T> void handleSuccess(T data, String key) {
        switch (key){
            case KEY_REQUEST_TOKEN: {
                ResAuthen res = (ResAuthen) data;
                login(res.requestToken);
                break;
            }
            case KEY_LOGIN: {
                ResAuthen res = (ResAuthen) data;
                this.requestToken = res.requestToken;
                createSession(res.requestToken);
                break;
            }
            case KEY_CREATE_SESSION:{
                ResSession res = (ResSession) data;
                callBack.apiSuccess(new Object[]{res.sessionId,requestToken},key);
                break;
            }
        }
    }
}
