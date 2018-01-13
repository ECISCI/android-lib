package com.mincat.test.adapter;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.mincat.test.R;
import com.mincat.test.testui.Constant;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * @author Ming
 * @描述 列表播放
 */

public class VideoAdapter extends CommonAdapter<String> {
    private Context mContext;

    public VideoAdapter(Context context, List<String> datas, int layoutId) {
        super(context, layoutId, datas);
        this.mContext = context;
    }

    @Override
    protected void convert(ViewHolder viewHolder, String url, int position) {
        JCVideoPlayerStandard player = viewHolder.getView(R.id.player_list_video);
        if (player != null) {
            player.release();
        }
        boolean setUp = player.setUp(url, JCVideoPlayer.SCREEN_LAYOUT_LIST, "");
        if (setUp) {
            Glide.with(mContext).load(Constant.IMAGE_ON_VIDEO).into(player.thumbImageView);
        }
    }
}

