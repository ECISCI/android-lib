package com.mincat.test.testui.xutils;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import com.mincat.sample.manager.base.AppCompat;
import com.mincat.sample.manager.inter.XutilsDownLoadListener;
import com.mincat.sample.manager.xutils.XutilsDownloadFile;

import java.io.File;

/**
 * @author Mings
 * @描述 测试Xutils下载文件
 */

public class DownloadFile extends AppCompat {
    private String requestUrl = "";
    private String filePath = "";

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        initView();
    }

    @Override
    public void initView() {

        downLoad();

    }

    @Override
    public void onNetRequest() {

    }

    @Override
    public void onClick(View view) {

    }


    // 下载文件
    private void downLoad() {


        /**
         * @param url      请求下载的url地址
         * @param context  上下文对象
         * @param filePath 文件下载位置
         * @param listener 下载回调监听
         */
        XutilsDownloadFile.downloadFile(this, requestUrl, filePath, true, new XutilsDownLoadListener() {

            @Override
            public void onSuccessListener(File result) {
                // 下载成功回调此方法

            }

            @Override
            public void onErrorListener(Throwable ex, boolean isOnCallback) {
                // 下载失败回调此方法

            }

            @Override
            public void onLoadingListener(long total, long current, boolean isDownloading) {
                // 正在下载回调此方法
                // @注意: 在此处进行下载进度条操作

            }
        });

    }
}
