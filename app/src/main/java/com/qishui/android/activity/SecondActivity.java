package com.qishui.android.activity;

import com.qishui.android.R;
import com.qishui.android.base.BaseActivity;

public class SecondActivity extends BaseActivity {

    public static String LAYOUTID = "layoutid";

    @Override
    public int setLayoutID() {

        return getIntent().getIntExtra(LAYOUTID, R.layout.activity_second);
    }

    @Override
    public void setEvent() {

    }
}
