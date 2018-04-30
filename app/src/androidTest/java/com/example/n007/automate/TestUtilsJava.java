package com.example.n007.automate;

import android.app.Activity;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import android.support.test.runner.lifecycle.Stage;
import android.util.Log;

import com.jraska.falcon.FalconSpoon;
import com.squareup.spoon.Spoon;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by N007 on 24/4/2561.
 */

public class TestUtilsJava {

    public static void screenShot(String tag) {
//        Spoon.screenshot(getCurrentActivity(), tag);
        Log.i("asd", "Screenshot taken: " + tag);
    }
}
