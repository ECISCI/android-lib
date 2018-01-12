package com.mincat.sample.manager.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextUtils;

import com.alibaba.fastjson.JSONObject;
import com.mincat.sample.manager.inter.InitUi;

import org.xutils.http.RequestParams;

/**
 * @author Mings
 * @描述 Xutils 网络请求监听基类
 */

public abstract class BaseXutilsRequest extends AppCompat implements InitUi {

    public static int DEFAULT_CACHE_EXPIRY_TIME = 3000;
    public static int CACHE_TIME = 1000 * 0;
    protected RequestParams params;
    protected JSONObject jsonObject;
    protected int flag = 0;


    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    /**
     * @param url      请求的url地址
     * @param jsonData 请求的json串
     * @return RequestParams
     * @描述 获取请求参数 不需要添加请求头
     */
    protected RequestParams getParams(String url, String jsonData) {

        if (TextUtils.isEmpty(url))

            throw new IllegalArgumentException("url can not be null");

        else if (TextUtils.isEmpty(jsonData))

            throw new IllegalArgumentException("jsonData  can not be null");

        else
            params = new RequestParams(url);
        params.setAsJsonContent(true);
        params.setBodyContent(jsonData);
        // 为请求添加缓存时间
        params.setCacheMaxAge(CACHE_TIME);
        // 为请求添加超时时间
        params.setConnectTimeout(DEFAULT_CACHE_EXPIRY_TIME);
        return params;

    }

    /**
     * @param url         请求url地址
     * @param jsonData    请求的json串
     * @param headerKey   请求头Key
     * @param headerValue 请求头value
     * @return
     * @描述 需要添加请求头
     */
    protected RequestParams getParams(String url, String jsonData, String[] headerKey, String[] headerValue) {

        if (TextUtils.isEmpty(url))

            throw new IllegalArgumentException("url can not be null");

        else if (TextUtils.isEmpty(jsonData))

            throw new IllegalArgumentException("jsonData  can not be null");

        else
            params = new RequestParams(url);
        params.setAsJsonContent(true);
        params.setBodyContent(jsonData);
        // 为请求添加缓存时间
        params.setCacheMaxAge(CACHE_TIME);
        // 为请求添加超时时间
        params.setConnectTimeout(DEFAULT_CACHE_EXPIRY_TIME);

        if (headerKey.length == 0)
            throw new IllegalArgumentException("request header key can not be null");

        if (headerValue.length == 0)
            throw new IllegalArgumentException("request header value can not be null");

        if (headerKey.length != headerValue.length)
            throw new IllegalArgumentException("request header value  value must correspond");

        // 设置请求头
        for (int i = 0; i < headerKey.length; i++) {
            params.addHeader(headerKey[i], headerValue[i]);
        }


        return params;

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
