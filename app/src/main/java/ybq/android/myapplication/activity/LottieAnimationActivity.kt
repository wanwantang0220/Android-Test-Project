package ybq.android.myapplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import butterknife.BindView
import com.airbnb.lottie.LottieAnimationView
import ybq.android.myapplication.R

class LottieAnimationActivity : AppCompatActivity() {


    lateinit var animationView:LottieAnimationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lottie_animation)


        animationView = findViewById(R.id.animation_view)
        animationView.setAnimation(R.raw.data)
        animationView.loop(false)
        animationView.playAnimation()

    }
}
