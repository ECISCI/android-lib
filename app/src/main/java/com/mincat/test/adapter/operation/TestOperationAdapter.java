package com.mincat.test.adapter.operation;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mincat.sample.adapter.operation.BaseRecyclerAdapter;
import com.mincat.sample.operationadapter.OperationAdapterDialog;
import com.mincat.sample.operationadapter.RemoveItemCallBack;
import com.mincat.sample.utils.T;
import com.mincat.test.R;
import com.mincat.test.domain.OperationAdapterBean;

import java.util.List;

/**
 * @author Ming
 * @描述 测试删除RecycleView中的条目
 */

public class TestOperationAdapter extends BaseRecyclerAdapter {

    /**
     * 上下文对象
     */
    public Context context;
    /**
     * 需要传入的数据集合
     */
    public List<?> lists;
    /**
     * 当前adapter类对象（对应功能 adapter条目的删除）
     */
    public TestOperationAdapter adapter;
    /**
     * activity对象（上下文对象相当于Context,但这里一定要传入activity对象,不能传入context）
     */
    private Activity activity;

    private OperationAdapterDialog operationAdapterDialog = OperationAdapterDialog.getInstance();

    /**
     * 一个参数的构造方法
     *
     * @param context
     */
    public TestOperationAdapter(Context context) {
        super(context);
    }

    /**
     * 三个参数的构造方法
     *
     * @param activity activity上下文对象
     * @param lists    数据集合
     */
    public TestOperationAdapter(Activity activity, List<?> lists) {
        super(activity);
        this.activity = activity;
        this.lists = lists;
    }

    /**
     * 填充布局
     *
     * @param parent   父布局
     * @param viewType
     * @return RecyclerView.ViewHolder 对象
     */

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // 渲染布局
        View inflater = LayoutInflater.from(activity).inflate(R.layout.adapter_test_delete, parent, false);

        return new QuestionViewHolder(inflater);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        ((QuestionViewHolder) holder).setData(position);

    }

    /**
     * 获取条目总数
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return lists != null ? lists.size() : 0;
    }

    /**
     * 初始化控件对象
     */
    public class QuestionViewHolder extends RecyclerView.ViewHolder {

        public Button btn_delete;
        public ImageView image;
        public TextView tv_desc;


        public QuestionViewHolder(View itemView) {
            super(itemView);
            btn_delete = itemView.findViewById(R.id.btn_delete);
            image = itemView.findViewById(R.id.image);
            tv_desc = (TextView) itemView.findViewById(R.id.tv_desc);


        }

        /**
         * 为控件设置数据
         *
         * @param position 控件所在位置
         */
        public void setData(final int position) {


            tv_desc.setText(((OperationAdapterBean) lists.get(position)).desc);

            btn_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    operationAdapterDialog.recycleViewRemoveItem(activity, "#676767", "确定删除当前条目?", position, lists, TestOperationAdapter.this, new RemoveItemCallBack() {
                        @Override
                        public void removeItemSuccess(int position, List<?> lists, RecyclerView.Adapter adapter, AlertDialog dialog) {
                            operationAdapterDialog.removeItemInAdapter(position, lists, adapter);

                            T.showShort(activity, "删除的条目是:" + tv_desc.getText().toString().toString());
                            dialog.dismiss();
                        }

                        @Override
                        public void removeItemCancel(AlertDialog dialog) {
                            dialog.dismiss();

                        }
                    });

                }
            });

            if (position == 0) {
                image.setBackgroundResource(R.drawable.message_01);
            } else if (position == 1) {
                image.setBackgroundResource(R.drawable.message_02);
            } else if (position == 2) {
                image.setBackgroundResource(R.drawable.message_03);
            } else if (position == 3) {
                image.setBackgroundResource(R.drawable.message_04);
            } else if (position == 4) {
                image.setBackgroundResource(R.drawable.message_05);
            }


        }

    }


}
