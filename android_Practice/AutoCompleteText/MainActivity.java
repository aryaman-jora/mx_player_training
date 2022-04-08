package com.aryaman.autocompletetextview;

import
        androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView a1;
    String name[] = {"java","jumanji","mohan","manisha","vishal","vibhor"};
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a1= findViewById(R.id.auto);
        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,name);
        a1.setAdapter(adapter);
        a1.setThreshold(1); // only one character needed for autocomplete (default is 2)
    }
}