package com.example.asynctask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.asynctask.R;

public class MainActivity extends AppCompatActivity {


    EditText et;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.userinput);
        recyclerView = findViewById(R.id.recycler);
    }

    public void search(View view) {
        String bookname = et.getText().toString();
        mytask task = new mytask(this,bookname,recyclerView);
        task.execute();

    }
}