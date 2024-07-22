package com.example.appthemovie.api;

import com.example.appthemovie.api.req.AuthenReqLogin;
import com.example.appthemovie.api.req.RequestToken;
import com.example.appthemovie.api.res.ResAuthen;
import com.example.appthemovie.api.res.ResMovie;
import com.example.appthemovie.api.res.ResSession;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    String API = "471d6fac58c1ce12dc1ba9502466d0a2";
    // https://www.themoviedb.org/3/
    @GET("authentication/token/new?api_key=" + API)
    Call<RequestToken> requestToken();

    @POST("authentication/session/new?api_key=" + API)
    Call<ResSession> createSession(@Body RequestToken requestToken);

    @POST("authentication/token/validate_with_login?api_key=" + API)
    Call<ResAuthen> login(@Body AuthenReqLogin authenReqLogin);

    @GET("https://api.themoviedb.org/3/discover/movie?api_key" + API)
    Call<ResMovie> getListMovie(@Query(value = "language") String lang);
}
