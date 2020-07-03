package com.example.loginpages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.email);
    }
    public void submit(View view){
        String data = et.getText().toString();
        if(data.isEmpty()){
            Toast.makeText(this,"Please Enter Email ID",Toast.LENGTH_SHORT).show();
        }
        else{
            Intent i=new Intent(MainActivity.this,MainActivity.class);
            startActivity(i);
        }
    }
    public void register(View view){
        Intent i=new Intent(MainActivity.this,MainActivity2.class);
        startActivity(i);
    }
}