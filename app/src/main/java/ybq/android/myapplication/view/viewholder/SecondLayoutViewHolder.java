package ybq.android.myapplication.view.viewholder;

import android.content.Context;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import ybq.android.myapplication.R;

public class SecondLayoutViewHolder extends RecyclerView.ViewHolder {


    public RecyclerView rvSecond;

    public SecondLayoutViewHolder(Context mContext, View view) {
        super(view);

        rvSecond = view.findViewById(R.id.rvSecond);
    }
}
