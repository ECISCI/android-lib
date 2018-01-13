package com.mincat.test.testui.volley;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.mincat.sample.manager.get.BaseVolleyGet;
import com.mincat.test.R;
import com.mincat.test.testui.Constant;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Mings
 * @描述 测试Volley Get请求
 */

public class VolleyGet extends BaseVolleyGet {

    @BindView(R.id.progress)
    TextView progress;
    private Button btn_send;
    private EditText et_show_text;
    private String urlEncode;
    private String url;
    private String cityName = "青岛";
    private String url_encode = "utf-8";
    private String requestSign = "Weather";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_test_volley_get);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    public void initView() {

        initToolBar(R.id.toolbar);
        btn_send = getId(R.id.btn_send);
        btn_send.setOnClickListener(this);

        et_show_text = getId(R.id.et_show_text);

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_send:

                progress.setText(R.string.in_requst);
                onNetRequest();

                break;
        }

    }

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


        /**
         * 测地址
         */

        executeVolleyGetRequest(this, url, requestSign, false);

    }


    /**
     * 请求成功回调函数
     *
     * @param response 返回结果（一般为Json串）
     * @param sign     请求标记
     */
    @Override
    public void onHandleResponsePost(String response, String sign) {
        progress.setText(R.string.request_success);
        if (sign.equals(requestSign)) {

            et_show_text.setText("请求成功,具体返回结果集请查看Log日志");
        }


    }

    /**
     * 请求失败回调函数
     *
     * @param error 错误信息,（错误信息已在父类中进行打印,此处不许打印操作）
     * @param sign  请求标记
     */
    @Override
    public void errorListener(VolleyError error, String sign) {
        progress.setText(R.string.request_failed);
        if (sign.equals(requestSign)) {
            et_show_text.setText("Xutils Get 请求失败,具体错误信息请查看Log日志");
        }
    }


}
