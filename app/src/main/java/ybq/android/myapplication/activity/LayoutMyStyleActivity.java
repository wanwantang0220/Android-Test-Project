package ybq.android.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;

import ybq.android.myapplication.R;
import ybq.android.myapplication.adapter.FirstLayoutAdapter;
import ybq.android.myapplication.adapter.SecondLayoutAdapter;

public class LayoutMyStyleActivity extends AppCompatActivity {


    private VirtualLayoutManager layoutManager;
    private DelegateAdapter delegateAdapter;
    private RecyclerView myStylerRv;

    private SingleLayoutHelper firstLayoutHelper;
    private FirstLayoutAdapter firstLayoutAdapter;

    private SingleLayoutHelper secondLayoutHelper;
    private SecondLayoutAdapter secondLayoutAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_my_style);

        myStylerRv = findViewById(R.id.my_style_rv);

        layoutManager = new VirtualLayoutManager(this);
        delegateAdapter = new DelegateAdapter(layoutManager, false);

        myStylerRv.setLayoutManager(layoutManager);
        myStylerRv.setAdapter(delegateAdapter);

        firstLayoutHelper = new SingleLayoutHelper();
        firstLayoutAdapter = new FirstLayoutAdapter(this, firstLayoutHelper);

        secondLayoutHelper = new SingleLayoutHelper();
        secondLayoutAdapter = new SecondLayoutAdapter(this, secondLayoutHelper);

        delegateAdapter.addAdapter(firstLayoutAdapter);
        delegateAdapter.addAdapter(secondLayoutAdapter);
    }
}
