package com.mincat.test.testui.imagecache;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mincat.sample.db.utils.XDbManager;
import com.mincat.sample.manager.base.AppCompat;
import com.mincat.sample.utils.L;
import com.mincat.test.R;
import com.mincat.test.adapter.imageCache.ImageAndDbLocalAdapter;
import com.mincat.test.domain.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ming
 * @描述 读取本地数据库及图片缓存加载列表
 */

public class DbAndImageCacheLocal extends AppCompat implements SwipeRefreshLayout.OnRefreshListener {

    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private List<Person> bean;
    private ImageAndDbLocalAdapter andDbAdapter;
    private List<Person> select_person;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_db_and_image_cache_local);

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
        bean = selectTablePerson();
        setAdapter();
    }

    private void setAdapter() {


        if (andDbAdapter == null) {
            andDbAdapter = new ImageAndDbLocalAdapter(DbAndImageCacheLocal.this, bean, recyclerView);

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

    // 查询Person表
    private List selectTablePerson() {

        select_person = new ArrayList<>();

        List<Person> person = (List<Person>) XDbManager.selectFromWhereTable(Person.class, select_person);

        L.i(TAG, "从Person表中查出的数据是:" + person);

        return person;

    }
}
