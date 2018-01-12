package com.mincat.test.testui.imagecache;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mincat.sample.manager.base.AppCompat;
import com.mincat.test.R;
import com.mincat.test.adapter.ImageAdapter;
import com.mincat.test.testui.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ming
 * @描述 缓存列表图片
 */

public class CacheMoreImage extends AppCompat implements SwipeRefreshLayout.OnRefreshListener {

    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ImageAdapter adapter;
    private com.mincat.sample.imagecache.more.CacheMoreImage cacheMoreImage = com.mincat.sample.imagecache.more.CacheMoreImage.getInstance();
    private List<String> imageUrls;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_imagecache_more);
        initView();
    }

    @Override
    public void initView() {
        initToolBar(R.id.toolbar);
        recyclerView = getId(R.id.recyclerView);
        swipeRefreshLayout = getId(R.id.swipeRefreshLayout);

        initData();


    }

    /**
     * 初始化一组图片参数
     */
    private void initData() {

        imageUrls = new ArrayList<>();
        imageUrls.add(Constant.CACHE_IMAGE_URL_01);
        imageUrls.add(Constant.CACHE_IMAGE_URL_02);
        imageUrls.add(Constant.CACHE_IMAGE_URL_03);
        imageUrls.add(Constant.CACHE_IMAGE_URL_04);
        imageUrls.add(Constant.CACHE_IMAGE_URL_05);
        imageUrls.add(Constant.CACHE_IMAGE_URL_06);
        imageUrls.add(Constant.CACHE_IMAGE_URL_07);
        imageUrls.add(Constant.CACHE_IMAGE_URL_08);
        imageUrls.add(Constant.CACHE_IMAGE_URL_09);
        imageUrls.add(Constant.CACHE_IMAGE_URL_10);

        setAdapter();
    }

    private void setAdapter() {
        if (adapter == null) {
            adapter = new ImageAdapter(CacheMoreImage.this, imageUrls, recyclerView);

            //1. 设置刷新监听
            swipeRefreshLayout.setOnRefreshListener(this);
            //2. 进度动画颜色
            swipeRefreshLayout.setColorSchemeResources(
                    R.color.md_red_500,
                    R.color.md_green_500,
                    R.color.md_deep_purple_500,
                    R.color.md_deep_orange_500);

            //3. 进度背景颜色
            swipeRefreshLayout.setProgressBackgroundColorSchemeResource(R.color.white);
            //4. 设置布局方式，单列显示，所以 后面设置为1
            GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
            layoutManager.setOrientation(RecyclerView.VERTICAL);

            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
        } else {

            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onNetRequest() {

    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onRefresh() {
        // 发送延迟消息到消息队列
        swipeRefreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {

                // 在这里做网络访问

                // 隐藏进度条
                swipeRefreshLayout.setRefreshing(false);
            }
        }, 5000);

    }

    @Override
    protected void onPause() {
        super.onPause();
        cacheMoreImage.flushCache();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 退出程序时结束所有的下载任务
        cacheMoreImage.cancelAllTasks();
    }

}
