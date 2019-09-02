package ybq.android.myapplication.view

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import ybq.android.myapplication.R

class PaintCanvasView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : View(context, attrs, defStyleAttr) {

    var paint: Paint = Paint()
    var path: Path = Path()

    private var path1 = Path()
    private var path2 = Path()
    private var point1 = Point(150, 200)
    private var point2 = Point(150, 550)

    private var point3 = Point(150, 1400)
    private var point4 = Point(500, 1400)

    private var point5 = Point(600, 1800)
    private var point6 = Point(600, 2500)

    private val mContext: Context = context
//    private lateinit var bitmap: Bitmap


    init {
        paint = Paint()
        path = Path()



        path1.addCircle((point1.x + 150).toFloat(), (point1.y + 150).toFloat(), 150f, Path.Direction.CW)

        path2.fillType = Path.FillType.INVERSE_WINDING
        path2.addCircle((point2.x + 300).toFloat(), (point2.y + 200).toFloat(), 150f, Path.Direction.CW)
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.color = Color.RED
        val bitmap1 = BitmapFactory.decodeResource(mContext.resources, R.mipmap.j_1)
        val left: Float = ((bitmap1.width) / 10).toFloat()
        val top: Float = ((bitmap1.height) / 10).toFloat()

        canvas?.save()
        canvas?.clipRect(left, top, left + 500, top + 500)
        canvas?.drawBitmap(bitmap1, left, top, paint)
        canvas?.restore()

        val bitmap2 = BitmapFactory.decodeResource(mContext.resources, R.mipmap.h1)
        canvas?.save()
        canvas?.clipPath(path1)
        canvas?.drawBitmap(bitmap2, (point1.x).toFloat(), (point1.y).toFloat(), paint)
        canvas?.restore()

        canvas?.save()
        canvas?.clipPath(path2)
        canvas?.drawBitmap(bitmap2, (point2.x).toFloat(), (point2.y).toFloat(), paint)
        canvas?.restore()

        //Canvas.translate(float dx, float dy) 平移
//        canvas?.save()
//        canvas?.translate(-100f, -100f)
//        canvas?.drawBitmap(bitmap2, point1.x.toFloat(), point1.y.toFloat(), paint)
//        canvas?.restore()

        canvas?.save()
        // 旋转之前把绘制内容移动到轴心（原点）
        canvas?.translate(0f, 400f)
        canvas?.drawBitmap(bitmap2, point2.x.toFloat(), point2.y.toFloat(), paint)
        // 恢复 Camera 的状态
        canvas?.restore()


        //Canvas.rotate(float degrees, float px, float py) 旋转
        val bitmap3 = BitmapFactory.decodeResource(mContext.resources, R.mipmap.j_4)
        val bitmapWidth = bitmap3.width
        val bitmapHeight = bitmap3.height

        canvas?.save()
        canvas?.rotate(180f, (point1.x + 200 + bitmapWidth / 2).toFloat(), (point1.y + bitmapHeight / 2).toFloat())
        canvas?.drawBitmap(bitmap3, point1.x.toFloat(), point1.y.toFloat(), paint)
        canvas?.restore()

        canvas?.save()
        canvas?.rotate(45f,(point2.x + bitmapWidth / 2).toFloat(), (point2.y  +  bitmapHeight / 2).toFloat())
        canvas?.drawBitmap(bitmap3,point2.x.toFloat(), point2.y.toFloat(), paint)
        canvas?.restore()



        //Canvas.scale(float sx, float sy, float px, float py) 放缩
        val bitmap4 = BitmapFactory.decodeResource(mContext.resources, R.mipmap.j_5)
        val bitmapWidth4 = bitmap4.width
        val bitmapHeight4 = bitmap4.height

        canvas?.save()
        canvas?.scale(1.5f, 1.5f, (point3.x + bitmapWidth4 / 2).toFloat(), (point3.y + bitmapHeight4 / 2).toFloat())
        canvas?.drawBitmap(bitmap4, point3.x.toFloat(), point3.y.toFloat(), paint)
        canvas?.restore()

        canvas?.save()
        canvas?.scale(0.6f, 1.6f, (point4.x + bitmapWidth4 / 2).toFloat(), (point4.y + bitmapHeight4 / 2).toFloat())
        canvas?.drawBitmap(bitmap4, point4.x.toFloat(), point4.y.toFloat(), paint)
        canvas?.restore()

        // skew(float sx, float sy) 错切
        // 参数里的 sx 和 sy 是 x 方向和 y 方向的错切系数。
         val bitmap5 = BitmapFactory.decodeResource(mContext.resources, R.mipmap.f1)

        canvas?.save()
        canvas?.skew(0f, 0.5f)
        canvas?.drawBitmap(bitmap5, point5.x.toFloat(), point5.y.toFloat(), paint)
        canvas?.restore()

        val bitmap6 = BitmapFactory.decodeResource(mContext.resources, R.mipmap.z4)

        canvas?.save()
        canvas?.skew(-0.1f, 0f)
        canvas?.drawBitmap(bitmap6, point6.x.toFloat(), point6.y.toFloat(), paint)
        canvas?.restore()


        val ypoint =  point6.y.toFloat() +300f
        canvas?.save()
        canvas?.skew(-0.2f, 0f)
        canvas?.drawBitmap(bitmap6, point6.x.toFloat(), ypoint, paint)
        canvas?.restore()



    }
}
