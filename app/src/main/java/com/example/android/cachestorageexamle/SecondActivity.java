package com.example.android.cachestorageexamle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SecondActivity extends Activity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        editText = (EditText) findViewById(R.id.userName2);
    }

    public void previousActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    public void loadInternalCache(View view) {
        File folder = getCacheDir();
        File myFile = new File(folder, "mydata1.txt");
        String data = readData(myFile);
        if (data != null) {
            editText.setText(data);
        } else {
            showMessage();
        }
    }

    public void loadExternalCache(View view) {
        File folder = getExternalCacheDir();
        File myFile = new File(folder, "mydata2.txt");
        String data = readData(myFile);
        if (data != null) {
            editText.setText(data);
        } else {
            showMessage();
        }
    }

    public void loadExternalPrivate(View view) {
        File folder = getExternalFilesDir("Milten");
        File myFile = new File(folder, "mydata3.txt");
        String data = readData(myFile);
        if (data != null) {
            editText.setText(data);
        } else {
            showMessage();
        }
    }

    public void loadExternalPublic(View view) {
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
        File myFile = new File(folder, "mydata4.txt");
        String data = readData(myFile);
        if (data != null) {
            editText.setText(data);
        } else {
            showMessage();
        }
    }

    private String readData(File myFile) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(myFile);
            int read = -1;
            StringBuffer buffer = new StringBuffer();
            while ((read = fileInputStream.read()) != -1) {
                buffer.append((char) read);
            }
            return buffer.toString();
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
        return  null;
    }

    private void showMessage() {
        Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show();
    }
}
