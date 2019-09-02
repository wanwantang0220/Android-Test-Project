package ybq.android.myapplication.view

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import ybq.android.myapplication.R

class PaintMatrixView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : View(context, attrs, defStyleAttr) {

    var paint: Paint = Paint()
    var path: Path = Path()
    lateinit var bitmap: Bitmap
    private var point1 = Point(200, 200)
    private var point2 = Point(600, 200)

    private var point3 = Point(200, 500)
    private var point4 = Point(600, 500)

    private var point5 = Point(200, 1000)
    private var point6 = Point(800, 1000)

    private var point7 = Point(600, 2500)
    private var point8 = Point(600, 3000)

    private var point9 = Point(200, 3300)
    private var point10 = Point(200, 4000)

    private var point11 = Point(200, 5500)
    private var camera = Camera()
    internal var matrix = Matrix()
    private val mContext: Context = context

    internal var degree: Int = 0
    @SuppressLint("ObjectAnimatorBinding")
    internal var animator = ObjectAnimator.ofInt(this, "degree", 0, 360)


    init {
        paint = Paint()
        path = Path()
        bitmap = BitmapFactory.decodeResource(mContext.resources, R.drawable.maps)

        val scaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.width * 2, bitmap.height * 2, true)
        bitmap.recycle()
        bitmap = scaledBitmap

//        animator.duration = 5000
//        animator.interpolator = LinearInterpolator()
//        animator.repeatCount = ValueAnimator.INFINITE

        animator.duration = 2500
        animator.interpolator = LinearInterpolator()
        animator.repeatCount = ValueAnimator.INFINITE
        animator.repeatMode = ValueAnimator.REVERSE

        val displayMetrics = resources.displayMetrics
        val newZ = -displayMetrics.density * 6
        camera.setLocation(0f, 0f, newZ)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        animator.start()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        animator.end()
    }

    fun setDegree(degree: Int) {
        this.degree = degree
        invalidate()
    }


    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        //pre/postTranslate/Rotate/Scale/Skew() 方法来设置几何变换
        canvas?.save()
        matrix.reset()
        matrix.postTranslate(-100f, -100f)
        canvas?.concat(matrix)
        canvas?.drawBitmap(bitmap, point1.x.toFloat(), point1.y.toFloat(), paint)
        canvas?.restore()

        canvas?.save()
        matrix.reset()
        matrix.postTranslate(200f, 0f)
        canvas?.concat(matrix)
        canvas?.drawBitmap(bitmap, point2.x.toFloat(), point2.y.toFloat(), paint)
        canvas?.restore()


        val bitmapWidth = bitmap.width
        val bitmapHeight = bitmap.height

        canvas?.save()
        matrix.reset()
        matrix.postScale(1.3f, 1.3f, (point3.x + bitmapWidth / 2).toFloat(), (point3.y + bitmapHeight / 2).toFloat())
        canvas?.concat(matrix)
        canvas?.drawBitmap(bitmap, point3.x.toFloat(), point3.y.toFloat(), paint)
        canvas?.restore()

        canvas?.save()
        matrix.reset()
        matrix.postScale(0.6f, 1.6f, (point4.x + bitmapWidth / 2).toFloat(), (point4.y + bitmapHeight / 2).toFloat())
        canvas?.concat(matrix)
        canvas?.drawBitmap(bitmap, point4.x.toFloat(), point4.y.toFloat(), paint)
        canvas?.restore()


        canvas?.save()
        matrix.reset()
        matrix.postRotate(180f, (point5.x + bitmapWidth / 2).toFloat(), (point5.y + bitmapHeight / 2).toFloat())
        canvas?.concat(matrix)
        canvas?.drawBitmap(bitmap, point5.x.toFloat(), point5.y.toFloat(), paint)
        canvas?.restore()

        canvas?.save()
        matrix.reset()
        matrix.postRotate(45f, (point6.x + bitmapWidth / 2).toFloat(), (point6.y + bitmapHeight / 2).toFloat())
        canvas?.concat(matrix)
        canvas?.drawBitmap(bitmap, point6.x.toFloat(), point6.y.toFloat(), paint)
        canvas?.restore()

//        val bitmap6 = BitmapFactory.decodeResource(mContext.resources, R.mipmap.z4)
//        canvas?.save()
//        camera.save()
//        camera.rotateX(10f)
//        camera.applyToCanvas(canvas)
//        camera.restore()
//        canvas?.drawBitmap(bitmap6, point7.x.toFloat(), point7.y.toFloat(), paint)
//        canvas?.restore()

        val bitmap7 = BitmapFactory.decodeResource(mContext.resources, R.mipmap.z5)
        canvas?.save()
        camera.save()
        // 旋转 Camera 的三维空间
        // Camera.rotate*() 一共有四个方法： rotateX(deg) rotateY(deg) rotateZ(deg) rotate(x, y, z)
        camera.rotateY(5f)
        // 把旋转投影到 Canvas
        camera.applyToCanvas(canvas)
        camera.restore()
        canvas?.drawBitmap(bitmap7, point7.x.toFloat(), point7.y.toFloat(), paint)
        canvas?.restore()


        val bitmapWidth8 = bitmap.width
        val bitmapHeight8 = bitmap.height
        val center1X = point8.x + bitmapWidth8 / 2
        val center1Y = point8.y + bitmapHeight8 / 2
        val center2X = point9.x + bitmapWidth8 / 2
        val center2Y = point9.y + bitmapHeight8 / 2

        // 保存 Camera 的状态
        camera.save()
        matrix.reset()
        // 旋转 Camera 的三维空间
        camera.rotateX(30f)
        camera.getMatrix(matrix)
        // 恢复 Camera 的状态
        camera.restore()
        matrix.preTranslate((-center1X).toFloat(), (-center1Y).toFloat())
        matrix.postTranslate(center1X.toFloat(), center1Y.toFloat())
        canvas?.save()
        canvas?.concat(matrix)
        canvas?.drawBitmap(bitmap, point8.x.toFloat(), point8.y.toFloat(), paint)
        canvas?.restore()

        camera.save()
        matrix.reset()
        camera.rotateY(30f)
        camera.getMatrix(matrix)
        camera.restore()
        matrix.preTranslate((-center2X).toFloat(), (-center2Y).toFloat())
        matrix.postTranslate(center2X.toFloat(), center2Y.toFloat())
        canvas?.save()
        canvas?.concat(matrix)
        canvas?.drawBitmap(bitmap, point9.x.toFloat(), point9.y.toFloat(), paint)
        canvas?.restore()


        val bitmapWidth10 = bitmap.width
        val bitmapHeight10 = bitmap.height
        val centerX = point10.x + bitmapWidth / 2
        val centerY = point10.y + bitmapHeight / 2



        // 保存 Camera 的状态
        camera.save()
        matrix.reset()
        // 旋转 Camera 的三维空间
        camera.rotateX(degree.toFloat())
        camera.getMatrix(matrix)
        // 恢复 Camera 的状态
        camera.restore()
        //re/postTranslate/Rotate/Scale/Skew() 方法来设置几何变换
        matrix.preTranslate((-centerX).toFloat(), (-centerY).toFloat())
        matrix.postTranslate(centerX.toFloat(), centerY.toFloat())
        canvas?.save()
        //用 Canvas 当前的变换矩阵和 Matrix 相乘，即基于 Canvas 当前的变换，叠加上 Matrix 中的变换
        canvas?.concat(matrix)
        canvas?.drawBitmap(bitmap, point10.x.toFloat(), point10.y.toFloat(), paint)
        canvas?.restore()


        val bitmapWidth11 = bitmap.width
        val bitmapHeight11 = bitmap.height + point11.y
        val centerX11 = width / 2
        val centerY11 = height / 2
        val x = centerX11 - bitmapWidth11 / 2
        val y = centerY11 - bitmapHeight11 / 2

        // 第一遍绘制：上半部分
        canvas?.save()
        canvas?.clipRect(0, 0, width, centerY11)
        canvas?.drawBitmap(bitmap, x.toFloat(), y.toFloat(), paint)
        canvas?.restore()

        // 第二遍绘制：下半部分
        canvas?.save()

        if (degree < 90) {
            canvas?.clipRect(0, centerY11, width, height)
        } else {
            canvas?.clipRect(0, 0, width, centerY11)
        }
        camera.save()
        camera.rotateX(degree.toFloat())
        canvas?.translate(centerX11.toFloat(), centerY11.toFloat())
        camera.applyToCanvas(canvas)
        canvas?.translate((-centerX11).toFloat(), (-centerY11).toFloat())
        camera.restore()

        canvas?.drawBitmap(bitmap, x.toFloat(), y.toFloat(), paint)
        canvas?.restore()


    }
}