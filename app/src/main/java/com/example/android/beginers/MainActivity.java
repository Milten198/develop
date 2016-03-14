package com.example.android.beginers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {
        String priceMessage = "Free";
        displayMessage(priceMessage);
    }

    public void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.priceNumber);
        priceTextView.setText(message);
    }


    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantityNumber);
        quantityTextView.setText(String.valueOf(number));
    }

    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.priceNumber);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    public void decrement(View view) {
        quantity -= 1;
        displayQuantity(quantity);
    }

    public void increment(View view) {
        quantity += 1;
        displayQuantity(quantity);
    }
}
