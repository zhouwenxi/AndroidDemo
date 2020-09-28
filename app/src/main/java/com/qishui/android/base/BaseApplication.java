package com.qishui.android.base;

import android.app.Application;
import android.content.Context;

import org.xutils.x;

public class BaseApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        x.Ext.init(this);
    }

    /**
     * 获取
     * @return
     */
    public static Context getContext() {
        return context;
    }
}
