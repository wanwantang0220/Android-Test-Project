package ybq.android.myapplication.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import ybq.android.myapplication.R

class PaintView3 @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : View(context, attrs, defStyleAttr) {

    private val mContext: Context = context
    private var paint = Paint(Paint.ANTI_ALIAS_FLAG)

    var bitmap: Bitmap
    private var maskFilter1: MaskFilter = BlurMaskFilter(50f, BlurMaskFilter.Blur.NORMAL)
    private var maskFilter2: MaskFilter = BlurMaskFilter(50f, BlurMaskFilter.Blur.INNER)
    private var maskFilter3: MaskFilter = BlurMaskFilter(50f, BlurMaskFilter.Blur.OUTER)
    private var maskFilter4: MaskFilter = BlurMaskFilter(50f, BlurMaskFilter.Blur.SOLID)

    internal var pathPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var path = Path()
    internal var path1 = Path()
    internal var path2 = Path()
    internal var path3 = Path()


    init {

        paint  = Paint(Paint.ANTI_ALIAS_FLAG)

//        setLayerType(LAYER_TYPE_SOFTWARE, null)
        bitmap = BitmapFactory.decodeResource(mContext.resources, R.mipmap.what_the_fuck)

        path.moveTo(50f, 100f)
        path.rLineTo(50f, 100f)
        path.rLineTo(80f, -150f)
        path.rLineTo(100f, 100f)
        path.rLineTo(70f, -120f)
        path.rLineTo(150f, 80f)

        pathPaint.style = Paint.Style.STROKE
    }


    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 20f

        //BlurMaskFilter 模糊效果的 MaskFilter
        paint.maskFilter = maskFilter1
        canvas?.drawBitmap(bitmap, 100f, 550f, paint)

        paint.maskFilter = maskFilter2
        canvas?.drawBitmap(bitmap, (bitmap.width + 200).toFloat(), 550f, paint)

        paint.maskFilter = maskFilter3
        canvas?.drawBitmap(bitmap, 100f, (bitmap.height + 700).toFloat(), paint)

        paint.maskFilter = maskFilter4
        canvas?.drawBitmap(bitmap, (bitmap.width + 200).toFloat(), (bitmap.height + 700).toFloat(), paint)


        // 使用 Paint . getFillPath () 获取实际绘制的 Path

        // 第一处：获取 Path
        paint.style = Paint.Style.FILL_AND_STROKE
        paint.strokeWidth = 0f
        paint.getFillPath(path, path1)
        canvas?.drawPath(path, paint)

        canvas?.save()
        canvas?.translate(500f, 0f)
        canvas?.drawPath(path1, pathPaint)
        canvas?.restore()

        canvas?.save()
        canvas?.translate(0f, 200f)
        paint.style = Paint.Style.STROKE
        // 第二处：设置 Style 为 STROKE 后再获取 Path
        paint.getFillPath(path, path2)
        canvas?.drawPath(path, paint)
        canvas?.restore()

        canvas?.save()
        canvas?.translate(500f, 200f)
        canvas?.drawPath(path2, pathPaint)
        canvas?.restore()

        canvas?.save()
        canvas?.translate(0f, 400f)
        paint.strokeWidth = 40f
        // 第三处：Style 为 STROKE 并且线条宽度为 40 时的 Path
        paint.getFillPath(path, path3)
        canvas?.drawPath(path, paint)
        canvas?.restore()

        canvas?.save()
        canvas?.translate(500f, 400f)
        canvas?.drawPath(path3, pathPaint)
        canvas?.restore()
    }


}