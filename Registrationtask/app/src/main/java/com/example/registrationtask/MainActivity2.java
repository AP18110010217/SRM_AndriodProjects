package com.example.registrationtask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.registrationtask.R;

public class MainActivity2 extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv=findViewById(R.id.textview);
        String name= getIntent().getStringExtra("name");
        String rollno= getIntent().getStringExtra("rollno");
        String phone= getIntent().getStringExtra("phone");
        String email= getIntent().getStringExtra("email");
        String  password= getIntent().getStringExtra("pass");
        String gender= getIntent().getStringExtra("gender");
        String branch= getIntent().getStringExtra("branch");
        tv.setText(name+"\n"+rollno+"\n"+phone+"\n"+email+"\n"+password+"\n"+branch);




    }
}