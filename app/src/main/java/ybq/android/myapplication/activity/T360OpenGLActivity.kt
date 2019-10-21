package ybq.android.myapplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zph.glpanorama.GLPanorama
import ybq.android.myapplication.R

class T360OpenGLActivity : AppCompatActivity() {

    lateinit var mGLPanorama: GLPanorama

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t360_open_gl)

        mGLPanorama = findViewById(R.id.mGLPanorama)
        //传入全景图片
        mGLPanorama.setGLPanorama(R.drawable.pic1)

    }
}
