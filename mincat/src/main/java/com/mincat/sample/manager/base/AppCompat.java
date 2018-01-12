package com.mincat.sample.manager.base;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.text.style.ClickableSpan;
import android.view.MenuItem;

import com.alibaba.fastjson.JSONObject;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.iconics.IconicsDrawable;
import com.mincat.sample.R;
import com.mincat.sample.custom.CustomProgressDialog;
import com.mincat.sample.utils.T;


/**
 * @author Mings
 */

public abstract class AppCompat extends AppCompatUnifiedManager {
    public static final String TAG = AppCompat.class.getName();

    protected CustomProgressDialog customProgressDialog = CustomProgressDialog.getInstance();
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {


        super.onCreate(savedInstanceState, persistentState);
    }


    //封装 toolbar 到基类中
    protected void initToolBar(int id) {
        toolbar = (Toolbar) findViewById(id);
        //toolbar.setClickable(false);
        toolbar.setTitle("");
        toolbar.setSubtitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    //toolbar返回键按钮
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            activitySlideRight();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //初始化3D效果按钮
    protected void initFabButton(int id) {
        mFabButton = (FloatingActionButton) findViewById(id);
        mFabButton.setImageDrawable(new IconicsDrawable(this, GoogleMaterial.Icon.gmd_file_upload).color(Color.WHITE).actionBar());
        mFabButton.setOnClickListener(this);
    }


    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.base_slide_right_in, R.anim.base_slide_remain);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, R.anim.base_slide_right_out);
    }


    protected Object parseResult(String result, Class<?> cls) {

        return JSONObject.parseObject(result, cls);


    }

    protected void showNetConnectionErrorToast(Context context) {
        T.showLong(context, getString(R.string.http_is_null));
    }

}
