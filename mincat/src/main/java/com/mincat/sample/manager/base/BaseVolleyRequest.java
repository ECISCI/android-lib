package com.mincat.sample.manager.base;

import android.os.Bundle;
import android.os.PersistableBundle;

import com.alibaba.fastjson.JSONObject;
import com.android.volley.RequestQueue;

/**
 * @author Mings
 * @描述 Volley网络请求监听基类
 */

public abstract class BaseVolleyRequest extends AppCompat {

    protected JSONObject jsonObject;
    protected int flag = 0;
    // 请求超时时间
    protected static final int REQUEST_TIMEOUT = 15000;

    // Volley请求队列
    protected RequestQueue mQueue;


    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        initView();
    }

    /**
     * @param jsonKey   键 数组
     * @param jsonValue 值 数组
     * @return json
     * @描述 将两个数组转化成所需的Json串
     */
    protected String getJsonData(String[] jsonKey, Object[] jsonValue) {

        if (jsonKey.length == 0)

            throw new IllegalArgumentException("jsonKey can not be null");

        else if (jsonValue.length == 0)

            throw new IllegalArgumentException("jsonValue can not be null");

        else if (jsonKey.length != jsonValue.length)

            throw new IllegalArgumentException("jsonKey and jsonValue do not match");


        jsonObject = new JSONObject();

        flag = jsonKey.length;

        for (int i = 0; i < flag; i++) {

            jsonObject.put(jsonKey[i], jsonValue[i]);

        }
        return jsonObject.toJSONString();
    }


}
