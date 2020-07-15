package com.example.explicitcodelabtask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    EditText et1;
    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        et1=findViewById(R.id.msg2);
        tv1=findViewById(R.id.tv1);

        String s= getIntent().getStringExtra("mydata");
        tv1.setText("Message:"+s);
    }

    public void reply(View view) {
        String data= et1.getText().toString();
        Intent i = new Intent(MainActivity2.this,MainActivity.class);
        i.putExtra( "data",data);
        startActivity(i);
    }
}