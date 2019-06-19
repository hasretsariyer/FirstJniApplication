package com.example.firstjniapplication.application;

import android.support.multidex.MultiDexApplication;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by nosaiba on 03/09/16.
 */
public class SampleApplication extends MultiDexApplication {
    @Override public void onCreate() {
        super.onCreate();

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }
}