package ybq.android.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.IntEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

import java.util.ArrayList;

import ybq.android.myapplication.R;
import ybq.android.myapplication.util.MyUtils;
import ybq.android.myapplication.view.HorizontalScrollViewEx;

public class LayoutAnimationActivity extends AppCompatActivity {

    private static final String TAG = "LayoutAnimationActivity";

    private HorizontalScrollViewEx mListContainer;
    private Button btn, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_animation);

        initView();
    }

    private void initView() {
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(v -> performAnimate());

        btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performAnimate2(btn2,btn2.getWidth(),500);
            }
        });
    }

    /**
     * 采用ValueAnimator，监听动画过程
     */
    private void performAnimate2(final View target ,final int start, final int end) {

        ValueAnimator valueAnimator = ValueAnimator.ofInt(1,100);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            private IntEvaluator mEvaluator = new IntEvaluator();

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //当前动画的进度值
                int currentValue = (int) animation.getAnimatedValue();

                //当前进度占整个动画过程的比例
                float fraction = animation.getAnimatedFraction();
                //调用整型估值器，通过比例计算出宽度
                target.getLayoutParams().width = mEvaluator.evaluate(fraction,start,end);
                target.requestLayout();

            }
        });
        valueAnimator.setDuration(2000).start();
    }


    /**
     * 用一个类来包装原始对象
     */
    private void performAnimate() {
        ViewWrapper wrapper = new ViewWrapper(btn);
        ObjectAnimator.ofInt(wrapper, "width", 500).setDuration(2000).start();
    }


    private static class ViewWrapper {
        private View mTarget;

        public ViewWrapper(View target) {
            mTarget = target;
        }


        public int getWidth() {
            return mTarget.getLayoutParams().width;
        }

        public void setWidth(int width) {
            mTarget.getLayoutParams().width = width;
            mTarget.requestLayout();
        }

    }


    private void initViewList() {
        LayoutInflater inflater = getLayoutInflater();
        mListContainer = (HorizontalScrollViewEx) findViewById(R.id.container);
        final int screenWidth = MyUtils.getScreenMetrics(this).widthPixels;
        final int screenHeight = MyUtils.getScreenMetrics(this).heightPixels;
        for (int i = 0; i < 1; i++) {
            ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.content_layout, mListContainer, false);
            layout.getLayoutParams().width = screenWidth;
            TextView textView = (TextView) layout.findViewById(R.id.title);
            textView.setText("page " + (i + 1));
            layout.setBackgroundColor(Color.rgb(255 / (i + 1), 255 / (i + 1), 0));
            createList(layout);
            mListContainer.addView(layout);
        }
    }

    private void createList(ViewGroup layout) {
        ListView listView = (ListView) layout.findViewById(R.id.list);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_item);
        LayoutAnimationController controller = new LayoutAnimationController(animation);
        controller.setDelay(0.5f);
        controller.setOrder(LayoutAnimationController.ORDER_NORMAL);
        listView.setLayoutAnimation(controller);

        ArrayList<String> datas = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            datas.add("name " + i);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.content_list_item, R.id.name, datas);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(LayoutAnimationActivity.this, "click item", Toast.LENGTH_SHORT).show();

            }
        });
    }

}
