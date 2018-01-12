package com.mincat.test.testui.imagecache;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mincat.sample.db.utils.XDbManager;
import com.mincat.sample.manager.base.AppCompat;
import com.mincat.test.R;
import com.mincat.test.adapter.ImageAndDbLoadAdapter;
import com.mincat.test.domain.Person;
import com.mincat.test.testui.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ming
 * @描述 将网络获取的图片及字符串分别用图片缓存和数据缓存缓存到本地
 * @说明 此处数据都是自己创建的
 */

public class DbAndImageCacheLoad extends AppCompat implements SwipeRefreshLayout.OnRefreshListener {

    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private List<Person> bean;
    private Person person1, person2, person3, person4, person5;
    private ImageAndDbLoadAdapter andDbAdapter;
    private List<Person> select_person;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_db_and_image_cache_load);

        initView();
    }

    @Override
    public void initView() {
        initToolBar(R.id.toolbar);
        recyclerView = getId(R.id.recyclerView);
        swipeRefreshLayout = getId(R.id.swipeRefreshLayout);
        initDataMy();

    }

    private void initDataMy() {

        bean = new ArrayList<>();

        person1 = new Person("小明", 11, "男", Constant.CACHE_IMAGE_URL_01);
        person2 = new Person("小红", 12, "女", Constant.CACHE_IMAGE_URL_02);
        person3 = new Person("小刚", 13, "男", Constant.CACHE_IMAGE_URL_03);
        person4 = new Person("小李", 14, "女", Constant.CACHE_IMAGE_URL_04);
        person5 = new Person("小蓝", 15, "男", Constant.CACHE_IMAGE_URL_05);

        bean.add(person1);
        bean.add(person2);
        bean.add(person3);
        bean.add(person4);
        bean.add(person5);

        XDbManager.insertDb(bean);

        setAdapter();
    }
    private void setAdapter() {


        if (andDbAdapter == null) {
            andDbAdapter = new ImageAndDbLoadAdapter(DbAndImageCacheLoad.this, bean, recyclerView);

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
            recyclerView.setAdapter(andDbAdapter);
        } else {

            andDbAdapter.notifyDataSetChanged();
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

}

