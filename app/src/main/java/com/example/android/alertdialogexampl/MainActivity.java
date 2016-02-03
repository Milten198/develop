package com.example.android.alertdialogexampl;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alertDialog = new AlertDialog.Builder(
                MainActivity.this).create();
    }

    public void alertButton(View view) {
        alertDialog.setTitle("Alert Dialog");
        alertDialog.setMessage("Welcome to AlertDialog example program");
        alertDialog.setIcon(R.drawable.mask_black);

        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "You clicked OK", Toast.LENGTH_SHORT).show();
            }
        });
        alertDialog.show();
    }
}
