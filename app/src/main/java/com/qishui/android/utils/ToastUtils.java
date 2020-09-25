package com.qishui.android.utils;

import android.content.Context;
import android.widget.Toast;

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
}
