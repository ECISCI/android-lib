package com.mincat.test.testui;

import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.mincat.sample.manager.CustomTableHost;
import com.mincat.sample.manager.base.AppCompatUnifiedManager;
import com.mincat.sample.utils.AppManager;
import com.mincat.sample.utils.Constants;
import com.mincat.sample.utils.T;
import com.mincat.test.R;
import com.mincat.test.testui.fra.MainSecondFragment;
import com.mincat.test.testui.fra.MainHomeFragment;
import com.mincat.test.testui.fra.MainSettingFragment;

import java.lang.ref.WeakReference;


/**
 * @author Ming
 */
public class MainHomeAct extends AppCompatUnifiedManager {

    public static final String TAG = MainHomeAct.class.getName();

    private long exitTimeMillis = System.currentTimeMillis();

    public static final int MSG_CODE_LOOP_NEW_DISTRI_BUTION = 1;

    private Class fragmentArray[] = {MainHomeFragment.class, MainSecondFragment.class,
            MainSettingFragment.class};

    // 定义数组来存放Tab选项卡的文字
    private String mTextViewArray[] = {Constants.TAB_NAME_01, Constants.TAB_NAME_02, Constants.TAB_NAME_03};

    // 定义数组来存放按钮图片
    private int mImageViewArray[] = {R.drawable.table_home_selector, R.drawable.table_found_selector, R.drawable.table_setting_selector};

    private CustomTableHost mTabHost;

    @SuppressWarnings("unused")
    private MainHandler handler;

    // 获取 TabHost
    public CustomTableHost getTabHost() {
        return mTabHost;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Looper.myLooper() != null) {
            handler = new MainHandler(this);
        }
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        initView();
        getTablStyle();
    }

    // 初始化参数为FragmentTable赋值
    public void initView() {

        mTabHost = (CustomTableHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        mTabHost.getTabWidget().setDividerDrawable(android.R.color.white);

        for (int i = 0; i < fragmentArray.length; i++) {
            mTabHost.addTab(mTabHost.newTabSpec(mTextViewArray[i]).setIndicator(getTabItemView(i)), fragmentArray[i], null);
        }
    }


    // 给Tab按钮设置图标和文字
    private View getTabItemView(int index) {
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.main_tab_items, null);
        TextView textView = (TextView) view.findViewById(R.id.tv_tab_items);
        Drawable drawable = getResources().getDrawable(mImageViewArray[index]);
        int tabwidget_height = getResources().getDimensionPixelSize(
                R.dimen.margin_twenty);
        drawable.setBounds(0, 0, tabwidget_height, tabwidget_height);// 45
        textView.setCompoundDrawables(null, drawable, null, null);
        textView.setText(mTextViewArray[index]);
        return view;
    }

    // 点击事件处理
    public void onClick(View v) {

    }

    // 动态加载Fragment底部Table
    protected void getTablStyle() {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(
                mTabHost.getCurrentTabTag());
        if (fragment instanceof MainHomeFragment) {
            MainHomeFragment mainHomeFragment = (MainHomeFragment) fragment;
        } else if (fragment instanceof MainSecondFragment) {
            MainSecondFragment communityFragment = (MainSecondFragment) fragment;
        } else if (fragment instanceof MainSettingFragment) {
            MainSettingFragment personageFragment = (MainSettingFragment) fragment;
        }
    }

    // 静默网络请求 查看登录状态
    public void onNetRequest() {

    }

    // 主界面处理器
    private static class MainHandler extends Handler {
        public final WeakReference<MainHomeAct> wr;

        public MainHandler(MainHomeAct activity) {
            wr = new WeakReference<MainHomeAct>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            MainHomeAct activity = wr.get();
            if (activity != null) {
                activity.handleMainMessage(msg);
            }
        }
    }

    // 处理消息
    public void handleMainMessage(Message msg) {
        switch (msg.what) {
            case MSG_CODE_LOOP_NEW_DISTRI_BUTION:
                break;
        }
    }

    // 再按一次退出
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - exitTimeMillis == Constants.ZERO || currentTimeMillis - exitTimeMillis > Constants.EXIT_CONTINUED) {
                exitTimeMillis = System.currentTimeMillis();
                T.showShort(this, Constants.EXIT);
                return false;
            } else {
                finish();
                AppManager.getAppManager().AppExit(this);
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
