package com.example.explicitcodelabtask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.tv);
        et=findViewById(R.id.msg);
        String s=getIntent().getStringExtra("data received");
        tv.setText("Msgreply:"+s);
    }
    public void sendmessage(View view) {
        String data=et.getText().toString();
        Intent i=new Intent(MainActivity.this,MainActivity2.class);
        i.putExtra("data",data);
        startActivity(i);
    }
}