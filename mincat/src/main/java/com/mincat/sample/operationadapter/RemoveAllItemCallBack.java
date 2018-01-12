package com.mincat.sample.operationadapter;

import android.app.AlertDialog;
import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * @author Ming
 * @描述 删除adapter全部条目回调接口
 */

public interface RemoveAllItemCallBack {

    void removeAllItemSuccess(final List<?> lists, final RecyclerView.Adapter adapter, AlertDialog dialog);

    void removeAllItemCancel(AlertDialog dialog);
}
