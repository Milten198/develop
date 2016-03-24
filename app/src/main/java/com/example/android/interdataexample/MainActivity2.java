package com.example.android.interdataexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity2 extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    }

    public void backActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    public void loadContent(View view) {
        FileInputStream fileInputStream = null;
        StringBuffer buffer = new StringBuffer();
        textView = (TextView) findViewById(R.id.textView2);
        try {
            fileInputStream = openFileInput("milten.txt");
            fileInputStream.read();
            int read =-1;
            while ((read = fileInputStream.read()) != -1) {
                buffer.append((char) read);
                Log.v("LOGUS", buffer.toString());
            }
            textView.setText(buffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
