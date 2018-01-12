package com.mincat.test.testui.xutils;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import com.mincat.sample.manager.base.AppCompat;
import com.mincat.sample.manager.inter.XutilsUpLoadFileListener;
import com.mincat.sample.manager.xutils.XutilsUploadFile;

/**
 * @author Mings
 * @描述,测试 测试Xutils上传文件
 */

public class UploadFile extends AppCompat {

    private String filePath;

    private String fileParamName;


    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        initView();
    }


    @Override
    public void initView() {
        uploadFile();
    }

    @Override
    public void onNetRequest() {

    }

    @Override
    public void onClick(View view) {

    }

    private void uploadFile() {

        /**
         * @param filePath      文件路径
         * @param fileParamName 服务器给的文件参数名
         * @param listener      上传回调监听
         * @描述 Xutils上传文件
         */
        XutilsUploadFile.upLoadFile(this, filePath, fileParamName, new XutilsUpLoadFileListener() {
            @Override
            public void onSuccessListener(String result) {

                // 上传成功回调此方法

            }

            @Override
            public void onErrorListener(Throwable ex, boolean isOnCallback) {

                // 上传失败回调此方法

            }
        });


    }
}
