package com.bawei.lixin20191012;



import com.bawei.lixin20191012.bean.GreenDaoBean;
import com.bawei.lixin20191012.bean.LoginBean;
import com.bawei.lixin20191012.bean.RegisterBean;
import com.bawei.lixin20191012.contract.HomeContract;
import com.bawei.lixin20191012.ustil.GreenDaoUstil;
import com.bawei.lixin20191012.ustil.RetrofitUtil;
import com.example.tianmei.myapplication.greendao.gen.DaoSession;
import com.example.tianmei.myapplication.greendao.gen.GreenDaoBeanDao;


import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomeModle implements HomeContract.Imodle {

    private Observer<RegisterBean> observer;
    private Observer<LoginBean> observer01;
    private Observable<LoginBean> login;
    private Observable<RegisterBean> register;

    //注册
    @Override
    public void onZhuCheng(String phone, String pwd, final DataICallBack dataICallBack) {
        register = RetrofitUtil.getApiServer().register(phone, pwd);
        observer = new Observer<RegisterBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(RegisterBean registerBean) {
                dataICallBack.onRegisterCheng(registerBean);
            }

            @Override
            public void onError(Throwable e) {
                dataICallBack.onShiBai(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        };
        register.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }
    //登录
    @Override
    public void onDengCheng(String phone, String pwd, final DataICallBack dataICallBack) {
        login = RetrofitUtil.getApiServer().login(phone, pwd);
        observer01 = new Observer<LoginBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(LoginBean loginBean) {
                dataICallBack.onLoginCheng(loginBean);
                LoginBean.ResultBean result = loginBean.getResult();
                DaoSession daoSession = new GreenDaoUstil().setDatabase();
                GreenDaoBeanDao greenDaoBeanDao = daoSession.getGreenDaoBeanDao();
                greenDaoBeanDao.insert(new GreenDaoBean(null,result.getHeadPic(), result.getNickName(), result.getPhone(), result.getSessionId(), result.getSex(), result.getUserId()));
                List<GreenDaoBean> list = greenDaoBeanDao.queryBuilder()
                        .where(GreenDaoBeanDao.Properties.Id.eq(1))
                        .build().list();

            }

            @Override
            public void onError(Throwable e) {
                dataICallBack.onShiBai(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        };
        login.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer01);
    }
}
