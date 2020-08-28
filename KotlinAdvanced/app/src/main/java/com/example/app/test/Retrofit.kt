package com.example.app.test

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET


/**
 * @author jty
 * @date 2020-08-28
 */
interface API {

    @GET("lessons")
    fun lessons(): Call<Any>

}

val RETROFIT = Retrofit.Builder()
        .baseUrl("https://api.hencoder.com/")
        .build()

inline fun <reified T> create(): T {
    return RETROFIT.create(T::class.java)
}

fun main() {
    println(create<API>())
}


/*
fun <T> create(clazz: Class<T>): T {
    return RETROFIT.create(clazz)
}

fun main() {
    println(create(API::class.java))
}
 */