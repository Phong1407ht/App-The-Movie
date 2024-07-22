package com.example.appthemovie.view.fragment;

import static com.example.appthemovie.viewmodel.M001LoginVM.KEY_CREATE_SESSION;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.appthemovie.R;
import com.example.appthemovie.databinding.M001LoginFrgBinding;
import com.example.appthemovie.viewmodel.M001LoginVM;

public class M001LoginFrg extends BaseFragment<M001LoginFrgBinding, M001LoginVM>{
    public static final String TAG = M001LoginFrg.class.getName();
    @Override
    protected void initView() {
        Log.e(TAG,"InitViewLogin.....");
        binding.btLogin.setOnClickListener(this);
    }

    @Override
    protected Class<M001LoginVM> getClassViewModel() {
        return M001LoginVM.class;
    }

    @Override
    protected void clickView(View view) {
        if(view.getId() == R.id.bt_login){
            String userName = binding.edtUserName.getText().toString();
            String pass = binding.edtPass.getText().toString();
        if(userName.trim().isEmpty() || pass.trim().isEmpty()){
            Toast.makeText(context,"Username or password is Empty!!",Toast.LENGTH_SHORT).show();
            return;
            }
        viewmodel.getUser(userName,pass);
        }
    }

    @Override
    protected M001LoginFrgBinding initViewBinding(LayoutInflater inflater, ViewGroup container) {
        return M001LoginFrgBinding.inflate(inflater,container,false);
    }
    @Override
    public void apiSuccess(Object data, String key) {
        if (key.equals(KEY_CREATE_SESSION)) {
            String sessionId = (String) ((Object[]) data)[0];
            String reqToken = (String) ((Object[]) data)[1];

            Toast.makeText(context, "Login is successfully!", Toast.LENGTH_SHORT).show();
            callBack.showFragment(M002ListMovieFrg.TAG, null, false);
        }
    }

    @Override
    public void apiFailed(Object error, String key, int code) {
        if (code == 401) {
            Toast.makeText(context, "Username or password is invalid", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, key + "-Error " + error, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void apiException(Throwable error, String key) {

    }

}
