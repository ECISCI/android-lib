package com.mincat.sample.utils;

import android.app.Activity;
import android.content.Intent;

import com.mincat.sample.R;


/**
 *
 * @author Ming
 * @描述 页面跳转逻辑
 * @简介 使用Activity的时 如果按照系统样式启动 会出现短暂的黑屏
 * <p>
 * 所以我们要在Style的主体样式(theme)中加上 <item
 * name="android:windowIsTranslucent">true</item>
 * <p>
 * 如果这样我们就必须手动去填写 overridePendingTransition 来控制Activity的启动样式
 * <p>
 * 单利设计模式
 */
public class IntentUtils {

    public static final String TAG = IntentUtils.class.getName();
    private Intent intent;

    // 创建本类的静态对象
    private static IntentUtils utils = new IntentUtils();

    // 构造函数私有化 不允许创建对象
    private IntentUtils() {

    }

    // 对外提供一个可以创建本类对象的方法
    public static IntentUtils getInstance() {

        return utils;
    }

    /**
     * @param activity 当前Activity
     * @param cl       指定Activity
     * @描述 Activity跳转 右 → 左 滑入
     * @注意 两个参数的Activity必须在清单文件中注册
     */
    public void openActivityFromRight(Activity activity, Class<?> cl) {

        intent = new Intent(activity, cl);
        activity.startActivity(intent);
        activitySlideRight(activity);

    }

    /**
     * @param activity 当前Activity
     * @param cl       指定Activity
     * @描述 Activity 跳转底部划入 底 → 顶
     * @注意 两个参数的Activity必须在清单文件中注册
     */
    public void openActivityFromBottom(Activity activity, Class<?> cl) {

        intent = new Intent(activity, cl);
        activity.startActivity(intent);
        activitySlideBottom(activity);

    }

    /**
     * @param activity 当前Activity
     * @param cl       指定Activity
     * @注意 两个参数的Activity必须在清单文件中注册
     */
    public void openActivityNormal(Activity activity, Class<?> cl) {
        intent = new Intent(activity, cl);
        activity.startActivity(intent);
    }

    /**
     * @描述 启动Activity 右→左滑入
     */
    public void activitySlideRight(Activity activity) {

        activity.overridePendingTransition(R.anim.slide_in_left,
                R.anim.slide_in_right);
    }

    /**
     * @描述 启动Activity 底→顶滑入
     */
    public void activitySlideBottom(Activity activity) {
        activity.overridePendingTransition(R.anim.slide_bottom_in,
                R.anim.slide_bottom_out);
    }

    /**
     * @param activity   当前Activity
     * @param cl         指定Activity
     * @param paramName  参数名
     * @param paramValue 参数值
     * @描述 Activity跳转 右 → 左 滑入 携带参数
     * @注意 两个参数的Activity必须在清单文件中注册
     */
    public void openActivityFromRightCarryingParameters(Activity activity, Class<?> cl, String[] paramName, String[] paramValue) {

        intent = new Intent(activity, cl);


        if (paramName.length == 0)
            throw new IllegalArgumentException("参数名必须非空");
        if (paramValue.length == 0)
            throw new IllegalArgumentException("参数值必须非空");
        if (paramName.length != paramValue.length)
            throw new IllegalArgumentException("参数长度与参数值长度不相同");

        for (int i = 0; i < paramName.length; i++) {

            intent.putExtra(paramName[i], paramValue[i]);
        }

        activity.startActivity(intent);
        activitySlideRight(activity);

    }

    /**
     * @param activity 当前Activity
     * @param cl       指定Activity
     * @描述 打开Activity并获取请求结果
     */
    public void openActivityFromRightForResult(Activity activity, Class<?> cl, int requestCode) {

        intent = new Intent(activity, cl);

        activity.startActivityForResult(intent, requestCode);

        activitySlideRight(activity);

    }


}
