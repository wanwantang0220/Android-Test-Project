package ybq.android.myapplication.view;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class ViewPaintPath extends View {

    private Paint paint;
    private Path path;
    private Context mContext;

    public ViewPaintPath(Context context) {
        super(context);
    }

    public ViewPaintPath(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewPaintPath(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ViewPaintPath(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
