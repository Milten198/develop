package com.example.android.intentsexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void nextButton(View view) {
        EditText editText = (EditText) findViewById(R.id.editText);
        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        String text = editText.getText().toString();
        intent.putExtra("typedText", text);
        startActivity(intent);
    }

}
