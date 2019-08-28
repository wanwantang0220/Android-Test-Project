package ybq.android.myapplication.bean;



import androidx.annotation.NonNull;

import java.util.List;

import ybq.android.myapplication.view.expandview.BaseExpandableRecyclerViewAdapter;


public class SampleGroupBean implements BaseExpandableRecyclerViewAdapter.BaseGroupBean<SampleChildBean> {

    private List<SampleChildBean> mList;
    private String mName;

    public SampleGroupBean(@NonNull List<SampleChildBean> list, @NonNull String name) {
        mList = list;
        mName = name;
    }

    @Override
    public int getChildCount() {
        return mList.size();
    }

    @Override
    public boolean isExpandable() {
        return getChildCount() > 0;
    }

    public String getName() {
        return mName;
    }

    @Override
    public SampleChildBean getChildAt(int index) {
        return mList.size() <= index ? null : mList.get(index);
    }
}
