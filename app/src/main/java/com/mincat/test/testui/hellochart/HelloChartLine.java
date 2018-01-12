package com.mincat.test.testui.hellochart;

import android.os.Bundle;
import android.view.View;

import com.mincat.sample.chart.LineCharts;
import com.mincat.sample.manager.base.AppCompat;
import com.mincat.test.R;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.view.LineChartView;

/**
 * @author Mings
 * @描述 线图
 */

public class HelloChartLine extends AppCompat {

    private LineChartView lineChart;

    private List<String> listX;

    List<Integer> listPoint;
    private List<PointValue> mPointValues;
    private List<AxisValue> mAxisValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_test_hello_chart);

        initView();

    }


    /**
     * 初始化参数
     */
    @Override
    public void initView() {
        initToolBar(R.id.toolbar);
        lineChart = getId(R.id.chart);

        initData();


        mPointValues = new ArrayList<PointValue>();
        mAxisValues = new ArrayList<AxisValue>();

        /**
         * 你猜这是什么方法
         */
        LineCharts.showLineCharts(lineChart, mPointValues, listPoint, mAxisValues, listX, "未来几天气温", "温度");


    }

    /**
     * 制造一些假数据
     */
    private void initData() {
        listX = new ArrayList<>();
        listX.add("周一");
        listX.add("周二");
        listX.add("周三");
        listX.add("周四");
        listX.add("周五");
        listX.add("周六");
        listX.add("周日");

        listPoint = new ArrayList<>();
        listPoint.add(9);
        listPoint.add(2);
        listPoint.add(4);
        listPoint.add(5);
        listPoint.add(8);
        listPoint.add(6);
        listPoint.add(1);

    }

    @Override
    public void onNetRequest() {

    }

    /**
     * 点击事件
     * @param view
     */
    @Override
    public void onClick(View view) {

        switch (view.getId()){



        }

    }
}
