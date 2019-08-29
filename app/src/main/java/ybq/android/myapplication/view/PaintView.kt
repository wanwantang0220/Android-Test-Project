package ybq.android.myapplication.view

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class PaintView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : View(context, attrs, defStyleAttr) {

    var paint: Paint = Paint()
    var path: Path = Path()
    private val mContext: Context = context
    private var bitmap : Bitmap? = null

    init {
        paint = Paint()
        path = Path()
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)


    }
}