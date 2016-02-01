package com.example.android.intentservice;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    RelativeLayout myLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myLayout = (RelativeLayout) findViewById(R.id.myLayout);
    }

    public void red(View view) {
        myLayout.setBackgroundColor(Color.RED);
    }

    public void blue(View view) {
        myLayout.setBackgroundColor(Color.BLUE);
    }


    public void count(View view) {
        Intent intent = new Intent(this, MyServiceClass.class);
        startService(intent);
    }
}
