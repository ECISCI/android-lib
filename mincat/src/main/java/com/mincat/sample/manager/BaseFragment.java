package com.mincat.sample.manager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.mincat.sample.custom.CustomProgressDialog;
import com.mincat.sample.utils.IntentUtils;
import com.mincat.sample.utils.L;

/**
 * @author Michael
 *         Fragment基类  基于网络请求
 */
public abstract class BaseFragment extends Fragment {
    public static final String TAG = BaseFragment.class.getName();

    protected IntentUtils intentUtils = IntentUtils.getInstance();

    protected CustomProgressDialog customProgressDialog = CustomProgressDialog.getInstance();
    /**
     * 请求超时时间
     */
    protected static final int REQUEST_TIMEOUT = 15000;

    /**
     * Volley请求队列
     */
    protected RequestQueue mQueue;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        L.i(TAG, "BaseFragment onCreateView");

        return super.onCreateView(inflater, container, savedInstanceState);

    }


    @Override
    public void onDestroyView() {

        System.gc();
        System.gc();
        System.gc();
        L.i(TAG, "BaseFragment  onDestroyView ");
        super.onDestroyView();
    }
}
