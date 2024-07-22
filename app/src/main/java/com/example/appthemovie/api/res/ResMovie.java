package com.example.appthemovie.api.res;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


public class ResMovie implements Serializable {
    public List<ResMovie.Result> results;

    public static class Result implements Serializable{
        @SerializedName("original_title")
        public String originalTitle;
        @SerializedName("overview")
        public String overview;
        @SerializedName("release_date")
        public String releaseDate;
        @SerializedName("poster_path")
        public String posterPath;
    }
}
