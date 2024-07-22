package com.example.appthemovie.view.act;

import com.example.appthemovie.databinding.ActivityHomeBinding;
import com.example.appthemovie.view.fragment.M000SplashFrg;
import com.example.appthemovie.viewmodel.CommonVN;

public class HomeActivity extends BaseActivity<ActivityHomeBinding, CommonVN>{
    @Override
    protected void initView() {showFragment(M000SplashFrg.TAG,null,false);
    }

    @Override
    protected ActivityHomeBinding initViewBinding() {
        return ActivityHomeBinding.inflate(getLayoutInflater());
    }
}
