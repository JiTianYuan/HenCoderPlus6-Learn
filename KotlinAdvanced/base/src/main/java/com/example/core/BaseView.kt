package com.example.core

/**
 * @author jty
 * @date 2020-08-25
 */
interface BaseView<T> {
    //声明抽象属性
    val presenter: T
}