package ybq .android.myapplication.activity

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ybq.android.myapplication.R
import ybq.android.myapplication.bean.User

class KotlinBasic2Activity : AppCompatActivity() {

    //val 不可变   var 可变
    private lateinit var tvBasic2: TextView
    private lateinit var  tvBasic2Time:TextView

    var showArray :String = ""
    var showTime :String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_basic2)

        User.childid = 0
        User.childname = "你好"
        showArray += User.childname

        tvBasic2 = findViewById(R.id.tvBasic2)
        tvBasic2Time = findViewById(R.id.tvBasic2Time)

        arrayAverage()
        arrayIntAverage()
        listAverage()

    }

    /**
     * list计算
     */
    private fun listAverage() {

        val startTime = System.currentTimeMillis()
        val list : List<Int> = List(100000 , init = {
            i -> i + 1
        })
        var listSum = 0L
        for(i in list){
            listSum += i
        }
        val listAvarge = listSum/list.size
        val time = System.currentTimeMillis() - startTime
        showArray += "List 方式计算 $listAvarge \n  $time \n"

        tvBasic2.text = showArray
    }

    /**
     * arrayInt计算
     */
    private fun arrayIntAverage() {

        val startTime = System.currentTimeMillis()
        val intarray : IntArray =  IntArray(100000 ,init = {
            i -> i + 1
        })
        var intArraySum = 0L
        for(i in intarray){
            intArraySum += i
        }
        val averageIntArray = intArraySum/intarray.size

        val time = System.currentTimeMillis() - startTime
        showArray += "IntArray 方式计算 $averageIntArray \n  $time \n"

        tvBasic2.text = showArray
    }

    /**
     * array方式计算
     */
    private fun arrayAverage() {

        val startTime = System.currentTimeMillis()
        val array1 : Array<Int> = Array(100000 , init = {
            i -> i + 1
        })
        var arraySun = 0L
        for(i in array1){
            arraySun += i
        }
        val averageArray = arraySun/array1.size
        val time = System.currentTimeMillis() - startTime
        showArray += "Array 方式计算 $averageArray \n  $time \n"

        tvBasic2.text = showArray
    }
}
