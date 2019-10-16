package ybq.android.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ybq.android.myapplication.activity.CalendarDateActivity;
import ybq.android.myapplication.activity.EightActivity;
import ybq.android.myapplication.activity.ExpandableRecyclerViewActivity;
import ybq.android.myapplication.activity.KotlinBasic2Activity;
import ybq.android.myapplication.activity.KotlinBasic3Activity;
import ybq.android.myapplication.activity.KotlinLaunchActivity;
import ybq.android.myapplication.activity.KotlinMainActivity;
import ybq.android.myapplication.activity.LottieAnimationActivity;
import ybq.android.myapplication.activity.NineActivity;
import ybq.android.myapplication.activity.SevenActivity;
import ybq.android.myapplication.activity.TabFragmentActivity;
import ybq.android.myapplication.activity.TenActivity;
import ybq.android.myapplication.activity.WaveViewActivity;
import ybq.android.myapplication.activity.ZhiHuFragmentActivity;
import ybq.android.myapplication.app.AppConstant;
import ybq.android.myapplication.hencoder.HenderMainActivity;

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
            if (title.equals(AppConstant.LIST_TITLE0)) {
                Intent intent = new Intent(mContext, KotlinMainActivity.class);
                mContext.startActivity(intent);
            } else if (title.equals(AppConstant.LIST_TITLE1)) {
                Intent intent = new Intent(mContext, ExpandableRecyclerViewActivity.class);
                mContext.startActivity(intent);
            } else if (title.equals(AppConstant.LIST_TITLE2)) {
                Intent intent = new Intent(mContext, CalendarDateActivity.class);
                mContext.startActivity(intent);
            } else if (title.equals(AppConstant.LIST_TITLE3)) {
                Intent intent = new Intent(mContext, WaveViewActivity.class);
                mContext.startActivity(intent);
            } else if (title.equals(AppConstant.LIST_TITLE5)) {
                Intent intent = new Intent(mContext, KotlinBasic2Activity.class);
                mContext.startActivity(intent);
            } else if (title.equals(AppConstant.LIST_TITLE6)) {
                Intent intent = new Intent(mContext, KotlinBasic3Activity.class);
                mContext.startActivity(intent);
            }else if (title.equals(AppConstant.LIST_TITLE7)) {
                Intent intent = new Intent(mContext, SevenActivity.class);
                mContext.startActivity(intent);
            }else if (title.equals(AppConstant.LIST_TITLE8)) {
                Intent intent = new Intent(mContext, EightActivity.class);
                mContext.startActivity(intent);
            }else if (title.equals(AppConstant.LIST_TITLE9)) {
                Intent intent = new Intent(mContext, NineActivity.class);
                mContext.startActivity(intent);
            }else if (title.equals(AppConstant.LIST_TITLE10)) {
                Intent intent = new Intent(mContext, HenderMainActivity.class);
                mContext.startActivity(intent);
            }else if (title.equals(AppConstant.LIST_TITLE11)) {
                Intent intent = new Intent(mContext, KotlinLaunchActivity.class);
                mContext.startActivity(intent);
            }else if (title.equals(AppConstant.LIST_TITLE12)) {
                Intent intent = new Intent(mContext, LottieAnimationActivity.class);
                mContext.startActivity(intent);
            }else if (title.equals(AppConstant.LIST_TITLE13)) {
                Intent intent = new Intent(mContext, TabFragmentActivity.class);
                mContext.startActivity(intent);
            }else if (title.equals(AppConstant.LIST_TITLE14)) {
                Intent intent = new Intent(mContext, ZhiHuFragmentActivity.class);
                mContext.startActivity(intent);
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
