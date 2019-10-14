package com.bawei.lixin20191012.ustil;


import android.database.sqlite.SQLiteDatabase;

import com.bawei.lixin20191012.app.App;
import com.example.tianmei.myapplication.greendao.gen.DaoMaster;
import com.example.tianmei.myapplication.greendao.gen.DaoSession;

public class GreenDaoUstil {

    private DaoMaster.DevOpenHelper devOpenHelper;
    private SQLiteDatabase writableDatabase;
    private DaoMaster daoMaster;

    /*  private DaoMaster.DevOpenHelper devOpenHelper;
            private SQLiteDatabase writableDatabase;
            private DaoMaster daoMaster;
            private DaoSession daoSession;

            public DaoSession setDatabase(){
                devOpenHelper = new DaoMaster.DevOpenHelper(App.scontext, "xuchenxi-db", null);
                writableDatabase = devOpenHelper.getWritableDatabase();
                daoMaster = new DaoMaster(writableDatabase);
                daoSession = daoMaster.newSession();
                return daoSession;
            }*/
  public DaoSession setDatabase(){
      devOpenHelper = new DaoMaster.DevOpenHelper(App.scontext, "lixin-db", null);
      writableDatabase = devOpenHelper.getWritableDatabase();
      daoMaster = new DaoMaster(writableDatabase);
      DaoSession daoSession = daoMaster.newSession();
      return  daoSession;
  }
}
