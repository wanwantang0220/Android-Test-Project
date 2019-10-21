package ybq.android.myapplication.activity

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.vr.sdk.widgets.pano.VrPanoramaEventListener
import com.google.vr.sdk.widgets.pano.VrPanoramaView
import ybq.android.myapplication.R

class T36PanoramaActivity : AppCompatActivity() {

    lateinit var mVrPanoramaView: VrPanoramaView
    private var paNormalOptions: VrPanoramaView.Options? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t36_panorama)
        initVrPaNormalView()
    }

    override fun onPause() {
        super.onPause()
        mVrPanoramaView.pauseRendering()
    }

    override fun onResume() {
        super.onResume()
        mVrPanoramaView.resumeRendering()
    }

    override fun onDestroy() {
        // Destroy the widget and free memory.
        super.onDestroy()
        mVrPanoramaView.shutdown()
    }


    //初始化VR图片
    private fun initVrPaNormalView() {
        mVrPanoramaView = findViewById(R.id.mVrPanoramaView)
        paNormalOptions = VrPanoramaView.Options()
        paNormalOptions?.inputType = VrPanoramaView.Options.TYPE_STEREO_OVER_UNDER
        //        mVrPanoramaView.setFullscreenButtonEnabled (false); //隐藏全屏模式按钮
        mVrPanoramaView.setInfoButtonEnabled(false) //设置隐藏最左边信息的按钮
        mVrPanoramaView.setStereoModeButtonEnabled(false) //设置隐藏立体模型的按钮
        mVrPanoramaView.setEventListener(ActivityEventListener()) //设置监听
        //加载本地的图片源
        mVrPanoramaView.loadImageFromBitmap(BitmapFactory.decodeResource(resources, R.drawable.andes), paNormalOptions)
        //设置网络图片源
        //        panoWidgetView.loadImageFromByteArray();
    }

    private inner class ActivityEventListener : VrPanoramaEventListener() {
        override fun onLoadSuccess() {//图片加载成功
        }


        override fun onLoadError(errorMessage: String?) {//图片加载失败
        }

        override fun onClick() {//当我们点击了VrPanoramaView 时候触发            super.onClick();
        }

        override fun onDisplayModeChanged(newDisplayMode: Int) {
            //改变显示模式时候出发（全屏模式和纸板模式）
            super.onDisplayModeChanged(newDisplayMode)
        }
    }
}