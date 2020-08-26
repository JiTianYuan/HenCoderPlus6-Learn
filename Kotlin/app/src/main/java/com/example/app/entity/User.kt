package com.example.app.entity


/**
 * @author jty
 * @date 2020-08-25
 */
class User {
    var username: String? = null
    var password: String? = null
    var code: String? = null

    constructor()

    constructor(username: String, password: String, code: String) {
        this.username = username
        this.password = password
        this.code = code
    }


}