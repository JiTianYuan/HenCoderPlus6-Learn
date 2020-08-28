package com.example.app.test

/**
 * @author jty
 * @date 2020-08-28
 */

fun main() {
    //循环
    //写法1
    repeat(100){
        println(it)
    }

    //写法2
    for (i in 0..99){
        println(i)
    }


    //遍历集合
    val array = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    //方式1：Int.until(to: Int) 返回一个区间
    for (i in 0 until array.size){
        println(i)
    }

    //方式2：array.indices方法直接返回遍历用的
    for (i in array.indices){
        println(i)
    }

}