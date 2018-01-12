package com.mincat.test.testui.volley;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.VolleyError;
import com.mincat.sample.manager.post.BaseVolleyPost;
import com.mincat.test.R;
import com.mincat.test.testui.Constant;

/**
 * @author Mings
 * @描述 测试Volley Get请求
 */

public class VolleyPost extends BaseVolleyPost {

    private Button btn_send;
    private String[] paramName = new String[]{"username", "password"};
    private Object[] paramValue;
    private EditText et_show_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_test_volley_post);
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
    public void onNetRequest() {
        paramValue = new Object[]{"18500818045", "198962"};
        executeVolleyPostRequest(this, Constant.LOGIN, getJsonData(paramName, paramValue), "Login", false);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btn_send:
                onNetRequest();
                break;
        }

    }

    @Override
    public void onHandleResponsePost(String response, String sign) {

        if (sign.equals("Login")) {

            et_show_text.setText("Volley post请求成功,返回信息请查看日志");
        }

    }

    @Override
    public void errorListener(VolleyError error, String sign) {

        if (sign.equals("Login")) {

            et_show_text.setText("Volley post请求失败,错误信息请查看日志");
        }

    }
}
