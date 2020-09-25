package com.qishui.android.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.qishui.android.utils.ToastUtils;


/**
 * 基类
 */
public abstract class BaseActivity extends AppCompatActivity {

    public Activity mActivity;
    private Context context;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = BaseActivity.this;
        context = getApplicationContext();
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

    /**
     * 获取Activity
     *
     * @return
     */
    public Activity getmActivity() {
        return mActivity;
    }

    /**
     * 获取context
     *
     * @return
     */
    public Context getContext() {
        return context;
    }

    /**
     * 提示框
     *
     * @param msg
     */
    public void showToast(String msg) {
        ToastUtils.show(mActivity, msg);
    }

    /**
     * 获取控件字符串
     *
     * @param tv
     * @return
     */
    public String getTextView(TextView tv) {
        return tv == null ? "" : tv.getText().toString().trim();
    }

    /**
     * 获取控件字符串
     *
     * @param et
     * @return
     */
    public String getEditText(EditText et) {
        return et == null ? "" : et.getText().toString().trim();
    }

}
