package com.example.android.intentsexample;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity_layout);

        Bundle firstActData = getIntent().getExtras();
        if (firstActData == null) {
            return;
        }
        String textToType = firstActData.getString("typedText");
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText(textToType);
    }
}
