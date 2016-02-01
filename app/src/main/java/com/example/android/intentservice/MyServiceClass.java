package com.example.android.intentservice;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class MyServiceClass extends IntentService{

    public MyServiceClass(){
        super("Funny");
    }
    @Override
    protected void onHandleIntent(Intent intent) {
        long futureTime = System.currentTimeMillis() + 10000;
        while (System.currentTimeMillis() < futureTime) {
            synchronized (this) {
                try {
                    wait(futureTime - System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        Log.v("Sprawdzam", "I have finished calculating");
    }
}
