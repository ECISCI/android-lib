package com.mincat.sample.app;

import android.app.Application;
import android.os.Build;
import android.os.StrictMode;

import com.mincat.sample.utils.Constants;
import com.mincat.sample.utils.L;

import org.xutils.BuildConfig;
import org.xutils.x;


/**
 * @author Mings
 * @描述 对相关参数进行初始化
 */
public class MyApp extends Application {

    public static MyApp applicationUtils = new MyApp();

    // 此处flag设置为false 将屏蔽所有L类日志的打印
    public boolean flag = true;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationUtils = this;
        // 在此处对Xutils进行初始化！！！如果不进行初始化Xutils网络访问不可使用
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);
        init();
    }

    // 初始化
    @SuppressWarnings("unused")
    private void init() {
        L.isDebug = flag;

        if (Constants.Config.DEVELOPER_MODE
                && Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectAll().penaltyLog().penaltyDeath().penaltyDialog()
                    .build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectAll().penaltyLog().penaltyDeath()
                    .detectLeakedSqlLiteObjects().build());
        }
    }


    // MyApp
    public static MyApp getInstance() {
        return applicationUtils;
    }

}
