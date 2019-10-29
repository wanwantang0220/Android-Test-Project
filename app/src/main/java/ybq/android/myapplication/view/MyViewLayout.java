package ybq.android.myapplication.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Scroller;

import androidx.annotation.Nullable;

public class MyViewLayout extends View {

    private int lastX;
    private int lastY;

    private Scroller mScroller;

    public MyViewLayout(Context context) {
        super(context);
    }

    public MyViewLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mScroller = new Scroller(context);
    }


    public MyViewLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if(mScroller.computeScrollOffset()){
            ((View)getParent()).scrollTo(mScroller.getCurrX(),mScroller.getCurrY());
            invalidate();
        }
    }


    public void smoothScrollTo(int destX,int destY){
        int scrollX = getScrollX();
        int delta = destX - scrollX;
        mScroller.startScroll(scrollX,0,delta,0,2000);
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        int x = (int) event.getX();
//        int y = (int) event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
//                lastX = x;
//                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                //计算移动的距离
//                int offsetX = x - lastX;
//                int offsetY = y - lastY;
//                layout(getLeft() + offsetX,getTop()+ offsetY,
//                        getRight()+offsetX,getBottom()+offsetY);
                break;
            case MotionEvent.ACTION_POINTER_UP:

                break;
        }

        return super.onTouchEvent(event);
    }
}
