package com.mincat.test.testui.hellochart;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.mincat.sample.chart.PieCharts;
import com.mincat.sample.manager.base.AppCompat;
import com.mincat.test.R;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.listener.PieChartOnValueSelectListener;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

/**
 * @author Ming
 * @描述 饼状图
 */

public class HelloChartCircle extends AppCompat {
    private PieChartView pie_chart;
    private List<String> leaf_data;
    private List<Integer> leaf_color;
    private List<String> leaf_desc;
    private List<SliceValue> values;
    private TextView tv_desc;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_test_hello_chart03);
        initView();
    }

    @Override
    public void initView() {
        initToolBar(R.id.toolbar);
        pie_chart = getId(R.id.chart);
        tv_desc = getId(R.id.tv_desc);

        if (leaf_data != null && leaf_data.size() > 0) {
            leaf_data.clear();
        }
        if (leaf_color != null && leaf_color.size() > 0) {
            leaf_color.clear();
        }
        if (leaf_desc != null && leaf_desc.size() > 0) {
            leaf_desc.clear();
        }
        values = new ArrayList<>();

        // 初始化一些假数据
        initData();


        PieCharts.showPieCharts(pie_chart, values, leaf_data, leaf_color, false);

        // 为饼图添加点击事件
        pieAddClickListener();


    }

    /**
     * 为饼图添加点击事件
     */
    private void pieAddClickListener() {
        // 为饼状图添加点击事件
        pie_chart.setOnValueTouchListener(new PieChartOnValueSelectListener() {
            @Override
            public void onValueSelected(int position, SliceValue value) {
                tv_desc.setText(leaf_desc.get(position) + "   " + percent(position, leaf_data));
            }

            @Override
            public void onValueDeselected() {

            }
        });
    }

    private void initData() {
        leaf_data = new ArrayList<>();
        leaf_data.add("21");
        leaf_data.add("20");
        leaf_data.add("9");
        leaf_data.add("2");
        leaf_data.add("8");

        leaf_color = new ArrayList<>();
        leaf_color.add(Color.parseColor("#ec063d"));
        leaf_color.add(Color.parseColor("#f1c704"));
        leaf_color.add(Color.parseColor("#c9c9c9"));
        leaf_color.add(Color.parseColor("#ec063d"));
        leaf_color.add(Color.parseColor("#2bc208"));

        leaf_desc = new ArrayList<>();
        leaf_desc.add("iphone6");
        leaf_desc.add("iphone6plus");
        leaf_desc.add("iphone7");
        leaf_desc.add("iphone7plus");
        leaf_desc.add("iphone x");
    }

    /**
     * 做百分比操作
     *
     * @param i
     * @param data
     * @return
     */
    private String percent(int i, List<String> data) {
        String result = "";
        int sum = 0;
        for (int x = 0; x < data.size(); x++) {
            sum += Integer.valueOf(data.get(x));
        }
        result = String.format("%.2f", (float) Integer.valueOf(data.get(i)) * 100 / sum) + "%";
        return result;
    }


    @Override
    public void onNetRequest() {

    }

    @Override
    public void onClick(View view) {

    }

    @Override
    protected void onPause() {
        super.onPause();
        leaf_desc.clear();
        leaf_data.clear();
        leaf_color.clear();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        leaf_desc.clear();
        leaf_data.clear();
        leaf_color.clear();
    }
}
