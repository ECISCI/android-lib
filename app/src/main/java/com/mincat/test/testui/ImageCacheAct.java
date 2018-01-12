package com.mincat.test.testui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.mincat.sample.manager.base.AppCompat;
import com.mincat.test.R;
import com.mincat.test.testui.imagecache.CacheMoreImage;
import com.mincat.test.testui.imagecache.CacheSingleImages;

/**
 * @author Ming
 * @描述 缓存图片
 */

public class ImageCacheAct extends AppCompat {
    private Button btn_cache_single_image,cache_more_image;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_imagecache);
        initView();

    }

    @Override
    public void initView() {
        initToolBar(R.id.toolbar);

        btn_cache_single_image = getId(R.id.cache_single_image);
        btn_cache_single_image.setOnClickListener(this);

        cache_more_image = getId(R.id.cache_more_image);
        cache_more_image.setOnClickListener(this);


    }

    @Override
    public void onNetRequest() {

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.cache_single_image:

                intentUtils.openActivityFromRight(this, CacheSingleImages.class);
                break;
            case R.id.cache_more_image:

                intentUtils.openActivityFromRight(this, CacheMoreImage.class);
                break;
        }

    }
}
