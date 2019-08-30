package ybq.android.myapplication.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import ybq.android.myapplication.R


class PaintView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : View(context, attrs, defStyleAttr) {

    var paint: Paint = Paint()
    var path: Path = Path()
    private val mContext: Context = context
    private var bitmap: Bitmap? = null
    private lateinit var bitmap01: Bitmap
    private lateinit var bitmap02: Bitmap
    private val xfermode1:Xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC)
    private val xfermode2:Xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_IN)
    private val xfermode3:Xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_OUT)

    init {
        paint = Paint()
        path = Path()
         bitmap01 = BitmapFactory.decodeResource(resources, R.mipmap.batman)
         bitmap02 = BitmapFactory.decodeResource(resources, R.mipmap.batman_logo)
    }


    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)


        //TileMode  CLAMP  MIRROR   REPEAT
        val shader: Shader = LinearGradient(100F, 100F, 500F, 500F,
                Color.parseColor("#E91E63"), Color.parseColor("#2196F3"),
                Shader.TileMode.CLAMP)
        paint.shader = shader
        canvas?.drawCircle(200F, 3200F, 200F, paint)


        val shader2: Shader = LinearGradient(100F, 100F, 500F, 500F,
                Color.parseColor("#E91E63"), Color.parseColor("#2196F3"),
                Shader.TileMode.MIRROR)
        paint.shader = shader2
        canvas?.drawCircle(600F, 3200F, 200F, paint)

        val shader3: Shader = LinearGradient(100F, 100F, 500F, 500F,
                Color.parseColor("#E91E63"), Color.parseColor("#2196F3"),
                Shader.TileMode.REPEAT)
        paint.shader = shader3
        canvas?.drawCircle(1000F, 3200F, 200F, paint)

        //辐射渐变
        val shader4: Shader = RadialGradient(200F, 600F, 200F,
                Color.parseColor("#E91E63"), Color.parseColor("#2196F3"),
                Shader.TileMode.REPEAT)
        paint.shader = shader4
        canvas?.drawCircle(200F, 3600F, 200F, paint)

        //扫描渐变
        val shader5: Shader = SweepGradient(200F, 1000F,
                Color.parseColor("#E91E63"), Color.parseColor("#2196F3"))
        paint.shader = shader5
        canvas?.drawCircle(200F, 1000F, 200F, paint)

        var bitmap2 = BitmapFactory.decodeResource(mContext.resources, R.mipmap.z3)
        //TileMode.REPEAT模式：重复原图像来填充多余空间
        val shader6: Shader = BitmapShader(bitmap2, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT)
        paint.shader = shader6
        canvas?.drawCircle(600F, 1000F, 200F, paint)


        //TileMode.MIRROR模式：重复使用镜像模式的图像来填充多余空间
        val shader7: Shader = BitmapShader(bitmap2, Shader.TileMode.MIRROR, Shader.TileMode.MIRROR)
        paint.shader = shader7
        canvas?.drawCircle(1000F, 1000F, 200F, paint)

        //TileMode.CLAMP:用边缘色彩填充多余空间
        val shader8: Shader = BitmapShader(bitmap2, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        paint.shader = shader8
        canvas?.drawCircle(200F, 1400F, 200F, paint)

        //ComposeShader 混合着色器
        val bitmap4 :Bitmap = BitmapFactory.decodeResource(mContext.resources,R.mipmap.icon_service)
        val shader10 :Shader = BitmapShader(bitmap4,Shader.TileMode.CLAMP,Shader.TileMode.MIRROR)

        val bitmap3 :Bitmap = BitmapFactory.decodeResource(mContext.resources,R.mipmap.z1)
        val shader9 :Shader = BitmapShader(bitmap3,Shader.TileMode.MIRROR,Shader.TileMode.MIRROR)

        //两个图像共同绘制时的颜色策略
        val shaderTest : Shader = ComposeShader(shader10,shader9,PorterDuff.Mode.SRC_OVER)
        paint.shader = shaderTest
        canvas?.drawCircle(400F,1800F,300F,paint)


        //LightingColorFilter
        val bitmap5 = BitmapFactory.decodeResource(mContext.resources, R.mipmap.a1)
        val shader11: Shader = BitmapShader(bitmap5, Shader.TileMode.CLAMP, Shader.TileMode.MIRROR)
        val lightingColorFilter:ColorFilter = LightingColorFilter(0xffffff, 0x003000)
        paint.colorFilter = lightingColorFilter
        paint.shader = shader11
        canvas?.drawCircle(400F,2500F,200F,paint)


        val bitmap6 = BitmapFactory.decodeResource(mContext.resources,R.mipmap.f3)
        val colorMatrix : ColorMatrix = ColorMatrix()
        colorMatrix.setSaturation(10F)
        val  colorFilter : ColorFilter = ColorMatrixColorFilter(colorMatrix)
        paint.colorFilter = colorFilter
        canvas?.drawBitmap(bitmap6, 100F, 3000F, paint)

        var saved = canvas?.saveLayer(null, null, Canvas.ALL_SAVE_FLAG)

        //setXfermode
        paint = Paint(Paint.ANTI_ALIAS_FLAG)
        canvas?.drawBitmap(bitmap01,0F,0F,paint)
        paint.xfermode = xfermode1
        canvas?.drawBitmap(bitmap02,0F,0F,paint)
        paint.xfermode = null

        canvas?.drawBitmap(bitmap01, (bitmap01.getWidth() + 100).toFloat(), 0f, paint)
        paint.xfermode = xfermode2
        canvas?.drawBitmap(bitmap02, (bitmap01.getWidth() + 100).toFloat(), 0f, paint)
        paint.xfermode = null


        // 画方
        canvas?.drawBitmap(bitmap01, 0f, (bitmap01.getHeight() + 20).toFloat(), paint)
        // 设置 Xfermode
        paint.xfermode = xfermode3
        // 画圆
        canvas?.drawBitmap(bitmap02, 0f, (bitmap01.getHeight() + 20).toFloat(), paint)
        // 用完及时清除 Xfermode
        paint.xfermode = null


        if (saved != null) {
            //在绘制之前保存，绘制之后恢复
            canvas?.restoreToCount(saved)
        }



        //setStrokeJoin(Paint.Join join)
        paint.strokeWidth = 40f
        paint.style = Paint.Style.STROKE

        path.rLineTo(200f, 0f)
        path.rLineTo(-160f, 120f)

        canvas?.save()
       // MITER 尖角
        canvas?.translate(100f, 100f)
        paint.strokeJoin = Paint.Join.MITER
        canvas?.drawPath(path, paint)

        //BEVEL 平角
        canvas?.translate(300f, 0f)
        paint.strokeJoin = Paint.Join.BEVEL
        canvas?.drawPath(path, paint)

        //ROUND 圆角
        canvas?.translate(300f, 0f)
        paint.strokeJoin = Paint.Join.ROUND
        canvas?.drawPath(path, paint)

        canvas?.restore()


    }
}