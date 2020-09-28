package com.qishui.android.utils;

import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.PermissionUtils;
import com.qishui.android.base.BaseApplication;

public class PermissionHandle {


    public static void requestCall() {
        PermissionUtils.permission(PermissionConstants.PHONE).callback(new PermissionUtils.SimpleCallback() {
            @Override
            public void onGranted() {
                ToastUtils.show(BaseApplication.getContext(), "有权限了!");
            }

            @Override
            public void onDenied() {
                ToastUtils.show(BaseApplication.getContext(), "没有权限了!");
            }
        }).request();
    }
}
