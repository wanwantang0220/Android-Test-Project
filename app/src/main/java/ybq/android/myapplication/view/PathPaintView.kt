package ybq.android.myapplication.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import ybq.android.myapplication.R

class PathPaintView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : View(context, attrs, defStyleAttr) {

    var paint:Paint = Paint()
    var path:Path = Path()
    private val mContext: Context = context
    private var bitmap : Bitmap? = null

    var pathLine:Path = Path()

    init {
        paint = Paint()
        path = Path()
        pathLine = Path()
        bitmap =  BitmapFactory.decodeResource(mContext.resources,R.mipmap.pic1)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.color = Color.WHITE
        paint.style = Paint.Style.FILL
        paint.strokeWidth = 10F
        path.moveTo(100F, 100F)
        path.lineTo(200F, 100F)
        path.lineTo(150F, 150F)
        path.close()

        path.moveTo(300F, 300F)
        path.arcTo(300F,100F,400F,400F,90F,-90F,false)
        path.close()

        canvas?.drawPath(path,paint)

        //全填充
        path.fillType = Path.FillType.WINDING
        path.addCircle(400F, 1000F, 200F,Path.Direction.CW)
        path.addCircle(600F, 1000F, 200F,Path.Direction.CW)
//        paint.color = Color.RED
        canvas?.drawPath(path,paint)


        //交叉填充
        path.fillType = Path.FillType.EVEN_ODD
        path.addCircle(400F, 600F, 200F,Path.Direction.CW)
        path.addCircle(600F, 600F, 200F,Path.Direction.CW)
//        paint.color = Color.YELLOW
        canvas?.drawPath(path,paint)



        //交叉填充
        path.fillType = Path.FillType.EVEN_ODD
        path.addCircle(400F, 1400F, 200F,Path.Direction.CW)
        path.addCircle(400F, 1400F, 100F,Path.Direction.CW)
        paint.color = Color.YELLOW
        canvas?.drawPath(path,paint)

        //画五角星
        path.fillType = Path.FillType.EVEN_ODD
        path.moveTo(100F,2000F)
        path.lineTo(400F, 2000F)
        path.lineTo(170F,2200F)
        path.lineTo(240F,1900F)
        path.lineTo(350F,2200F)
        path.close()
        canvas?.drawPath(path,paint)


        canvas?.drawBitmap(bitmap,100F,2100F,paint)

    }
}