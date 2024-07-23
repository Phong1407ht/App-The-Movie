package com.example.appthemovie.view.act;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBinding;

import com.example.appthemovie.R;
import com.example.appthemovie.view.OnMainCallBack;
import com.example.appthemovie.view.fragment.BaseFragment;

import java.lang.reflect.Constructor;

public abstract class BaseActivity<T extends ViewBinding,M extends ViewModel> extends AppCompatActivity implements OnMainCallBack {
    protected T binding;
    protected M viewmodel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = initViewBinding();
        viewmodel = new ViewModelProvider(this).get(initViewModel());
        setContentView(binding.getRoot());
        initView();
    }

    protected abstract Class<M> initViewModel();

    public void showFragment(String tag, Object data, boolean isBack) {
        try {
            Class<?> clazz = Class.forName(tag);  //Trỏ vào 1 fragment class
            Constructor<?> cons = clazz.getConstructor();
            BaseFragment<?, ?> frg = (BaseFragment<?, ?>) cons.newInstance(); //Tạo ra 1 thực thể từ lớp fragment
            frg.setData(data);
            frg.setCallBack(this);

            FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
            if (isBack) {
                trans.addToBackStack(null);//go back to previous screen
            }
            trans.replace(R.id.main, frg, tag).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected abstract void initView();

    protected abstract T initViewBinding();
}
