package com.example.appthemovie.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.appthemovie.R;
import com.example.appthemovie.api.res.ResMovie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {
    private final List<ResMovie.Result> listMovie;
    private final Context context;

    public MovieAdapter(Context context, List<ResMovie.Result> listMovie) {
        this.context = context;
        this.listMovie = listMovie;
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        return new MovieHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int position) {
        ResMovie.Result item = listMovie.get(position);
        holder.tvTitle.setText(item.originalTitle);
        holder.tvDate.setText(item.releaseDate);
        holder.tvDesc.setText(item.overview);
        Glide.with(context).load(String.format("https://image.tmdb.org/t/p/w600_and_h900_bestv2",item.posterPath)).centerCrop().into(holder.ivPhoto);
    }

    @Override
    public int getItemCount() {
        if(listMovie != null){
            return listMovie.size();
        }
        return 0;
    }


    public static class MovieHolder extends RecyclerView.ViewHolder{
        TextView tvTitle,tvDate,tvDesc;
        ImageView ivPhoto;

        public MovieHolder(@NonNull View v) {
            super(v);
            tvTitle = v.findViewById(R.id.tv_title);
            tvDate = v.findViewById(R.id.tv_date);
            tvDesc = v.findViewById(R.id.tv_desc);
            ivPhoto = v.findViewById(R.id.iv_photo);
        }
    }
}
