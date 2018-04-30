package com.example.n007.automate

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.test.suitebuilder.annotation.LargeTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by N007 on 24/4/2561.
 */
@RunWith(AndroidJUnit4::class)
class LoginTest {


    @get:Rule
    val mActivityTestRule: ActivityTestRule<LoginActivity> = ActivityTestRule(LoginActivity::class.java)

    private lateinit var robot: LoginRobot

    @Before
    fun setup() {
        robot = LoginRobot(mActivityTestRule.activity)
    }

    @Test
    fun loginMissingEmailPassword() {
        robot
                .clickLogin()
                .screenShot("loginMissingEmailPassword")
                .matchErrorText(R.string.msg_fail)
    }

    @Test
    fun loginMissingPassword() {
        robot
                .setEmail("mail@example.com")
                .clickLogin()
                .screenShot("loginMissingPassword")
                .matchErrorText(R.string.missing_fields)
    }

    @Test
    fun loginWrongPassword() {
        robot
                .setEmail("mail@example.com")
                .setPassword("wrong")
                .clickLogin()
                .screenShot("loginWrongPassword")
                .matchErrorText(R.string.login_fail)
    }

    @Test
    fun loginSuccess() {
        robot
                .setEmail("mail@example.com")
                .setPassword("mail@example.com")
                .clickLogin()
                .screenShot("loginSuccess")
                .wait()
                .matchText(R.id.tv_name, mActivityTestRule.activity.getString(R.string.success))

    }


}