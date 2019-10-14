package com.bawei.lixin20191012.contract;

import com.bawei.lixin20191012.bean.LoginBean;
import com.bawei.lixin20191012.bean.RegisterBean;

public interface  HomeContract {
    interface  Iview{
        void  onRegisterCheng(RegisterBean data);
        void onRegusterShiBai(String meg);
        void  onLoginCheng(LoginBean data);
        void  onLoginShiBai(String meg);
    }
    interface Imodle{
        void  onZhuCheng(String phone,String pwd,DataICallBack dataICallBack);
        void  onDengCheng(String phone,String pwd,DataICallBack dataICallBack);
        interface  DataICallBack{
            void  onRegisterCheng(RegisterBean data);
            void  onLoginCheng(LoginBean data);
            void onShiBai(String e);
        }
    }
        interface  Ipresenter{
            //绑定
            void onBeangding(HomeContract.Iview view);
            //解绑
            void  onJianBang();
            //初始化注册
            void  onZhu(String phone,String pwd);
            void  onDeng(String phone,String pwd);
        }
}
