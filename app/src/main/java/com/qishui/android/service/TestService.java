package com.qishui.android.service;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

import androidx.annotation.Nullable;

import com.qishui.android.receiver.ScreenReceiver;
import com.qishui.android.utils.L;

public class TestService extends Service {

    private ScreenReceiver receiver;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        L.e("TestService onCreate");

        //1.创建广播接收者对象
        receiver = new ScreenReceiver();
        //2.创建intent-filter对象
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        filter.addAction(Intent.ACTION_SCREEN_ON);

        //监听电量变化
        filter.addAction(Intent.ACTION_BATTERY_CHANGED);

        //3.注册广播接收者
        registerReceiver(receiver, filter);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        L.e("TestService onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        L.e("TestService onDestroy");
        super.onDestroy();
        //解除注册
        unregisterReceiver(receiver);
    }
}
