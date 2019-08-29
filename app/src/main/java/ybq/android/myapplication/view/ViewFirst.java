package ybq.android.myapplication.view;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class ViewFirst  extends View {

    private Paint paint;
    private Path path;
    private Context mContext;


    public ViewFirst(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public ViewFirst(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    public ViewFirst(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
    }

    public ViewFirst(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mContext = context;
        init();
    }

    private void init() {
        paint = new Paint();
        path = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setColor(Color.RED);

        paint.setStrokeWidth(20);
        paint.setStyle(Paint.Style.STROKE);
        path.lineTo(100,100);




        //使用Path对图形进行描述
        path.addArc(200, 200, 400, 400, -225, 225);
        path.arcTo(400, 200, 600, 400, -180, 225, false);
        path.lineTo(400, 542);
        canvas.drawPath(path,paint);

        path.addCircle(200,200,200,Path.Direction.CW);
        canvas.drawPath(path,paint);






        /** 画圆 **/
        //背景色
        paint.setColor(Color.BLUE);
        //环形
        paint.setStyle(Paint.Style.STROKE);
        //线条宽度
        paint.setStrokeWidth(20);
        //抗锯齿
        paint.setAntiAlias(true);
        canvas.drawColor(Color.parseColor("#88880000"));
        canvas.drawCircle(300,300,200,paint);

        /** 画矩形 **/
        paint.setStyle(Paint.Style.FILL);

        //四条边的坐标
        canvas.drawRect(100,600,500,1000,paint);

        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(700,600,1100,1000,paint);

        //画点
        paint.setStrokeWidth(100);
        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawPoint(100,1100,paint);

        //批量画点
        float[] points = {0, 0, 100, 1250, 300, 1250, 300, 1450, 500, 1450, 500, 1850, 800, 1850};
        canvas.drawPoints(points, 2 /* 跳过两个数，即前两个 0 */,
                8 /* 一共绘制 8 个数（4 个点）*/, paint);


        //画椭圆
        paint.setStyle(Paint.Style.FILL);
        canvas.drawOval(100,1600,500,1700,paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(30);
        canvas.drawOval(700,1500,1200,1700,paint);

        //画线
        canvas.drawLine(100,1800,600,2000,paint);

        //画圆角矩形
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRoundRect(100,2100,600,2400,50,50,paint);

        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRoundRect(700,2100,1200,2400,50,50,paint);



    }
}
