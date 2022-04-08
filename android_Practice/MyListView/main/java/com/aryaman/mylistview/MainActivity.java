package com.aryaman.mylistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView l1;
    String name[]={"John","Aryaman","Rahul","Kunal"};
    ArrayAdapter<String> adapter;  //holds data in class
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        l1=findViewById(R.id.list1);
        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,name);
        l1.setAdapter(adapter); //method to store adapter properties

        l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                switch (pos){
                    case 0:
                        Intent i = new Intent(MainActivity.this,Page2.class); // shift to new page
                        startActivity(i);
                        Toast.makeText(MainActivity.this,"click john" ,Toast.LENGTH_LONG).show();
                        break;
                    case 1:
                        Toast.makeText(MainActivity.this,"click Aryaman" ,Toast.LENGTH_LONG).show();
                        break;
                    case 2:
                        Toast.makeText(MainActivity.this,"click Rahul" ,Toast.LENGTH_LONG).show();
                        break;
                    case 3:
                        Toast.makeText(MainActivity.this,"click Kunal" ,Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });
    }
}