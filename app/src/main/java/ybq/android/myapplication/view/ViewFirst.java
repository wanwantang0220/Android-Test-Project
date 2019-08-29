package ybq.android.myapplication.view;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class ViewFirst  extends View {

    private Paint paint;

    public ViewFirst(Context context) {
        super(context);
        init();
    }

    public ViewFirst(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ViewFirst(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public ViewFirst(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(300,300,200,paint);

    }
}
