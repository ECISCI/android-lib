package com.mincat.test.testui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.mincat.sample.manager.base.AppCompat;
import com.mincat.test.R;
import com.mincat.test.testui.hellochart.HelloChartLine;
import com.mincat.test.testui.hellochart.HelloChartColumn;
import com.mincat.test.testui.hellochart.HelloChartCircle;

/**
 * @author Ming
 * @描述 chart图
 */
public class ChartsAct extends AppCompat {

    /**
     * @param line_chart 折线图
     * @param column_chart 柱状图
     * @param circle_chart 饼状图
     */
    private Button line_chart, column_chart, circle_chart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.charts);
        initView();
    }

    @Override
    public void initView() {
        initToolBar(R.id.toolbar);
        line_chart = getId(R.id.line_chart);
        line_chart.setOnClickListener(this);

        column_chart = getId(R.id.column_chart);
        column_chart.setOnClickListener(this);
        circle_chart = getId(R.id.circle_chart);
        circle_chart.setOnClickListener(this);
    }

    @Override
    public void onNetRequest() {

    }

    /**
     * 点击事件
     *
     * @param view
     */
    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.line_chart:
                intentUtils.openActivityFromRight(this, HelloChartLine.class);
                break;
            case R.id.column_chart:
                intentUtils.openActivityFromRight(this, HelloChartColumn.class);
                break;
            case R.id.circle_chart:
                intentUtils.openActivityFromRight(this, HelloChartCircle.class);
                break;

        }

    }
}
