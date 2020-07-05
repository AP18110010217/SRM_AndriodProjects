package com.example.registrationtask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.registrationtask.R;

public class MainActivity extends AppCompatActivity {
    EditText et_name,et_rollno,et_phone,et_emailid,et_password;
    RadioButton rd_male,rd_female;
    Spinner sp_branch;
    String gender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_name=findViewById(R.id.Name);
        et_rollno=findViewById(R.id.rollno);
        et_phone=findViewById(R.id.phone);
        et_emailid=findViewById(R.id.emailid);
        et_password=findViewById(R.id.password);
        rd_male=findViewById(R.id.male);
        rd_female=findViewById(R.id.female);
        sp_branch=findViewById(R.id.Branch);
        ArrayAdapter<CharSequence> branch = ArrayAdapter.createFromResource(MainActivity.this, R.array.Branch, android.R.layout.simple_spinner_item);
        sp_branch.setAdapter(branch);
    }



    public void submit(View view){
        String name = et_name.getText().toString();
        String  rollno= et_rollno.getText().toString();
        String phone= et_phone.getText().toString();
        String email = et_emailid.getText().toString();
        String pass = et_password.getText().toString();
        String branch= sp_branch.getSelectedItem().toString();


        if (rd_male.isChecked()) {
            gender = rd_male.getText().toString();
        }
        if (rd_female.isChecked()) {
            gender = rd_female.getText().toString();
        }


        Intent i =new Intent(MainActivity.this,MainActivity2.class);

        i.putExtra("name",name);
        i.putExtra("rollno",rollno);
        i.putExtra("phone",phone);
        i.putExtra("email",email);
        i.putExtra("pass",pass);
        i.putExtra("gender",gender);
        i.putExtra("branch",branch);


        startActivity(i);

    }
}