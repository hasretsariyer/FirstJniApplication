package com.example.firstjniapplication;

import android.os.Handler;

public class SFHandler {
    public static Handler nativeObject = null;

    public SFHandler() {
        nativeObject = new Handler();
    }
}
