package com.example.explicitcodelabtask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText et;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=findViewById(R.id.msg);
        tv=findViewById(R.id.tv);
        String s1= getIntent().getStringExtra("data");
        tv.setText("Reply:"+s1);

    }

    public void send(View view) {
        String data= et.getText().toString();
        Intent i = new Intent(MainActivity.this,MainActivity2.class);
        i.putExtra( "mydata",data);
        startActivity(i);
    }
}