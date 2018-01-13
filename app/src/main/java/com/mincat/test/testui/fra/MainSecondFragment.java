package com.mincat.test.testui.fra;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.mincat.sample.chart.ColumnCharts;
import com.mincat.sample.chart.LineCharts;
import com.mincat.sample.chart.PieCharts;
import com.mincat.sample.manager.BaseFragment;
import com.mincat.test.R;
import com.mincat.test.testui.hellochart.HelloChartCircle;
import com.mincat.test.testui.hellochart.HelloChartColumn;
import com.mincat.test.testui.hellochart.HelloChartLine;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * @author Ming
 */
public class MainSecondFragment extends BaseFragment {
    View view;
    @BindView(R.id.line_chart)
    RelativeLayout lineChart;
    @BindView(R.id.column_chart)
    RelativeLayout columnChart;
    @BindView(R.id.circle_chart)
    RelativeLayout circleChart;
    Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fra_second, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.line_chart, R.id.column_chart, R.id.circle_chart})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.line_chart:
                intentUtils.openActivityFromRight(getActivity(), HelloChartLine.class);
                break;
            case R.id.column_chart:
                intentUtils.openActivityFromRight(getActivity(), HelloChartColumn.class);
                break;
            case R.id.circle_chart:
                intentUtils.openActivityFromRight(getActivity(), HelloChartCircle.class);
                break;
        }
    }
}