package ybq.android.myapplication.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import ybq.android.myapplication.R
import ybq.android.myapplication.bean.Person
import ybq.android.myapplication.bean.Student

class KotlinBasic3Activity : AppCompatActivity() {


    lateinit var tvShow:TextView
    lateinit var tvShow2:TextView
    private var student1:Student? = null
    private var student2:Student? = null
    private var student3:Student? = null

    private var mInfo:String=""

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_basic3)

        tvShow = findViewById(R.id.tvShow)
        tvShow2 = findViewById(R.id.tvShow2)

        student1 = Student(name = "张三",age = 10 )
        student2 = Student(name = "李四",age = 11 , score = 60)
        student3 = Student(Person("王二" ,"男"))

        val minfo1 = student1?.name + student1?.sex +"\n"
        val minfo2 = student2?.name + student2?.sex +"\n"
        val minfo3 = student3?.name + student3?.sex +"\n"
        mInfo += mInfo + minfo1+ minfo2 + minfo3
        tvShow.text = mInfo +showInfo()

        initArray()
    }

    private fun initArray() {
        val sequence = sequenceOf(21, 40, 11, 33, 78)
        val result = sequence.filter { i ->
            println("Filter $i")
            i % 3 == 0
        }

        var showFilter : String = ""
        for(i in result){
            showFilter = "$showFilter $i  、"
        }

        tvShow2.text = showFilter
    }

    private fun showInfo() : String{
        val student  = Student("测试" , "hello")
        return student.name + student.sex
    }
}
