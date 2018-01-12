package com.mincat.test.testui.video;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.mincat.sample.manager.base.AppCompat;
import com.mincat.sample.video.PlayNetVideo;
import com.mincat.sample.utils.L;
import com.mincat.test.R;
import com.mincat.test.testui.Constant;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * @author Mings
 * @描述 视频播放组件
 * @注意 java.lang.UnsatisfiedLinkError 出现如上错误,请在真机上播放
 * @注意 此类最好是 AppCompatActivity 的子类
 */

public class VideoPlay extends AppCompat {


    private JCVideoPlayerStandard player;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_video);
        initView();
    }

    @Override
    public void initView() {

        initToolBar(R.id.toolbar);

        player = getId(R.id.player_net_video);

        // 此处最好做try catch处理
        try {
            // 播放网络视频
            PlayNetVideo.playNetVideo(this, player, Constant.VIDEO_NET_URL, Constant.IMAGE_ON_VIDEO);
        } catch (Exception e) {

            L.i(TAG, "视频播放错误信息:" + e);
        }


    }

    @Override
    public void onNetRequest() {

    }

    @Override
    public void onClick(View view) {

    }

    /**
     * 此方法必须重写
     */
    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    /**
     * 此方法必须重写
     */
    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

}
