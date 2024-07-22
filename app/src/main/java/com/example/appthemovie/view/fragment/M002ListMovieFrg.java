package com.example.appthemovie.view.fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.appthemovie.api.res.ResMovie;
import com.example.appthemovie.databinding.M002ListmovieFrgBinding;
import com.example.appthemovie.view.adapter.MovieAdapter;
import com.example.appthemovie.viewmodel.M002ListMovieVM;

import java.util.List;

public class M002ListMovieFrg extends BaseFragment<M002ListmovieFrgBinding, M002ListMovieVM>{
    public static final String TAG = M002ListMovieFrg.class.getName();
    @Override
    protected void initView() {
    Log.i(TAG,"InitView ListMovie...");
    viewmodel.getListMovie();
    }

    @Override
    protected Class<M002ListMovieVM> getClassViewModel() {
        return M002ListMovieVM.class;
    }

    @Override
    protected M002ListmovieFrgBinding initViewBinding(LayoutInflater inflater, ViewGroup container) {
        return M002ListmovieFrgBinding.inflate(inflater,container,false);
    }

    @Override
    public void apiSuccess(Object data, String key) {
        ResMovie res = (ResMovie) data;
        viewmodel.setListMovie(res);
        if (res.results == null || res.results.isEmpty()) {
            Toast.makeText(context, "List movie is empty!", Toast.LENGTH_SHORT).show();
            return;
        }
        reloadListMovies(res.results);
    }

    @Override
    public void apiFailed(Object error, String key, int code) {

    }

    @Override
    public void apiException(Throwable error, String key) {

    }
    private void reloadListMovies(List<ResMovie.Result> results ){
        viewmodel.getResMovie().observe( this, resMovie -> {
            if (resMovie == null) return;
            binding.rvListMovie.setAdapter(new MovieAdapter(context,resMovie.results));
        });
    }
}
