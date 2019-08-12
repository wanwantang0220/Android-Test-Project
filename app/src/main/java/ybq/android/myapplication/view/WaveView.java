package ybq.android.myapplication.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;

import ybq.android.myapplication.R;

public class WaveView extends View {

    private Paint paint;
    private Path path;
    private int dx;
    private int dy;
    private Bitmap mBitmap;
    private int width;
    private int height;
    private Region region;
    private ValueAnimator animator;

    private int waveView_boatBitmap;
    private boolean waveView_rise;
    private int duration;
    private int originY;
    private int waveLength = 400;
    private int waveHeight = 80;

    public WaveView(Context context) {
        super(context);
    }

    public WaveView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }


    private void init(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.WaveView);
        waveView_boatBitmap = a.getResourceId(R.styleable.WaveView_boatBitmap, 0);
        waveView_rise = a.getBoolean(R.styleable.WaveView_rise, false);
        duration = (int) a.getDimension(R.styleable.WaveView_duration, 2000);
        originY = (int) a.getDimension(R.styleable.WaveView_originY, 500);
        waveHeight = (int) a.getDimension(R.styleable.WaveView_waveHeight, 200);
        waveLength = (int) a.getDimension(R.styleable.WaveView_waveLength, 400);
        a.recycle();


        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 1; //缩放图片
        if (waveView_boatBitmap > 0) {
            mBitmap = BitmapFactory.decodeResource(getResources(), waveView_boatBitmap, options);
            mBitmap = getCircleBitmap(mBitmap);
        } else {
            mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.pic1, options);
        }


        paint = new Paint();
        paint.setColor(getResources().getColor(R.color.blue));
        //封闭的曲线填充
        paint.setStyle(Paint.Style.FILL_AND_STROKE);

        path = new Path();

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //定义曲线
        setPathData();

        canvas.drawPath(path,paint);

        //绘制头像
        Rect bounds = region.getBounds();
        Log.i("TAG","left = "+bounds.left+"  top = "+bounds.top);


        if(bounds.top>0 || bounds.right>0){
            float x = bounds.right-mBitmap.getWidth()/2;
            float yTop = bounds.top-mBitmap.getHeight();
            float ybottom = bounds.bottom-mBitmap.getHeight();
            if(bounds.top<originY){ //从波峰滑落到基准线
                canvas.drawBitmap(mBitmap,x,yTop,paint);
            }else{
                canvas.drawBitmap(mBitmap,x,ybottom,paint);
            }
        }else{
            float x = width/2 - mBitmap.getWidth()/2;
            canvas.drawBitmap(mBitmap,x,originY-mBitmap.getHeight(),paint);
        }
    }

    private void setPathData() {
        path.reset();
        int halfWaveLength = waveLength/2;
        path.moveTo(-waveLength+dx,originY);
         for(int i= -waveLength ;i<width+waveLength ;i+= waveLength){
             //贝塞尔曲线
             //path.quadTo(x1,y1,x2,y2);
             //正弦函数
             path.rQuadTo(halfWaveLength/2,-waveHeight,halfWaveLength,0); //相对坐标
             path.rQuadTo(halfWaveLength/2,waveHeight,halfWaveLength,0);//相对坐标
         }
         //切割矩形
         region = new Region();
         float x = width /2;
         Region clip = new Region((int) (x-0.1),0, (int) x,height);
         region.setPath(path,clip);

         //曲线封闭
         path.lineTo(width,height);
         path.lineTo(0,height);
         path.close();

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //测量时
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        width = widthSize;
        height = heightSize;

        if(originY==0){
            originY = height;
        }

    }

    /**
     * 透明背景的圆形图片
     * 透明背景的是png格式
     *
     * @param bitmap
     * @return
     */
    private Bitmap getCircleBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            Bitmap circleBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(circleBitmap);
            final Paint paint = new Paint();
            //矩形类
            final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            //float矩形类
            final RectF rectF = new RectF(new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()));
            float roudPx = 0.0f;
            //以较短的边为标准
            if (bitmap.getWidth() > bitmap.getHeight()) {
                roudPx = bitmap.getHeight() / 2.0f;
            } else {
                roudPx = bitmap.getWidth() / 2.0f;
            }
            //抗锯齿
            paint.setAntiAlias(true);
            //设置ARGB、颜色填充画布
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(Color.WHITE);
            //绘制圆角矩形 , 指定RectF对象以及圆角半径
            canvas.drawRoundRect(rectF, roudPx, roudPx, paint);
            //图片圆形处理的关键  矩形与圆形重叠处的矩形部分
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            final Rect src = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            //bitmap:图片bitmap  src : 绘制图片的部分   rect: 该图片绘画的位置  paint: 画笔
            canvas.drawBitmap(bitmap, src, rect, paint);
            return  circleBitmap;
        } catch (Exception e) {

        }

        return null;
    }

    public  void  startAnimation(){
        animator = ValueAnimator.ofFloat(0,1);
        animator.setDuration(duration);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());//线性插值器
        animator.addUpdateListener(animation -> {
            float fraction = (float) animation.getAnimatedValue();
            dx = (int) (waveLength * fraction);
            dy += 5;
            //重新绘制
            postInvalidate();
        });
        animator.start();
    }


    public  void  endAnimation(){
        if(animator!=null){
            animator.cancel();
        }
    }
}
