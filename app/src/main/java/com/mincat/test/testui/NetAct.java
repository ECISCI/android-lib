package com.mincat.test.testui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.mincat.sample.manager.base.AppCompat;
import com.mincat.test.R;
import com.mincat.test.testui.volley.VolleyGet;
import com.mincat.test.testui.volley.VolleyPost;
import com.mincat.test.testui.xutils.XutilsGet;
import com.mincat.test.testui.xutils.XutilsPost;

public class NetAct extends AppCompat {

    private Button btn_send_xutils_post, btn_send_xutils_get, btn_send_volley_get, hello_chart, play_video, btn_send_volley_post, hello_chart_pie;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.net);
        initView();
    }

    @Override
    public void initView() {
        initToolBar(R.id.toolbar);
        btn_send_xutils_post = getId(R.id.btn_send_xutils_post);
        btn_send_xutils_post.setOnClickListener(this);

        btn_send_xutils_get = getId(R.id.btn_send_xutils_get);
        btn_send_xutils_get.setOnClickListener(this);

        btn_send_volley_get = getId(R.id.btn_send_volley_get);
        btn_send_volley_get.setOnClickListener(this);


        btn_send_volley_post = getId(R.id.btn_send_volley_post);
        btn_send_volley_post.setOnClickListener(this);

    }

    @Override
    public void onNetRequest() {

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btn_send_xutils_post:

                intentUtils.openActivityFromRight(this, XutilsPost.class);
                break;
            case R.id.btn_send_xutils_get:

                intentUtils.openActivityFromRight(this, XutilsGet.class);
                break;
            case R.id.btn_send_volley_get:

                intentUtils.openActivityFromRight(this, VolleyGet.class);
                break;
            case R.id.btn_send_volley_post:

                intentUtils.openActivityFromRight(this, VolleyPost.class);
                break;
        }

    }
}
