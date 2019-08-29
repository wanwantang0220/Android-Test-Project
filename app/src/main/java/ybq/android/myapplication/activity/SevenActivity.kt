package ybq.android.myapplication.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ybq.android.myapplication.R
import ybq.android.myapplication.adapter.SevenListAdapter
import ybq.android.myapplication.bean.Person
import ybq.android.myapplication.view.PathPaintView
import ybq.android.myapplication.view.ViewFirst
import ybq.android.myapplication.view.ViewPaintPath

class SevenActivity : AppCompatActivity() {

    lateinit var myViewFirst: ViewFirst
    lateinit var paintPath : PathPaintView
    lateinit var recyclerView: RecyclerView
    var infos: ArrayList<Person> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seven)

        initView()
        initData()
    }

    private fun initData() {
        infos = ArrayList()

        for (i in 0..10) {
            var sex = ""
            if (i % 2 == 0) sex = "男" else sex = "女"
            val person = Person("第 $i 个 学院", sex)
            infos.add(person)

        }
        val gridLayoutManager = GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false)
        val adapter = SevenListAdapter(this, infos)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = gridLayoutManager
    }

    private fun initView() {
        myViewFirst = findViewById(R.id.myViewFirst)
        paintPath = findViewById(R.id.paintPath)
        recyclerView = findViewById(R.id.recyclerView)
    }
}
