package com.mincat.test.testui.imagecache;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.mincat.sample.imagecache.single.CacheSingleImage;
import com.mincat.sample.imagecache.single.DeleteSingleImage;
import com.mincat.sample.imagecache.single.DisplaySingleImage;
import com.mincat.sample.manager.base.AppCompat;
import com.mincat.test.R;
import com.mincat.test.testui.Constant;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Ming
 * @描述 缓存单张图片
 */

public class CacheSingleImages extends AppCompat {
    @BindView(R.id.cache_single_image)
    RelativeLayout cacheSingleImage;
    @BindView(R.id.display_local_image)
    RelativeLayout displayLocalImage;
    @BindView(R.id.delete_cache)
    RelativeLayout deleteCache;
    private CacheSingleImage cache = CacheSingleImage.getInstance();
    private String imageUrl = Constant.CACHE_IMAGE_URL;
    private ImageView image;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_imagecache_single);
        ButterKnife.bind(this);

        initView();
    }

    @Override
    public void initView() {
        initToolBar(R.id.toolbar);
        image = getId(R.id.image);


    }

    @Override
    public void onNetRequest() {

    }

    @Override
    public void onClick(View view) {


    }

    @OnClick({R.id.cache_single_image, R.id.display_local_image, R.id.delete_cache})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.cache_single_image:
                cache.cache(this, imageUrl);
                break;
            case R.id.display_local_image:
                DisplaySingleImage.display(this, imageUrl, image);
                break;
            case R.id.delete_cache:
                DeleteSingleImage.delete(this, imageUrl);
                break;
        }
    }

}
