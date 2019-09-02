package ybq.android.myapplication.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ybq.android.myapplication.R
import ybq.android.myapplication.view.PaintView
import ybq.android.myapplication.view.PaintView2
import ybq.android.myapplication.view.PaintView3

class EightActivity : AppCompatActivity() {

    lateinit var paintView:PaintView
    lateinit var paintView2: PaintView2
    lateinit var paintView3:PaintView3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eight)
        initView()
    }

    private fun initView() {
        paintView = findViewById(R.id.paintView)
        paintView2 = findViewById(R.id.paintView2)
        paintView3 = findViewById(R.id.paintView3)
    }
}
