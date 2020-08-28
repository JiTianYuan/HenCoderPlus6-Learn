package com.example.core.http

/**
 * @author jty
 * @date 2020-08-25
 */
interface EntityCallback<T> {
    fun onSuccess(entity: T)

    fun onFailure(message: String?)
}