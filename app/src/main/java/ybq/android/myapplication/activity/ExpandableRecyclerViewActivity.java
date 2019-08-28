package ybq.android.myapplication.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ybq.android.myapplication.R;
import ybq.android.myapplication.adapter.SampleAdapter;
import ybq.android.myapplication.bean.SampleChildBean;
import ybq.android.myapplication.bean.SampleGroupBean;
import ybq.android.myapplication.view.expandview.ViewProducer;

public class ExpandableRecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_recycler_view);


        List<SampleGroupBean> list = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            final List<SampleChildBean> childList = new ArrayList<>(i);
            for (int j = 0; j < i; j++) {
                childList.add(new SampleChildBean("child " + i));
            }
            list.add(new SampleGroupBean(childList, "group " + i));
        }

        final RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SampleAdapter adapter = new SampleAdapter(list);
        adapter.setEmptyViewProducer(new ViewProducer() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
                return new DefaultEmptyViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.empty, parent, false)
                );
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder) {

            }
        });
        adapter.setHeaderViewProducer(new ViewProducer() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
                return new DefaultEmptyViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.header, parent, false)
                );
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder) {

            }
        }, false);
        recyclerView.setAdapter(adapter);

    }
}
