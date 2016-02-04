package com.example.android.listviewcustomexample;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView myList;
    String[] titles;
    String[] descriptions;

    int[] images = {R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4, R.drawable.a5, R.drawable.a6,
            R.drawable.a7, R.drawable.a8, R.drawable.a9, R.drawable.a10, R.drawable.a11, R.drawable.a12,
            R.drawable.a13, R.drawable.a14, R.drawable.a15, R.drawable.a16, R.drawable.a17, R.drawable.a18,
            R.drawable.a19, R.drawable.a21, R.drawable.a22, R.drawable.a23};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources resources = getResources();
        titles = resources.getStringArray(R.array.social);
        descriptions = resources.getStringArray(R.array.description);


        myList = (ListView) findViewById(R.id.listView);
        MyCustomAdapter adapter = new MyCustomAdapter(this, titles, descriptions, images);
        myList.setAdapter(adapter);
    }
}

class MyCustomAdapter extends ArrayAdapter {

    Context context;
    String[] titles;
    String[] descriptions;
    int[] images;

    public MyCustomAdapter(Context context, String[] titles, String[] descriptions, int[] images) {
        super(context, R.layout.single_row, titles);
        this.context = context;
        this.titles = titles;
        this.descriptions = descriptions;
        this.images = images;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder holder;
        View row = convertView;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.single_row, parent, false);
            holder = new MyViewHolder(row);
            row.setTag(holder);
        } else {
            holder = (MyViewHolder) row.getTag();
        }
        holder.title.setText(titles[position]);
        holder.description.setText(descriptions[position]);
        holder.image.setImageResource(images[position]);
        return row;
    }
}

class MyViewHolder {
    TextView title;
    TextView description;
    ImageView image;

    public MyViewHolder(View view) {
        title = (TextView) view.findViewById(R.id.textView);
        description = (TextView) view.findViewById(R.id.textView2);
        image = (ImageView) view.findViewById(R.id.imageView);
    }
}





























