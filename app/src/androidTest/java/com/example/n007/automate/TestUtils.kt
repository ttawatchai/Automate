package com.example.n007.automate

import android.app.Activity
import android.support.test.runner.lifecycle.ActivityLifecycleMonitorRegistry
import android.support.test.InstrumentationRegistry
import android.util.Log

import android.support.test.runner.lifecycle.Stage
import com.jraska.falcon.FalconSpoon


/**
 * Created by N007 on 24/4/2561.
 */
object TestUtils {

    val currentActivity: Activity
        get() {
            val currentActivity = arrayOf<Activity>()
            InstrumentationRegistry.getInstrumentation().runOnMainSync {
                val resumedActivity = ActivityLifecycleMonitorRegistry.getInstance().getActivitiesInStage(Stage.RESUMED)
                val it = resumedActivity.iterator()
                currentActivity[0] = it.next()
            }

            return currentActivity[0]
        }
    fun screenShot(tag: String) {
        FalconSpoon.screenshot(currentActivity, tag)
        Log.i("asd", "Screenshot taken: $tag")
    }
}