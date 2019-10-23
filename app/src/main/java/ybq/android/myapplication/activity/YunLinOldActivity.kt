package ybq.android.myapplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.AlignItems
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import ybq.android.myapplication.R
import ybq.android.myapplication.adapter.FlexBoxAdapter
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class YunLinOldActivity : AppCompatActivity() {

    lateinit var recyclerview:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yun_lin_old)

        recyclerview = findViewById(R.id.recyclerview)

        val flexboxLayoutManager = FlexboxLayoutManager(this).apply {
            flexWrap = FlexWrap.WRAP
            flexDirection = FlexDirection.ROW
            alignItems = AlignItems.STRETCH
        }


        val recyclerView: RecyclerView = findViewById(R.id.recyclerview)
        val manager = StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.HORIZONTAL)

        recyclerView.apply {
            layoutManager = manager
            adapter = FlexBoxAdapter()
        }
    }
}
