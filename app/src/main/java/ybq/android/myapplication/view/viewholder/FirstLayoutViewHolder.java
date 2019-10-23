package ybq.android.myapplication.view.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import ybq.android.myapplication.R;

public class FirstLayoutViewHolder extends RecyclerView.ViewHolder {


    public ImageView ivLeft , ivRightTop ,ivRightBottom;

    public FirstLayoutViewHolder(Context mContext, View view) {
        super(view);

        ivLeft = view.findViewById(R.id.ivLeft);
        ivRightTop = view.findViewById(R.id.ivRightTop);
        ivRightBottom = view.findViewById(R.id.ivRightBottom);
    }
}
