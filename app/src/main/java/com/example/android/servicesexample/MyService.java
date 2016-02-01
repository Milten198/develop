package com.example.android.servicesexample;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    private static final String TAG = "android.servicesexample";
    public MyService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand was called");

        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 0 ; i < 5; i++){
                long futureTime = System.currentTimeMillis() + 5000;
                while (System.currentTimeMillis() < futureTime) {
                    synchronized (this) {
                        try {
                            wait(futureTime - System.currentTimeMillis());
                            Log.i(TAG, "Service waited 5 second");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                }
            }
        };
        Thread myThread = new Thread(r);
        myThread.start();
        return Service.START_STICKY;  //If your service will destroyed your Service will be restarted
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroyed was called");
    }

    @Override
    public IBinder onBind(Intent intent) {
        //Not important in this example
        return null;
    }
}
