package com.example.app.entity


/**
 * @author jty
 * @date 2020-08-25
 */
data class User constructor(var username: String?, var password: String?, var code: String?) {
    constructor() : this(null, null, null)
}