package com.example.appthemovie.viewmodel;


import androidx.lifecycle.MutableLiveData;

import com.example.appthemovie.api.ApiService;
import com.example.appthemovie.api.res.ResMovie;

public class M002ListMovieVM extends BaseViewModel {
    private static final String KEY_GET_LIST_MOVIE = "KEY_GET_LIST_MOVIE";
    private final MutableLiveData<ResMovie> resMovie = new MutableLiveData<>();

    public MutableLiveData<ResMovie> getResMovie() {
        return resMovie;
    }

    public void setListMovie(ResMovie data) {
        resMovie.postValue(data);
    }

    public void getListMovie() {
        ApiService apiService = getAPI().create(ApiService.class);
        apiService.getListMovie("en-US").enqueue(initResponding(KEY_GET_LIST_MOVIE));
    }
}
