package com.example.android.overflowmenu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        RelativeLayout myLeyout = (RelativeLayout) findViewById(R.id.myLayout);

        switch (item.getItemId()){
            case R.id.green:
                if (item.isChecked())
                    item.setChecked(false);
                else {
                    item.setChecked(true);
                    myLeyout.setBackgroundColor(Color.GREEN);
                }
            case R.id.blue:
                if (item.isChecked())
                    item.setChecked(false);
                else {
                    item.setChecked(true);
                    myLeyout.setBackgroundColor(Color.BLUE);
                }
            case R.id.red:
                if (item.isChecked())
                    item.setChecked(false);
                else {
                    item.setChecked(true);
                    myLeyout.setBackgroundColor(Color.RED);
                }
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
