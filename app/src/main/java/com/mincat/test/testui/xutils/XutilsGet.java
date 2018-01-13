package com.mincat.test.testui.xutils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mincat.sample.manager.get.BaseXutilsGet;
import com.mincat.sample.utils.L;
import com.mincat.test.R;
import com.mincat.test.testui.Constant;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Mings
 * @描述 Xutils Get网络访问测试
 */

public class XutilsGet extends BaseXutilsGet {
    @BindView(R.id.progress)
    TextView progress;
    private String urlEncode;
    private Button btn_send;
    private EditText et_show_text;
    private String url;
    private String cityName = "青岛";
    private String url_encode = "utf-8";
    private String requestSign = "Weather";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_test_xutils_get);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    public void initView() {

        // 初始化顶部导航栏,
        initToolBar(R.id.toolbar);

        btn_send = getId(R.id.btn_send);
        btn_send.setOnClickListener(this);

        et_show_text = getId(R.id.et_show_text);
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btn_send:

                progress.setText("请求中...请稍后");
                onNetRequest();
                break;
        }

    }

    /**
     * 网络访问中添加执行网络请求方法
     */
    @Override
    public void onNetRequest() {


        try {
            // 此处对字符串进行编码,此方式为聚合Api接口要求格式
            urlEncode = URLEncoder.encode(cityName, url_encode);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        /**
         * 测地址
         */
        url = Constant.getJuHeWeather(urlEncode);


        executeXutilsGetRequest(this, url, requestSign, false);

    }


    /**
     * 请求成功回调函数
     *
     * @param result
     */
    @Override
    public void onSuccessListener(String result, String sign) {

        progress.setText("请求成功");

        if (sign.equals(requestSign)) {

            L.i(TAG, "Xutils Get 请求成功返回结果:" + result);

            et_show_text.setText(R.string.request_success);
        }

    }

    /**
     * 请求失败回调函数
     *
     * @param ex
     * @param isOnCallback
     */

    @Override
    public void onErrorListener(Throwable ex, boolean isOnCallback) {
        progress.setText("请求失败");
        L.i(TAG, "Xutils Get 请求失败,错误信息:" + ex);

        et_show_text.setText(R.string.request_failed);

    }


}
