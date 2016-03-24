package com.example.android.cachestorageexamle;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.userName);
    }

    public void nextActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        startActivity(intent);
    }

    public void internalCache(View view) {
        String userName = editText.getText().toString();
        File folder = getCacheDir();
        File myFile = new File(folder, "mydata1.txt");
        writeData(myFile, userName);
        showMessage(folder);
    }

    public void externaCache(View view) {
        String userName = editText.getText().toString();
        File folder = getExternalCacheDir();
        File myFile = new File(folder, "mydata2.txt");
        writeData(myFile, userName);
        showMessage(folder);
    }


    public void externalPrivate(View view) {
        String userName = editText.getText().toString();
        File folder = getExternalFilesDir("Milten");
        File myFile = new File(folder, "mydata3.txt");
        writeData(myFile, userName);
        showMessage(myFile);
    }

    public void externalPublic(View view) {
        String userName = editText.getText().toString();
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
        File myFile = new File(folder, "mydata4.txt");
        writeData(myFile, userName);
        showMessage(myFile);
    }

    private void writeData(File myFile, String userName) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(myFile);
            fileOutputStream.write(userName.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void showMessage(File file) {
        Toast.makeText(this, "Your data was successfully saved in " + file.getAbsolutePath(), Toast.LENGTH_LONG).show();
    }
}
