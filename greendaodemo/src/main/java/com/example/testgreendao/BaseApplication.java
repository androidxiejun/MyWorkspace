package com.example.testgreendao;

import android.app.Application;

import com.example.testgreendao.daohelper.GreendaoUtil;

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        GreendaoUtil.initDataBase(this.getApplicationContext());
    }
}
