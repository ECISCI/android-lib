package com.mincat.test.testui.xutils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mincat.sample.manager.post.BaseXutilsPost;
import com.mincat.sample.utils.L;
import com.mincat.test.R;
import com.mincat.test.domain.User;
import com.mincat.test.testui.Constant;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Mings
 * @描述 XutilsPost Post网络访问请求测试
 */

public class XutilsPost extends BaseXutilsPost {

    @BindView(R.id.progress)
    TextView progress;
    private Button btn;
    private EditText et_show_text;

    /**
     * 参数名是由服务器来定制,所以此处直接对参数名进行初始化
     */
    private String[] paramName = new String[]{"username", "password"};
    private Object[] paramValue;

    private String[] headerKey;
    private String[] headerValue;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_test_xutils_post);
        ButterKnife.bind(this);
        initView();
    }


    @Override
    public void initView() {

        // 初始化导航栏,只需要一句话即可
        initToolBar(R.id.toolbar);

        btn = getId(R.id.btn_send);
        btn.setOnClickListener(this);

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

    @Override
    public void onNetRequest() {

        paramValue = new Object[]{"18500000000", "19999999"};

        headerKey = new String[]{"Content-Type"};
        headerValue = new String[]{"application/x-www-form-urlencoded"};
        // params 不能为空
//        executeXutilsPostRequest(this, params, "Login", false);

        // 需要添加请求头
        executeXutilsPostRequest(this, getParams(Constant.LOGIN, getJsonData(paramName, paramValue), headerKey, headerValue), "Login", false);

        // 不需要添加请求头
//        executeXutilsPostRequest(this,getParams(Constant.LOGIN, getJsonData(paramName, paramValue)),"Login",false);


    }

    @Override
    public void onSuccessListener(String result, boolean hasDialog, String sign) {

        progress.setText(R.string.request_success);

        if (hasDialog) {
            // 在此处做关闭进度条操作
        }

        if (sign.equals("Login")) {
            L.i(TAG, "请求成功并且拿到返回参数:" + result);

            et_show_text.setText("请求成功,返回参数请查看Log日志");

            /**
             * 此处已将返回参数解析到实体类中
             */
            User o = (User) parseResult(result, User.class);

            L.i(TAG, "封装好的实体类:" + o);
        }


    }

    @Override
    public void onErrorListener(Throwable arg0, boolean arg1, boolean hasDialog, String sign) {

        progress.setText(R.string.request_failed);
        et_show_text.setText("请求失败,错误信息请查看Log日志");
        L.i(TAG, "错误信息:" + arg0);

    }

    @Override
    public void onFinishedListener(boolean hasDialog, String sign) {

    }


}
