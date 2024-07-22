package com.example.appthemovie.view.fragment;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.appthemovie.databinding.M000SplashFrgBinding;
import com.example.appthemovie.viewmodel.CommonVN;

public class M000SplashFrg extends BaseFragment<M000SplashFrgBinding, CommonVN> {
    public static final String TAG = M000SplashFrg.class.getName();

    private void gotoMainScreen() {
        callBack.showFragment(M001LoginFrg.TAG, null, false);
    }

    @Override
    protected void initView() {
        Log.e(TAG, "InitView.....");
        new Handler().postDelayed(this::gotoMainScreen, 2000);
    }

    @Override
    protected Class<CommonVN> getClassViewModel() {
        return CommonVN.class;
    }

    protected M000SplashFrgBinding initViewBinding(@NonNull LayoutInflater inflater,
                                                   @Nullable ViewGroup container) {
        return M000SplashFrgBinding.inflate(inflater, container, false);
    }


    @Override
    public void apiSuccess(Object data, String key) {

    }

    @Override
    public void apiFailed(Object error, String key, int code) {

    }

    @Override
    public void apiException(Throwable error, String key) {

    }


}
