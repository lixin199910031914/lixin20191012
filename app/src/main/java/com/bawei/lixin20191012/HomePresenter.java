package com.bawei.lixin20191012;

import com.bawei.lixin20191012.bean.LoginBean;
import com.bawei.lixin20191012.bean.RegisterBean;
import com.bawei.lixin20191012.contract.HomeContract;

import java.lang.ref.WeakReference;

public class HomePresenter implements HomeContract.Ipresenter {

    private HomeModle homeModle;
    private WeakReference<HomeContract.Iview> iviewWeakReference;

    @Override
    public void onBeangding(HomeContract.Iview view) {
        homeModle = new HomeModle();
        iviewWeakReference = new WeakReference<>(view);
    }
    public HomeContract.Iview getView(){
        return iviewWeakReference.get();
    }

    @Override
    public void onJianBang() {
        if (iviewWeakReference != null) {
            iviewWeakReference.clear();
            iviewWeakReference=null;
        }
    }
    //注册
    @Override
    public void onZhu(String phone, String pwd) {
        homeModle.onZhuCheng(phone, pwd, new HomeContract.Imodle.DataICallBack() {
            @Override
            public void onRegisterCheng(RegisterBean data) {
            getView().onRegisterCheng(data);
            }

            @Override
            public void onLoginCheng(LoginBean data) {

            }

            @Override
            public void onShiBai(String e) {
                getView().onRegusterShiBai(e);
            }
        });
    }
    //登录
    @Override
    public void onDeng(String phone, String pwd) {
        homeModle.onDengCheng(phone, pwd, new HomeContract.Imodle.DataICallBack() {
            @Override
            public void onRegisterCheng(RegisterBean data) {

            }

            @Override
            public void onLoginCheng(LoginBean data) {
            getView().onLoginCheng(data);
            }

            @Override
            public void onShiBai(String e) {
            getView().onLoginShiBai(e);
            }
        });
    }
}
