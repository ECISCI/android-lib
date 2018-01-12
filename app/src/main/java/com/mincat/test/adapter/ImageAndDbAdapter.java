package com.mincat.test.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mincat.sample.imagecache.more.CacheMoreImage;
import com.mincat.sample.operationadapter.OperationAdapterDialog;
import com.mincat.test.R;
import com.mincat.test.domain.Person;

import java.util.List;

/**
 * @author Ming
 */

public class ImageAndDbAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    // 需要传入Recycle 保证图片加载Tag不错位
    private RecyclerView recyclerView;

    private Activity activity;
    private List<?> lists;

    private CacheMoreImage cacheMoreImage = CacheMoreImage.getInstance();
    private OperationAdapterDialog dialog = OperationAdapterDialog.getInstance();

    public ImageAndDbAdapter(Activity activity, List<?> lists, RecyclerView recyclerView) {
        this.activity = activity;
        this.lists = lists;
        this.recyclerView = recyclerView;


        /**
         *   **** 这个初始化操作必须要做
         */
        cacheMoreImage.initCacheParam(activity, recyclerView);

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View inflater = LayoutInflater.from(activity).inflate(R.layout.adapter_person, parent, false);

        return new QuestionViewHolder(inflater);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        ((QuestionViewHolder) holder).setData(position);

    }

    @Override
    public int getItemCount() {
        return lists != null ? lists.size() : 0;
    }

    public class QuestionViewHolder extends RecyclerView.ViewHolder {

        public ImageView item_image;
        public TextView tv_username, tv_sex, tv_age;

        public QuestionViewHolder(View itemView) {
            super(itemView);
            item_image = (ImageView) itemView.findViewById(R.id.item_image);
            tv_username = (TextView) itemView.findViewById(R.id.tv_username);
            tv_sex = (TextView) itemView.findViewById(R.id.tv_sex);
            tv_age = (TextView) itemView.findViewById(R.id.tv_age);


        }

        public void setData(final int position) {

            String imageUrl = ((Person) lists.get(position)).imageUrl;

            tv_username.setText(((Person) lists.get(position)).name);
            tv_sex.setText(((Person) lists.get(position)).sex);
            tv_age.setText(((Person) lists.get(position)).age + "");
            /**
             * 此处会根据本地是否有缓存加载图片,如果本地有缓存从本地取出缓存加载图片 如果本地没有缓存则去网络上下载 下载完成会缓存到本地
             */
            cacheMoreImage.cacheImage(item_image, imageUrl);

            item_image.setTag(imageUrl);

        }

    }

}