package ybq.android.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;

import ybq.android.myapplication.R;
import ybq.android.myapplication.view.viewholder.FirstLayoutViewHolder;

public class FirstLayoutAdapter extends DelegateAdapter.Adapter<FirstLayoutViewHolder> {


    private LayoutHelper mLayoutHelper;
    private LayoutInflater mInflater;
    private String mReadStatus;
    private Context mContext;

    private ClickListener mClickListener;

    public FirstLayoutAdapter(Context context, LayoutHelper layoutHelper) {
        mContext = context;
        mLayoutHelper = layoutHelper;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return mLayoutHelper;
    }

    @NonNull
    @Override
    public FirstLayoutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.vlayout_adapter_item_first, parent, false);
        return new FirstLayoutViewHolder(mContext, view);
    }

    @Override
    public void onBindViewHolder(@NonNull FirstLayoutViewHolder holder, int position) {
//        holder.ivLeft.setText("测试数据");

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }


    public interface ClickListener {
        void onClick(View view);
    }

    public void setClickListener(ClickListener clickListener) {
        mClickListener = clickListener;
    }
}
