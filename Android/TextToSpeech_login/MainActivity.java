package com.aryaman.myfirtsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener{
    EditText e1,e2;
    String s1,s2;
    Button b1,b2;
    TextToSpeech ts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.edit1);
        e2=findViewById(R.id.edit2);
        b1=findViewById(R.id.login);
        b2=findViewById(R.id.register);
        ts= new TextToSpeech(MainActivity.this,this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=e1.getText().toString();
                s2=e2.getText().toString();
                if(s1.contentEquals("Aryaman") && s2.contentEquals("1234")){
                    ts.speak(s1 + "login successfully",TextToSpeech.QUEUE_ADD,null);
                    //Toast.makeText( MainActivity.this,"login successful",Toast.LENGTH_LONG).show();
            }
                else{
                    Toast.makeText( MainActivity.this,"not login",Toast.LENGTH_LONG).show();
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText( MainActivity.this,"new user registered",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onInit(int i) {
        ts.setLanguage(Locale.ENGLISH);
        ts.setSpeechRate(0.8f);
    }
}
