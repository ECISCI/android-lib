package com.mincat.test.testui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.mincat.sample.db.utils.XDbManager;
import com.mincat.sample.imagecache.utils.DeleteAllImageCache;
import com.mincat.sample.imagecache.more.CacheMoreImage;
import com.mincat.sample.manager.base.AppCompat;
import com.mincat.sample.utils.L;
import com.mincat.test.R;
import com.mincat.test.domain.Person;
import com.mincat.test.testui.imagecache.DbAndImageCacheLoad;
import com.mincat.test.testui.imagecache.DbAndImageCacheLocal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ming
 * @描述 数据库缓存+图片缓存
 */

public class DbAndImageCache extends AppCompat {

    private Button read_net, read_local, remove_all_cache;
    private List<Person> select_person;

    CacheMoreImage cache = CacheMoreImage.getInstance();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_db_and_image_cache);

        initView();
    }

    @Override
    public void initView() {
        initToolBar(R.id.toolbar);

        read_net = getId(R.id.read_net);
        read_net.setOnClickListener(this);
        read_local = getId(R.id.read_local);
        read_local.setOnClickListener(this);
        remove_all_cache = getId(R.id.remove_all_cache);
        remove_all_cache.setOnClickListener(this);


    }

    @Override
    public void onNetRequest() {

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.read_net:
                intentUtils.openActivityNormal(this, DbAndImageCacheLoad.class);

                break;

            case R.id.read_local:
                intentUtils.openActivityNormal(this, DbAndImageCacheLocal.class);

                break;
            case R.id.remove_all_cache:


                DeleteAllImageCache.delete(this);
                XDbManager.deleteWhereTable(Person.class);


                L.i(TAG, "删除所有数据后:" + selectTablePerson());

                break;
        }

    }

    private void removeAll() {



        XDbManager.deleteWhereTable(Person.class);


        L.i(TAG, "删除所有数据后:" + selectTablePerson());


    }


    private List selectTablePerson() {

        select_person = new ArrayList<>();

        List<Person> person = (List<Person>) XDbManager.selectFromWhereTable(Person.class, select_person);

        L.i(TAG, "从Person表中查出的数据是:" + person);

        return person;

    }

}
