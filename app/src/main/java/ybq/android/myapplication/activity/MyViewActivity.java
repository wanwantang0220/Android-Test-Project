package ybq.android.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import ybq.android.myapplication.R;
import ybq.android.myapplication.view.MyViewLayout;

public class MyViewActivity extends AppCompatActivity {

    MyViewLayout myview;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_view);

        myview = findViewById(R.id.myview);
        //沿X轴向右平移
        myview.smoothScrollTo(-600,0);

        btn = findViewById(R.id.btn);
        MyView view = new MyView(btn);
        ObjectAnimator.ofInt(view,"width",500).setDuration(500);
    }

    private static class MyView{

        private View mTarget;

        private MyView(View target){
            this.mTarget = target;
        }

        public int getWidth(){
            return mTarget.getLayoutParams().width;
        }

        public void setWidth(int width){
            mTarget.getLayoutParams().width = width;
            mTarget.requestLayout();
        }


    }
}
