package com.mincat.sample.operationadapter;

import android.app.AlertDialog;
import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * @author Ming
 */

public interface RemoveItemCallBack {

    void removeItemSuccess(final int position, final List<?> lists, final RecyclerView.Adapter adapter, AlertDialog dialog);
    void removeItemCancel(AlertDialog dialog);
}
