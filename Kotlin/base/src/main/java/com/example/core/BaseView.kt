package com.example.core

/**
 * @author jty
 * @date 2020-08-25
 */
interface BaseView<T> {
    fun getPresenter(): T
}