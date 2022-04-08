package com.aryaman.customegridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    GridView girdView;
    String name[]={"mohan","sohan","rohan"};
    Integer image[]={R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher};
    //Integer image[]={R.drawable.mario2,R.mipmap.ic_launcher,R.mipmap.ic_launcher}; //image should be equal to no of text
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        girdView = findViewById(R.id.grid1);
        Customgrid cs = new Customgrid(MainActivity.this, name, image);
        girdView.setAdapter(cs);
    }
}