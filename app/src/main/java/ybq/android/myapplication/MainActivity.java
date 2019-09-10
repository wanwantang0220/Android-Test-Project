package ybq.android.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import ybq.android.myapplication.app.AppConstant;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    ArrayList<String> mList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initRecycleView();

    }

    private void initRecycleView() {
        mList.add(AppConstant.LIST_TITLE0);
        mList.add(AppConstant.LIST_TITLE1);
        mList.add(AppConstant.LIST_TITLE2);
        mList.add(AppConstant.LIST_TITLE3);
        mList.add(AppConstant.LIST_TITLE5);
        mList.add(AppConstant.LIST_TITLE6);
        mList.add(AppConstant.LIST_TITLE7);
        mList.add(AppConstant.LIST_TITLE8);
        mList.add(AppConstant.LIST_TITLE9);
        mList.add(AppConstant.LIST_TITLE10);
        mList.add(AppConstant.LIST_TITLE11);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclemAdapter adpter = new RecyclemAdapter(this);
        adpter.setData(mList);
        recyclerView.setAdapter(adpter);
    }
}
