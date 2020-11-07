package com.maemresen.infsec.publisher;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor accelerometer;
    private Sensor gyroscope;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        gyroscope = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, gyroscope, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
//        sensorManager.unregisterListener(this);
    }

    //--- Handling Sensor Data ---//

    @Override
    public final void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Do something here if sensor accuracy changes.
    }

    @Override
    public final void onSensorChanged(SensorEvent sensorEvent) {
        switch (sensorEvent.sensor.getType()) {
            case Sensor.TYPE_ACCELEROMETER:
                handleAccelerometer(sensorEvent);
                break;
            case Sensor.TYPE_GYROSCOPE:
                handleGyroscope(sensorEvent);
                break;
        }
    }

    // Handle Accelerometer
    private float lastAccX, lastAccY, lastAccZ;
    private float deltaX = 0;
    private float deltaY = 0;
    private float deltaZ = 0;
    private float accDeltaThreshold = 1f;

    private void handleAccelerometer(SensorEvent sensorEvent) {
        // get the change of the x,y,z values of the accelerometer
        deltaX = Math.abs(lastAccX - sensorEvent.values[0]);
        deltaY = Math.abs(lastAccY - sensorEvent.values[1]);
        deltaZ = Math.abs(lastAccZ - sensorEvent.values[2]);
        if (deltaX > accDeltaThreshold && deltaY > accDeltaThreshold && deltaZ > accDeltaThreshold) {
            Log.i("Publisher", String.format("New Senor Values:" +
                            "\n\tDelta x %.4f" +
                            "\n\tDelta y %.4f" +
                            "\n\tDelta z %.4f",
                    deltaX, deltaY, deltaZ));
        }
    }

    // Handle Gyroscope
    private float lastGyrX, lastGyrY, lastGyrZ;
    private float rotateX = 0;
    private float rotateY = 0;
    private float rotateZ = 0;
    private float gyrRotateThreshold = 1f;

    private void handleGyroscope(SensorEvent sensorEvent) {
        // get the change of the x,y,z values of the accelerometer
        rotateX = Math.abs(lastGyrX - sensorEvent.values[0]);
        rotateY = Math.abs(lastGyrY - sensorEvent.values[1]);
        rotateZ = Math.abs(lastGyrZ - sensorEvent.values[2]);
        if (rotateX > gyrRotateThreshold && rotateY > gyrRotateThreshold && rotateZ > gyrRotateThreshold) {
            Log.i("Publisher", String.format("New Senor Values:" +
                            "\n\tRotate x %.4f" +
                            "\n\tRotate y %.4f" +
                            "\n\tRotate z %.4f",
                    rotateX, rotateY, rotateZ));
        }
    }


}
