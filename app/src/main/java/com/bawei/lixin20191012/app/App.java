package com.bawei.lixin20191012.app;

import android.app.Application;
import android.content.Context;

public class App extends Application {
    public  static Context scontext;
    @Override
    public void onCreate() {
        super.onCreate();
        scontext=this;
    }
}
