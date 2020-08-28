package com.example.app.test

import okhttp3.Request
import okhttp3.Response

/**
 * @author jty
 * @date 2020-08-28
 */
class View {
    interface OnClickListener {
        fun onClick(view: View)
    }

    //方法接收函数类型
    fun setOnClickListener(listener: (View) -> Unit) {
        listener(this)
    }
}
/*var listener: (View) -> Unit = {

}*/

//【作文题】 声明一个变量 call 写一个「传入参数类型」是 Request 类型，「返回值类型」是 Response 类型的「函数类型声明」
val call: ((Request) -> Response)? = null


fun main() {
    var view = View()
    //函数做参数
    view.setOnClickListener(::onClick)


    //匿名函数做参数
    view.setOnClickListener {
        println("onClick!")
    }
}

fun onClick(view: View) {
    println("onClick!")
}