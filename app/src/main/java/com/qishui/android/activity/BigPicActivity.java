package com.qishui.android.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;

import com.qishui.android.R;
import com.qishui.android.base.BaseActivity;

/**
 * 加载大图片,按屏幕尺度缩放
 */
public class BigPicActivity extends BaseActivity {

    @Override
    public int setLayoutID() {
        return R.layout.activity_big_pic;
    }

    @Override
    public void setEvent() {

        //未做处理 java.lang.OutOfMemoryError
        //Bitmap bm =BitmapFactory.decodeResource(getResources(),R.drawable.dog);
        //ImageView iv = findViewById(R.id.iv);
        //iv.setImageBitmap(bm);
    }

    public void click(View v) {
        //解析图片时需要使用到的参数都封装在这个对象里了
        BitmapFactory.Options opt = new BitmapFactory.Options();
        //不为像素申请内存，只获取图片宽高
        opt.inJustDecodeBounds = true;
        //BitmapFactory.decodeFile("sdcard/dog.jpg", opt);
        BitmapFactory.decodeResource(getResources(),R.drawable.dog,opt);
        //拿到图片宽高
        int imageWidth = opt.outWidth;
        int imageHeight = opt.outHeight;

        Display dp = getWindowManager().getDefaultDisplay();
        //拿到屏幕宽高
        int screenWidth = dp.getWidth();
        int screenHeight = dp.getHeight();

        //计算缩放比例
        int scale = 1;
        int scaleWidth = imageWidth / screenWidth;
        int scaleHeight = imageHeight / screenHeight;
        if (scaleWidth >= scaleHeight && scaleWidth >= 1) {
            scale = scaleWidth;
        } else if (scaleWidth < scaleHeight && scaleHeight >= 1) {
            scale = scaleHeight;
        }

        //设置缩放比例
        opt.inSampleSize = scale;
        opt.inJustDecodeBounds = false;
        //Bitmap bm = BitmapFactory.decodeFile("sdcard/dog.jpg", opt);
        Bitmap bm =BitmapFactory.decodeResource(getResources(),R.drawable.dog,opt);
        ImageView iv = findViewById(R.id.iv);
        iv.setImageBitmap(bm);
    }
}
