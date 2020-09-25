package com.qishui.android.Activity;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;

import com.qishui.android.R;
import com.qishui.android.base.BaseActivity;
import com.qishui.android.utils.FileUtils;

/**
 * 主页面
 */
public class MainActivity extends BaseActivity {
    @Override
    public int setLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public void setEvent() {

        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showToast("点击....");
                setSampleLayout(R.layout.linear_sample);
            }
        });

        findViewById(R.id.btn4).setOnClickListener(new MyOnClickListener());

        findViewById(R.id.btn5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText et = findViewById(R.id.et);
                String content = getEditText(et);
                FileUtils.sd();

            }
        });
    }

    /**
     * 点击事件
     *
     * @param view
     */
    public void click(View view) {

        EditText et = findViewById(R.id.et);
        String content = getEditText(et);

        switch (view.getId()) {
            case R.id.btn2:
                showToast("点击2222...." + content);
                setSampleLayout(R.layout.relative_sample);
                break;
            case R.id.btn3:
                showToast("点击3333..." + content);
                setSampleLayout(R.layout.frag_sample);
                break;
        }

    }

    /**
     * 外部类
     */
    class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            showToast("点击4444...");

        }
    }


    public void setSampleLayout(int layoutID) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra(SecondActivity.LAYOUTID, layoutID);
        startActivity(intent);
    }
}
