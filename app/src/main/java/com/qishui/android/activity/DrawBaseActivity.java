package com.qishui.android.activity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.qishui.android.R;
import com.qishui.android.base.BaseActivity;

/**
 * 绘制基础
 */
public class DrawBaseActivity extends BaseActivity {

    int startX;
    int startY;
    Canvas canvas;
    Paint paint;
    ImageView iv;

    @Override
    public int setLayoutID() {
        return R.layout.activity_draw_base;
    }


    @Override
    public void setEvent() {

        iv = findViewById(R.id.iv);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bg2);
        Bitmap copyBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());

        paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(10);

        canvas = new Canvas(copyBitmap);

        canvas.drawBitmap(bitmap, new Matrix(), paint);

        iv.setImageBitmap(copyBitmap);

        drawBg(copyBitmap);
    }

    @SuppressLint("ClickableViewAccessibility")
    private void drawBg(final Bitmap copyBitmap) {
        iv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {

                    case MotionEvent.ACTION_DOWN:

                        startX = (int) event.getX();
                        startY = (int) event.getY();

                        break;
                    case MotionEvent.ACTION_MOVE:
                        int x = (int) event.getX();
                        int y = (int) event.getY();
                        canvas.drawLine(startX, startY, x, y, paint);
                        startX = x;
                        startY = y;
                        iv.setImageBitmap(copyBitmap);

                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                    default:
                        break;
                }
                //true，自己处理，false，不处理，向上传递。
                return true;
            }
        });
    }
}
