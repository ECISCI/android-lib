package com.mincat.test.testui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.mincat.sample.manager.base.AppCompat;
import com.mincat.sample.operationadapter.OperationAdapterDialog;
import com.mincat.sample.utils.T;
import com.mincat.test.R;
import com.mincat.test.adapter.operation.TestOperationAdapter;
import com.mincat.test.domain.OperationAdapterBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Ming
 * @描述 操作adapter
 */

public class TestOperationAdapterAct extends AppCompat implements SwipeRefreshLayout.OnRefreshListener {


    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.refresh)
    Button refresh;

    private OperationAdapterDialog operationAdapterDialog = OperationAdapterDialog.getInstance();

    private TestOperationAdapter adapter;

    private List<OperationAdapterBean> lists;

    private OperationAdapterBean bean1, bean2, bean3, bean4, bean5;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_operation_adapter);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    public void initView() {
        initToolBar(R.id.toolbar);

        lists = new ArrayList<>();

        bean1 = new OperationAdapterBean("世界那么大我想去看看");
        bean2 = new OperationAdapterBean("世界不止眼前的苟且,还有诗和远方");
        bean3 = new OperationAdapterBean("怀揣一颗红心,需做两手准备");
        bean4 = new OperationAdapterBean("胡司令！看在党国的份上,快拉兄弟一把");
        bean5 = new OperationAdapterBean("沧海桑田方显英雄本色！");

        lists.add(bean1);
        lists.add(bean2);
        lists.add(bean3);
        lists.add(bean4);
        lists.add(bean5);

        initAdapterData();

    }

    @Override
    public void onNetRequest() {

    }

    @Override
    public void onClick(View view) {

    }

    private void initAdapterData() {
        if (adapter == null) {
            adapter = new TestOperationAdapter(this, lists);

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

    /**
     * 点击事件
     */
    @OnClick(R.id.refresh)
    public void onViewClicked() {

        if (lists.size() == 0) {

            T.showShort(getApplicationContext(), "没有要清空的数据");
        } else {
            operationAdapterDialog.removeAllItemInAdapter(lists, adapter);
        }
    }
}
