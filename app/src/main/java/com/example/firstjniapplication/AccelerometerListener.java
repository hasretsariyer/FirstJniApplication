package com.example.firstjniapplication;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class AccelerometerListener implements SensorEventListener
{
    private Context context = null;

    private SensorManager sensorManager = null;
    public AccelerometerListener() {
        context = MainActivity.getInstance().getApplicationContext();
        sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
    }

    public void startListener() {
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);



    }
    public void stopListener() {
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) { }

    @Override
    public void onSensorChanged(SensorEvent event)
    {
        float[] values = event.values;
        float x = values[0];
        float y = values[1];
        float z = values[2];
    }
}
