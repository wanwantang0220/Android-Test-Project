package ybq.android.myapplication.bean


class Student constructor(var name:String , var sex:String){

    init {
    }

    constructor(name: String,age:Int):this(name,sex = "女")

    constructor(name: String,age: Int,score:Int):this(name,sex = "女")

    constructor(person: Person):this(person.name, person.sex)



}