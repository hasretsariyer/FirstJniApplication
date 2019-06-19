package com.example.firstjniapplication;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.yoga.android.YogaLayout;
import com.squareup.leakcanary.LeakCanary;

import java.util.ArrayDeque;
import java.util.Date;
import java.util.Queue;

public class MainActivity extends AppCompatActivity {
    Handler handler;
    int count = 0;
    public static int REQUEST_CHECK_SETTINGS = 204;
    LocationListener locationListener;
    private static Queue<Integer> removedIndexes = new ArrayDeque<>();
    private static MainActivity self;
    boolean isFinished = false;
    static {
        System.loadLibrary("jni-sample");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        self = this;
        final TextView textView = findViewById(R.id.textView);

        try {
            YogaLayout yogaLayout;
        } catch (Exception e) {

        }
        handler = new Handler();
        final Runnable r = new Runnable() {
            public void run() {
                if(isFinished) return;
                Log.i("@@log", " Runnable run");
                count++;
                textView.setText("count: " + count);
                locationListener = new LocationListener(self);
                locationListener._startLocationUpdates();
//                if(count <= 55)
//                    handler.postDelayed(this, 1000);
//                if(count % 5 == 0) {
//                    startActivity(new Intent(getApplicationContext(), DetailActivity.class));
//                }
            }
        };
        handler.postDelayed(r, 1000);
        Log.i("@@log", " " + stringFromJNI());
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            // Check for the integer request code originally supplied to startResolutionForResult().
            case LocationListener.REQUEST_CHECK_SETTINGS:
                switch (resultCode) {
                    case Activity.RESULT_OK:
                        Log.i("@@Log", "User agreed to make required location settings changes.");
                        // Nothing to do. startLocationupdates() gets called in onResume again.
                        locationListener.startLocationUpdates();
                        break;
                    case Activity.RESULT_CANCELED:
                        Log.i("@@Log", "User chose not to make required location settings changes.");
//                        mRequestingLocationUpdates = false;
//                        updateUI();
                        locationListener.startLocationUpdates();
                        break;
                }
                break;
        }
    }
    public static MainActivity getInstance() {
        return self;
    }

    @Override
    protected void onDestroy() {
        Log.i("@@log", " onDestroy callback");
//        isFinished = true;
        super.onDestroy();
    }
    public native String stringFromJNI();
}
