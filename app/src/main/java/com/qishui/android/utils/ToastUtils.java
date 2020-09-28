package com.qishui.android.utils;

import android.content.Context;
import android.widget.Toast;

import com.qishui.android.base.BaseApplication;

public class ToastUtils {

    /**
     * 提示
     *
     * @param context
     * @param msg
     */
    public static void show(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }

    public static void show( String msg) {
        Toast.makeText(BaseApplication.getContext(), msg, Toast.LENGTH_LONG).show();
    }
}
