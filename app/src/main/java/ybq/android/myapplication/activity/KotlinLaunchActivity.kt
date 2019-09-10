package ybq.android.myapplication.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*
import ybq.android.myapplication.R

class KotlinLaunchActivity : AppCompatActivity() {

    lateinit var tvShow: TextView
    var show: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_launch)

        tvShow = findViewById(R.id.tvShow)

        init()

    }


    @SuppressLint("SetTextI18n")
    private fun init() {

        GlobalScope.launch(Dispatchers.IO) {
            delay(5000)
            println("World!!")
            show = "$show Hello world ！！"
            getText()
            tvShow.text = show
        }

    }


    /**
     * suspend  非阻塞式挂起
     */
    private suspend fun getText() {

        withContext(Dispatchers.IO) {
            show = "$show 你好 "
        }


        withContext(Dispatchers.IO){
            show = "$show 2019/9/10"
        }

    }
}
