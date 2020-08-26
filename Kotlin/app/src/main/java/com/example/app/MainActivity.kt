package com.example.app

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.app.entity.User
import com.example.app.widget.CodeView
import com.example.core.utils.CacheUtils
import com.example.core.utils.Utils
import com.example.lesson.LessonActivity

/**
 * @author jty
 * @date 2020-08-25
 */
class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val usernameKey: String = "username"
    private val passwordKey: String = "password"

    private lateinit var mEtUsername: EditText
    private lateinit var mEtPassword: EditText
    private lateinit var mEtCode: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        mEtUsername = findViewById(R.id.et_username)
        mEtPassword = findViewById(R.id.et_password)
        mEtCode = findViewById(R.id.et_code)

        mEtUsername.setText(CacheUtils.get(usernameKey))
        mEtPassword.setText(CacheUtils.get(passwordKey))

        val btnLogin: Button = findViewById(R.id.btn_login)
        val imgCode: CodeView = findViewById(R.id.code_view)
        btnLogin.setOnClickListener(this)
        imgCode.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        if (v is CodeView) {
            v.updateCode()
        } else if (v is Button) {
            login()
        }
    }

    private fun login() {
        val username = mEtUsername.text.toString()
        val password = mEtPassword.text.toString()
        val code = mEtCode.text.toString()

        val user = User(username, password, code)

        if (verify(user)) {
            CacheUtils.save(usernameKey, username);
            CacheUtils.save(passwordKey, password);
            startActivity(Intent(this, LessonActivity::class.java))
        }
    }

    private fun verify(user: User): Boolean {
        if (user.username == null || user.username!!.length < 4) {
            Utils.toast("用户名不合法")
            return false
        }
        if (user.password == null || user.username!!.length < 4) {
            Utils.toast("密码不合法")
            return false
        }
        return true
    }
}