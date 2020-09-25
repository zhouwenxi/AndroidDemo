package com.qishui.android.base;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


/**
 * 基类
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutID());
        setEvent();
    }

    /**
     * 设置布局ID
     *
     * @return
     */
    public abstract int setLayoutID();

    /**
     * 设置事件
     */
    public abstract void setEvent();
}
