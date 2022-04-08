package com.aryaman.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    Spinner spin;
    String name[] ={"jan", "feb" , "march"};
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spin = findViewById(R.id.spinner);
        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,name);
        spin.setAdapter(adapter);
    }
}