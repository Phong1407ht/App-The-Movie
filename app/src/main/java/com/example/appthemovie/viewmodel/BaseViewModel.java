package com.example.appthemovie.viewmodel;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class BaseViewModel extends ViewModel {
    protected OnAPICallBack callBack;
    private static final String BASE_URL = "https://api.themoviedb.org/3/";

    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    public void setAPICallBack(OnAPICallBack callBack) {
        this.callBack = callBack;
    }

    protected Retrofit getAPI() {
        Retrofit.Builder builder = new Retrofit.Builder();
        OkHttpClient okhttp = new OkHttpClient.Builder()
                .callTimeout(30, TimeUnit.SECONDS).build();
        return builder.baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okhttp).build();
    }

    protected <T> Callback<T> initResponding(String key) {
        return new Callback<T>() {
            @Override
            public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {
                if (response.code() != 200 || response.body() == null) {
                    handleFailed(response, key);
                } else {
                    handleSuccess(response.body(), key);
                }
            }

            @Override
            public void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
                handleException(call, t, key);
            }
        };
    }

    protected  <T> void handleException(Call<T> call, Throwable t, String key) {
        callBack.apiException(t,key);
    }

    protected  <T> void handleSuccess(T data, String key) {
        callBack.apiSuccess(data,key);
    }

    protected  <T> void handleFailed(Response<T> response, String key) {
        ResponseBody rs = response.errorBody();
        try {
            callBack.apiFailed(rs == null ? null : rs.string(), key, response.code());
        } catch (Exception e) {
            e.printStackTrace();
            callBack.apiException(e.fillInStackTrace(), key);
        }
    }
}
