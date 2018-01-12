package com.mincat.test.testui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.mincat.sample.manager.base.AppCompat;
import com.mincat.sample.utils.T;
import com.mincat.test.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Ming
 */

public class TestAnnotation extends AppCompat {


    @BindView(R.id.click_01)
    Button click01;
    @BindView(R.id.click_02)
    Button click02;
    @BindView(R.id.click_03)
    Button click03;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.act_annotation);
        ButterKnife.bind(this);
        initView();


    }

    @Override
    public void initView() {
        initToolBar(R.id.toolbar);

    }

    @Override
    public void onNetRequest() {

    }

    @Override
    public void onClick(View view) {

    }

    @OnClick({R.id.click_01, R.id.click_02, R.id.click_03})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.click_01:
                T.showShort(getApplicationContext(),"1");
                break;
            case R.id.click_02:
                T.showShort(getApplicationContext(),"2");
                break;
            case R.id.click_03:
                T.showShort(getApplicationContext(),"3");
                break;
        }
    }
}
