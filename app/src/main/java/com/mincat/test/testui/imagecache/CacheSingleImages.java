package com.mincat.test.testui.imagecache;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.mincat.sample.imagecache.single.CacheSingleImage;
import com.mincat.sample.imagecache.single.DisplaySingleImage;
import com.mincat.sample.imagecache.single.DeleteSingleImage;
import com.mincat.sample.manager.base.AppCompat;
import com.mincat.test.R;
import com.mincat.test.testui.Constant;

/**
 * @author Ming
 * @描述 缓存单张图片
 */

public class CacheSingleImages extends AppCompat {
    private com.mincat.sample.imagecache.single.CacheSingleImage cacheSingleImage = com.mincat.sample.imagecache.single.CacheSingleImage.getInstance();
    private String imageUrl = Constant.CACHE_IMAGE_URL;
    private ImageView image;
    private Button btn_image_cache, btn_display_image, btn_remove_image;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_imagecache_single);

        initView();
    }

    @Override
    public void initView() {
        initToolBar(R.id.toolbar);
        image = getId(R.id.image);
        btn_image_cache = getId(R.id.btn_image_cache);
        btn_display_image = getId(R.id.btn_display_image);
        btn_remove_image = getId(R.id.btn_remove_image);


        btn_image_cache.setOnClickListener(this);
        btn_display_image.setOnClickListener(this);
        btn_remove_image.setOnClickListener(this);


    }

    @Override
    public void onNetRequest() {

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btn_image_cache:
                cacheSingleImage.cache(this, imageUrl);
                break;
            case R.id.btn_display_image:
                DisplaySingleImage.display(this, imageUrl, image);
                break;
            case R.id.btn_remove_image:
                DeleteSingleImage.delete(this, imageUrl);
                break;
        }

    }
}
