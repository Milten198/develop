package com.example.android.interprocesdataexchangeexampleapp2;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText messageFromApp1;
    TextView status;
    String packageName = "com.example.android.interprocesdataexchangeexampleapp1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messageFromApp1 = (EditText) findViewById(R.id.messageFromApp2);
        status = (TextView) findViewById(R.id.textView);
    }


    public void loadFile(View view) {
        PackageManager packageManager = getPackageManager();
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(packageName, PackageManager.GET_META_DATA);
            String fullPath = applicationInfo.dataDir + "/files/milten.txt";
            readFile(fullPath);
        } catch (PackageManager.NameNotFoundException e) {
            status.setTextColor(Color.RED);
            status.setText(e.toString());
        }
    }

    public void readFile(String fullPath) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(new File(fullPath));
            int read = -1;
            StringBuffer buffer = new StringBuffer();
            while ((read = fileInputStream.read()) != -1) {
                buffer.append((char)read);
            }
            messageFromApp1.setText(buffer);
            status.setTextColor(Color.GREEN);
            status.setText(buffer + " \n was read successfully from \n" + fullPath);
        } catch (IOException e) {
            status.setTextColor(Color.RED);
            status.setText(e + "");
        } finally {
            if (fileInputStream != null) {
              try {
                  fileInputStream.close();
              } catch (IOException e) {
                  status.setTextColor(Color.RED);
                  status.setText(e + "");
              }
            }
        }
    }
}
