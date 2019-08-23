package ybq.android.myapplication.bean


class User(var id: Int, var name: String) {

    init {
        //初始化代码块，先于构造函数
    }


    /**
     * 伴生函数
     */
    companion object {
        var childid:Int = 0
        var childname:String = ""
    }


}