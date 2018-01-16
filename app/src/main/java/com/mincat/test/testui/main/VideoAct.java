package com.mincat.test.testui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.mincat.sample.manager.base.AppCompat;
import com.mincat.test.R;
import com.mincat.test.testui.video.VideoPlay;

/**
 * @author Ming
 * @描述 视频播放
 */
public class VideoAct extends AppCompat {

    private Button play_single;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video);
        initView();
    }

    @Override
    public void initView() {
        initToolBar(R.id.toolbar);
        play_single = getId(R.id.play_single);
        play_single.setOnClickListener(this);

    }

    @Override
    public void onNetRequest() {

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.play_single:

                intentUtils.openActivityFromRight(this, VideoPlay.class);
                break;
        }

    }
}
