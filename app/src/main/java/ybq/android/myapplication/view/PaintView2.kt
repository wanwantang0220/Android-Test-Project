package ybq.android.myapplication.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View


class PaintView2 @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : View(context, attrs, defStyleAttr) {

    private var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var path = Path()
    private var cornerPathEffect: PathEffect = CornerPathEffect(20f)
    private var discretePathEffect: PathEffect = DiscretePathEffect(20f, 5f)
    private var dashPathEffect: PathEffect = DashPathEffect(floatArrayOf(20f, 10f, 5f, 10f), 0f)
    private var pathDashPathEffect: PathEffect? = null
    private var sumPathEffect: PathEffect = SumPathEffect(dashPathEffect, discretePathEffect)
    private var composePathEffect: PathEffect = ComposePathEffect(dashPathEffect, discretePathEffect)


    init {
        paint.style = Paint.Style.STROKE

        path.moveTo(50f, 100f)
        path.rLineTo(50f, 100f)
        path.rLineTo(80f, -150f)
        path.rLineTo(100f, 100f)
        path.rLineTo(70f, -120f)
        path.rLineTo(150f, 80f)

        val dashPath = Path()
        dashPath.lineTo(20f, -30f)
        dashPath.lineTo(40f, 0f)
        dashPath.close()
        paint.strokeWidth = 10f
        pathDashPathEffect = PathDashPathEffect(dashPath, 50f, 0f, PathDashPathEffect.Style.MORPH)


    }


    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)


        // 使用 Paint.setPathEffect() 来设置不同的 PathEffect

        // CornerPathEffect  把所有拐角变成圆角
        paint.pathEffect = cornerPathEffect
        canvas?.drawPath(path, paint)

        canvas?.save()
        canvas?.translate(500f, 0f)

        // DiscretePathEffect  把线条进行随机的偏离，让轮廓变得乱七八糟
        paint.pathEffect = discretePathEffect
        canvas?.drawPath(path, paint)
        canvas?.restore()

        canvas?.save()
        canvas?.translate(0f, 200f)

        // DashPathEffect  使用虚线来绘制线条
        paint.pathEffect = dashPathEffect
        canvas?.drawPath(path, paint)
        canvas?.restore()

        canvas?.save()
        canvas?.translate(500f, 200f)

        // PathDashPathEffect
        // 使用一个三角形来做 dash
        paint.pathEffect = pathDashPathEffect
        canvas?.drawPath(path, paint)
        canvas?.restore()

        canvas?.save()
        canvas?.translate(0f, 400f)

        // SumPathEffect
        // 按照两种 PathEffect 分别对目标进行绘制
        paint.pathEffect = sumPathEffect
        canvas?.drawPath(path, paint)
        canvas?.restore()

        canvas?.save()
        canvas?.translate(500f, 400f)

        // ComposePathEffect
        //组合效果类  对目标 Path 使用一个 PathEffect，然后再对这个改变后的 Path 使用另一个 PathEffec
        paint.pathEffect = composePathEffect
        canvas?.drawPath(path, paint)
        canvas?.restore()

        paint.pathEffect = null

        paint.setShadowLayer(10F, 0F, 0F, Color.RED)
        paint.textSize = 120f
        canvas?.drawText("Hello World ! ", 10F, 600F, paint)

        val dashEffect = DashPathEffect(floatArrayOf(20f, 10f), 0f)
        val discreteEffect = DiscretePathEffect(20f, 10f)
        val pathEffect = SumPathEffect(dashEffect, discreteEffect)
        paint.pathEffect = pathEffect
        canvas?.drawPath(path, paint)
        path.close()


    }
}