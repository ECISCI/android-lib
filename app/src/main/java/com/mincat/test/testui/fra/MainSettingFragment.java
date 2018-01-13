package com.mincat.test.testui.fra;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mincat.sample.manager.BaseFragment;
import com.mincat.test.R;


/**
 * @author Michael
 */

public class MainSettingFragment extends BaseFragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fra_setting, null);

        return view;
    }


}
