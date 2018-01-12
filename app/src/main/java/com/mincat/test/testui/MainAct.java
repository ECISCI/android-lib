package com.mincat.test.testui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.mincat.sample.manager.base.AppCompat;
import com.mincat.test.R;
import com.mincat.test.testui.db.Database;

/**
 * @author Ming
 * @描述 主页面
 */
public class MainAct extends AppCompat {

    private Button net, charts, video, db, image_cache,db_image_cache,test_annotation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initView();
    }

    @Override
    public void initView() {

        net = getId(R.id.net);
        net.setOnClickListener(this);

        video = getId(R.id.video);
        video.setOnClickListener(this);


        charts = getId(R.id.charts);
        charts.setOnClickListener(this);

        db = getId(R.id.db);
        db.setOnClickListener(this);

        image_cache = getId(R.id.image_cache);
        image_cache.setOnClickListener(this);

        db_image_cache = getId(R.id.db_image_cache);
        db_image_cache.setOnClickListener(this);

        test_annotation = getId(R.id.test_annotation);
        test_annotation.setOnClickListener(this);

    }

    @Override
    public void onNetRequest() {

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.net:

                intentUtils.openActivityFromRight(this, NetAct.class);
                break;
            case R.id.video:

                intentUtils.openActivityFromRight(this, VideoAct.class);
                break;
            case R.id.charts:

                intentUtils.openActivityFromRight(this, ChartsAct.class);
                break;
            case R.id.db:

                intentUtils.openActivityFromRight(this, Database.class);
                break;
            case R.id.image_cache:

                intentUtils.openActivityFromRight(this, ImageCacheAct.class);
                break;
            case R.id.db_image_cache:

                intentUtils.openActivityFromRight(this, DbAndImageCache.class);
                break;
            case R.id.test_annotation:

                intentUtils.openActivityFromRight(this, TestAnnotation.class);
                break;
        }

    }
}
