package com.mincat.sample.imagecache.utils;

import android.content.Context;

import com.mincat.sample.imagecache.DiskLruCache;
import com.mincat.sample.utils.L;

import java.io.IOException;

/**
 * @author Ming
 * @描述 删除全部缓存数据
 */

public class DeleteAllImageCache {

    private static final String TAG = DeleteAllImageCache.class.getSimpleName();

    private static DiskLruCache diskLruCache;

    public static void delete(Context context) {

        try {
            diskLruCache = CreateDiskLruCache.create(context);
            diskLruCache.delete();
            L.i(TAG, "图片缓存已全部清除");
        } catch (IOException e) {
            e.printStackTrace();
            L.i(TAG, "清除全部图片缓存失败:" + e);
        }


    }
}
