package com.qishui.android.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;

import com.qishui.android.utils.L;

public class ScreenReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();
        if (Intent.ACTION_SCREEN_OFF.equals(action)) {
            L.e("屏幕关闭");
        } else if (Intent.ACTION_SCREEN_ON.equals(action)) {
            L.e("屏幕打开");
        } else if (Intent.ACTION_BATTERY_CHANGED.equals(action)) {
            int currLevel = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);//当前电量
            int total = intent.getIntExtra(BatteryManager.EXTRA_SCALE, 1);//总电量
            int percent = currLevel * 100 / total;
            L.e("电量变化:" + percent + "%");
        }


    }
}
