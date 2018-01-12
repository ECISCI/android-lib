package com.mincat.sample.manager.inter;

import android.view.View;

/**
 * @author Mings
 * @描述 基础接口
 */

public interface InitUi extends View.OnClickListener {

    /**
     * 初始化参数
     */
    void initView();

    /**
     * 网络请求
     */
    void onNetRequest();

    /**
     * 点击事件
     *
     * @param view
     */
    @Override
    void onClick(View view);
}
