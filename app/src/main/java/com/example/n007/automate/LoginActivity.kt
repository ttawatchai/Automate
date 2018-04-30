package com.example.n007.automate

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private var email: String = ""
    private var pass: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        bt_login.setOnClickListener {
            email = tv_mail.text.toString()
            pass = tv_pass.text.toString()
            if (validate()) loginSuccess()
        }
    }

    private fun validate(): Boolean {

        if (email == "" && pass == "") return missingFields()

        if (email != "" && pass == "") return missingPass()

        if ((email != pass)) return loginFail()


        return true
    }

    fun showError(msg: Int) {
        val builder = AlertDialog.Builder(this)
        builder
                .setMessage(msg)
                .setPositiveButton(R.string.txt_ok, null)
                .show()
    }

    fun loginFail(): Boolean {
        showError(R.string.login_fail)
        return false

    }

    fun missingFields(): Boolean {
        showError(R.string.msg_fail)
        return false
    }

    fun missingPass(): Boolean {
        showError(R.string.missing_fields)
        return false
    }

    fun loginSuccess() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }


}
