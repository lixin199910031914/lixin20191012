package com.bawei.lixin20191012.fragment;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.lixin20191012.HomePresenter;
import com.bawei.lixin20191012.R;
import com.bawei.lixin20191012.base.BaseFragment;
import com.bawei.lixin20191012.bean.LoginBean;
import com.bawei.lixin20191012.bean.RegisterBean;
import com.bawei.lixin20191012.contract.HomeContract;

public class UserFragment extends BaseFragment implements HomeContract.Iview {
    private static final String TAG = "UserFragment";
    private EditText edit_phone;
    private EditText edit_pwd;
    private Button zhu_button;
    private Button deng_button;
    private HomePresenter homePresenter;

    @Override
    protected int initLayout() {
        return R.layout.user_fragment;
    }

    @Override
    protected void initView(View view) {
        edit_phone = view.findViewById(R.id.edit_phone);
        edit_pwd = view.findViewById(R.id.edit_pwd);
        zhu_button = view.findViewById(R.id.zhu_button);
        deng_button = view.findViewById(R.id.deng_button);
        zhu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String zhu_phone = edit_phone.getText().toString();
                final String zhu_pwd = edit_pwd.getText().toString();
                zhu_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String zhu_phone = edit_phone.getText().toString();
                        String zhu_pwd = edit_pwd.getText().toString();
                        if (!zhu_phone.isEmpty()&&!zhu_phone.isEmpty()){
                            homePresenter.onZhu(zhu_phone,zhu_pwd);
                        }
                    }
                });
                deng_button.setOnClickListener(new View.OnClickListener() {
                    @Override

                    public void onClick(View v) {
                        if (!zhu_phone.isEmpty()&&!zhu_pwd.isEmpty()){
                            homePresenter.onDeng(zhu_phone,zhu_pwd);
                        }
                    }
                });
            }
        });
    }

    @Override
    protected void initData() {
        homePresenter = new HomePresenter();
        homePresenter.onBeangding(this);

    }

    @Override
    public void onRegisterCheng(RegisterBean data) {
        Log.d(TAG, "onRegisterCheng: "+data.getMessage());
        Toast.makeText(getContext(), data.getMessage(), Toast.LENGTH_SHORT).show();
        data.getMessage();
    }

    @Override
    public void onRegusterShiBai(String meg) {

    }

    @Override
    public void onLoginCheng(LoginBean data) {
        Log.d(TAG, "onLoginCheng: "+data);
        Toast.makeText(getContext(), "登录成功 ", Toast.LENGTH_SHORT).show();
        data.getMessage();

    }

    @Override
    public void onLoginShiBai(String meg) {

    }
}
