package com.mincat.test.testui.hellochart;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.mincat.sample.chart.ColumnCharts;
import com.mincat.sample.manager.base.AppCompat;
import com.mincat.sample.utils.T;
import com.mincat.test.R;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.listener.ColumnChartOnValueSelectListener;
import lecho.lib.hellocharts.model.SubcolumnValue;
import lecho.lib.hellocharts.view.ColumnChartView;

/**
 * @author Ming
 * @描述 柱状图
 */

public class HelloChartColumn extends AppCompat {

    List<Float> list;
    List<String> bottomExplain;
    ColumnChartView chartView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_test_hello_chart02);
        initView();


    }

    @Override
    public void initView() {
        initToolBar(R.id.toolbar);
        chartView = getId(R.id.chart);

        initData();


        ColumnCharts.showColumnCharts(this, chartView, list, bottomExplain, "消费", "星期显示", false);

        // 给Column条目添加点击事件
        chartView.setOnValueTouchListener(new ColumnChartOnValueSelectListener() {
            @Override
            public void onValueSelected(int columnIndex, int subcolumnIndex, SubcolumnValue value) {
                T.showShort(HelloChartColumn.this, list.get(columnIndex) + "");
            }

            @Override
            public void onValueDeselected() {

            }
        });
    }

    /**
     * 初始化一些假数据
     */
    private void initData() {
        list = new ArrayList<>();
        bottomExplain = new ArrayList<>();

        list.add(16.0f);
        list.add(26.0f);
        list.add(20.0f);
        list.add(19.0f);
        list.add(36.0f);
        list.add(46.0f);
        list.add(26.0f);


        bottomExplain.add("星期一");
        bottomExplain.add("星期二");
        bottomExplain.add("星期三");
        bottomExplain.add("星期四");
        bottomExplain.add("星期五");
        bottomExplain.add("星期六");
        bottomExplain.add("星期日");
    }


    @Override
    public void onNetRequest() {

    }

    @Override
    public void onClick(View view) {

    }


}
