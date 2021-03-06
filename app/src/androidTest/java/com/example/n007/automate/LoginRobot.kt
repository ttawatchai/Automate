package com.example.n007.automate

import android.content.Context
import android.support.test.espresso.ViewInteraction

/**
 * Created by N007 on 24/4/2561.
 */
class LoginRobot(private val context: Context) : BaseTestRobot() {

    fun setEmail(email: String) = apply { fillEditText(R.id.tv_mail, email) }

    fun setPassword(pass: String) = apply { fillEditText(R.id.tv_pass, pass) }

    fun clickLogin() = apply {
        clickButton(R.id.bt_login)
    }

    fun matchErrorText(err: Int): ViewInteraction {
        return matchText(textView(android.R.id.message), context.getString(err))
    }

    fun sleep(time : Long) = apply {
        Thread.sleep(time)
    }

    fun screenShot(tag: String) = apply {
        sleep(500)
        TestUtilsJava.screenShot(tag)
    }


}