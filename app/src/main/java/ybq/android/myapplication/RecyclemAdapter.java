package ybq.android.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ybq.android.myapplication.app.AppConstant;

public class RecyclemAdapter extends RecyclerView.Adapter<RecyclemAdapter.ComViewHolder> {


    private Context mContext;
    private List<String> mList = new ArrayList<>();


    public RecyclemAdapter(Context context) {
        this.mContext = context;
    }

    @NonNull
    @Override
    public ComViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);
        return new ComViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ComViewHolder viewHolder, final int i) {
        viewHolder.tv.setText(mList.get(i));
        viewHolder.tv.setOnClickListener(v -> {
            String title = mList.get(i);
            if (title.equals(AppConstant.LIST_TITLE1)) {
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public void setData(ArrayList<String> list) {
        mList.clear();
        if (list != null && list.size() > 0) {
            mList.addAll(list);
            notifyDataSetChanged();
        } else {
            notifyDataSetChanged();
        }
    }


    class ComViewHolder extends RecyclerView.ViewHolder {

        TextView tv;

        public ComViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tvItem);
        }
    }
}
