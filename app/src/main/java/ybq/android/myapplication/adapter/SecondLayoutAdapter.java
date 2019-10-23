package ybq.android.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;

import ybq.android.myapplication.R;
import ybq.android.myapplication.view.viewholder.SecondLayoutViewHolder;

public class SecondLayoutAdapter extends DelegateAdapter.Adapter<SecondLayoutViewHolder> {


    private LayoutHelper mLayoutHelper;
    private LayoutInflater mInflater;
    private String mReadStatus;
    private Context mContext;

    private ClickListener mClickListener;

    public SecondLayoutAdapter(Context context, LayoutHelper layoutHelper) {
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
    public SecondLayoutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.vlayout_adapter_item_second, parent, false);
        return new SecondLayoutViewHolder(mContext, view);
    }

    @Override
    public void onBindViewHolder(@NonNull SecondLayoutViewHolder holder, int position) {
//        holder.tvTest.setText("nihao");

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
