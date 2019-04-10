package com.example.testgreendao.daohelper;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.testgreendao.entity.DaoMaster;
import com.example.testgreendao.entity.DaoSession;

import org.greenrobot.greendao.AbstractDaoMaster;

public class GreendaoUtil {

    private static DaoMaster.DevOpenHelper mHelper;
    private static SQLiteDatabase mDb;
    private static DaoMaster mDaomaster;
    private static DaoSession mDaoSession;

    private static GreendaoUtil mInstance;

    public static GreendaoUtil getmInstance() {
        if (mInstance == null) {
            synchronized (GreendaoUtil.class) {
                if (mInstance == null) {
                    mInstance = new GreendaoUtil();
                }
            }
        }
        return mInstance;
    }
    public static void initDataBase(Context context){
        mHelper=new DaoMaster.DevOpenHelper(context,"school.db",null);
        mDb=mHelper.getWritableDatabase();
        mDaomaster=new DaoMaster(mDb);
        mDaoSession=mDaomaster.newSession();
    }
    public DaoSession getDaoSession(){
        return mDaoSession;
    }

}
