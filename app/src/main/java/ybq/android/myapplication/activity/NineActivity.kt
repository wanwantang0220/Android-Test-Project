package ybq.android.myapplication.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ybq.android.myapplication.R
import ybq.android.myapplication.view.PaintCanvasView
import ybq.android.myapplication.view.PaintMatrixView

class NineActivity : AppCompatActivity() {

    lateinit var paintCanvasView:PaintCanvasView
    lateinit var paintMatrixView:PaintMatrixView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nine)

        initView()

        paintMatrixView.setDegree(50)
    }

    private fun initView() {
        paintCanvasView = findViewById(R.id.paintCanvasView)
        paintMatrixView = findViewById(R.id.paintMatrixView)
    }
}
