package com.mincat.test.testui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RelativeLayout;

import com.mincat.sample.db.utils.XDbManager;
import com.mincat.sample.imagecache.more.CacheMoreImage;
import com.mincat.sample.imagecache.utils.DeleteAllImageCache;
import com.mincat.sample.manager.base.AppCompat;
import com.mincat.sample.utils.L;
import com.mincat.test.R;
import com.mincat.test.domain.Person;
import com.mincat.test.testui.imagecache.DbAndImageCacheLoad;
import com.mincat.test.testui.imagecache.DbAndImageCacheLocal;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Ming
 * @描述 数据库缓存+图片缓存
 */

public class DbAndImageCache extends AppCompat {

    @BindView(R.id.write_cache)
    RelativeLayout writeCache;
    @BindView(R.id.read_cache)
    RelativeLayout readCache;
    @BindView(R.id.delete_all)
    RelativeLayout deleteAll;
    private List<Person> select_person;
    CacheMoreImage cache = CacheMoreImage.getInstance();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_db_and_image_cache);
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


    private List selectTablePerson() {

        select_person = new ArrayList<>();

        List<Person> person = (List<Person>) XDbManager.selectFromWhereTable(Person.class, select_person);

        L.i(TAG, "从Person表中查出的数据是:" + person);

        return person;

    }

    @OnClick({R.id.write_cache, R.id.read_cache, R.id.delete_all})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            // 加载网络数据 并缓存到本地,此页面打开一次向数据库中添加一次
            case R.id.write_cache:
                intentUtils.openActivityNormal(this, DbAndImageCacheLoad.class);
                break;
            // 读取本地缓存
            case R.id.read_cache:
                intentUtils.openActivityNormal(this, DbAndImageCacheLocal.class);
                break;
            // 删除全部缓存
            case R.id.delete_all:
                DeleteAllImageCache.delete(this);
                XDbManager.deleteWhereTable(Person.class);
                L.i(TAG, "删除所有数据后:" + selectTablePerson());
                break;
        }
    }
}
