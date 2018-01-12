package com.mincat.sample.utils;

import android.app.Activity;
import android.content.Context;
import android.view.WindowManager;

/**
 * @author Michael
 * @描述 获取屏幕信息
 */

public class GetScreenParam {

    private static WindowManager wm;

    private static int width;

    private static int height;

    /**
     * 获取屏幕宽度
     *
     * @param activity
     * @return
     */
    public static int getScreenWidth(Activity activity) {


        wm = (WindowManager) activity.
                getSystemService(Context.WINDOW_SERVICE);

        width = wm.getDefaultDisplay().getWidth();

        return width;
    }

    /**
     * 获取屏幕高度
     *
     * @param activity
     * @return
     */
    public static int getScreenHeight(Activity activity) {


        wm = (WindowManager) activity.
                getSystemService(Context.WINDOW_SERVICE);

        height = wm.getDefaultDisplay().getHeight();

        return height;

    }
}
