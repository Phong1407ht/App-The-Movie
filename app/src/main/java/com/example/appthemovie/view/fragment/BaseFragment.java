package com.example.appthemovie.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBinding;

import com.example.appthemovie.view.OnMainCallBack;
import com.example.appthemovie.viewmodel.BaseViewModel;
import com.example.appthemovie.viewmodel.OnAPICallBack;

public abstract class BaseFragment<B extends ViewBinding, V extends BaseViewModel> extends Fragment implements View.OnClickListener, OnAPICallBack {
    protected B binding;
    protected V viewmodel;
    protected Object mData;
    protected OnMainCallBack callBack;
    protected Context context;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    public void setData(Object data) {
        mData = data;
    }

    public void setCallBack(OnMainCallBack callBack) {
        this.callBack = callBack;
    }

    protected abstract void initView();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = initViewBinding(inflater, container);
        viewmodel = new ViewModelProvider(this).get(getClassViewModel());
        viewmodel.setAPICallBack(this);
        initView();
        return binding.getRoot();
    }

    protected abstract Class<V> getClassViewModel();

    @Override
    public void onClick(View view) {
        clickView(view);
    }

    protected void clickView(View view) {
    }

    protected abstract B initViewBinding(LayoutInflater inflater, ViewGroup container);

}
