package com.aryaman.customegridview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Customgrid extends ArrayAdapter {
    Activity c;
    String name1[];
    Integer image1[];

    public Customgrid(@NonNull Context context, String[] resource, Integer[] textViewResourceId) {
        super(context, R.layout.activity_main,resource);
        c = (Activity) context;
        name1 = resource;
        image1 = textViewResourceId;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater LF = c.getLayoutInflater();
        convertView = LF.inflate(R.layout.simple,null);
        TextView tv = convertView.findViewById(R.id.text1);
        ImageView im = convertView.findViewById(R.id.image1);
        tv.setText(name1[position]);
        im.setImageResource(image1[position]);
        return convertView;
    }
}

