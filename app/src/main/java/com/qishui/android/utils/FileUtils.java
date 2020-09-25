package com.qishui.android.utils;

import android.os.Environment;

import com.qishui.android.base.BaseApplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class FileUtils {

    //内部文件
    private static String dir = BaseApplication.getContext().getFilesDir().getAbsolutePath();

    public static void sd() {
        //SD卡路径
        String state = Environment.getExternalStorageState();
        String directory=Environment.getDataDirectory().getAbsolutePath();
        L.e(state+" "+directory);
    }


    public static void write(String s) {
        String path = dir + "/info.txt";
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(new File(path));
            outputStream.write(s.getBytes("utf-8"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
