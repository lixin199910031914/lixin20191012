package com.bawei.lixin20191012.ustil;



import com.bawei.lixin20191012.bean.LoginBean;
import com.bawei.lixin20191012.bean.RegisterBean;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiServer {
    //登录
    @POST("user/v1/login")
    Observable<LoginBean> login(@Query("phone") String phone, @Query("pwd")  String pwd);
    //注册
    @POST("user/v1/register")
    Observable<RegisterBean> register(@Query("phone") String phone, @Query("pwd")  String pwd);
}
