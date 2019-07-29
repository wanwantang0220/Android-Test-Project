package ybq.android.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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
        mList.add(AppConstant.LIST_TITLE1);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclemAdapter adpter = new RecyclemAdapter(this);
        adpter.setData(mList);
        recyclerView.setAdapter(adpter);
    }
}
