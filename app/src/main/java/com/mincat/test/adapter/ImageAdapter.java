package com.mincat.test.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.mincat.sample.imagecache.more.CacheMoreImage;
import com.mincat.sample.operationadapter.OperationAdapterDialog;
import com.mincat.test.R;

import java.util.List;

/**
 * @author Ming
 * @描述 此处做了多张图片缓存 展示
 * @说明 此处同样展示了对adapter的相关操作
 */

public class ImageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    // 需要传入Recycle 保证图片加载Tag不错位
    private RecyclerView recyclerView;

    private Activity activity;
    private List<String> imageUrl;

    private CacheMoreImage cacheMoreImage = CacheMoreImage.getInstance();
    private OperationAdapterDialog dialog = OperationAdapterDialog.getInstance();

    public ImageAdapter(Activity activity, List<String> imageUrl, RecyclerView recyclerView) {
        this.activity = activity;
        this.imageUrl = imageUrl;
        this.recyclerView = recyclerView;


        /**
         *   **** 这个初始化操作必须要做
         */
        cacheMoreImage.initCacheParam(activity, recyclerView);

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View inflater = LayoutInflater.from(activity).inflate(R.layout.adapter_messages, parent, false);

        return new QuestionViewHolder(inflater);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        ((QuestionViewHolder) holder).setData(position);

    }

    @Override
    public int getItemCount() {
        return imageUrl != null ? imageUrl.size() : 0;
    }

    public class QuestionViewHolder extends RecyclerView.ViewHolder {

        public ImageView item_image;
        public Button remove_item;

        public QuestionViewHolder(View itemView) {
            super(itemView);
            item_image = (ImageView) itemView.findViewById(R.id.item_image);
            remove_item = (Button) itemView.findViewById(R.id.remove_item);


        }

        public void setData(final int position) {


            /**
             * 此处会根据本地是否有缓存加载图片,如果本地有缓存从本地取出缓存加载图片 如果本地没有缓存则去网络上下载 下载完成会缓存到本地
             */
            cacheMoreImage.cacheImage(item_image, imageUrl.get(position));

            item_image.setTag(imageUrl.get(position));

        }

    }

}