package com.example.exampledatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    EditText et_name,et_phone,et_roll,et,et1;
    DatabaseReference dbreferance;
    RecyclerView rv;
    ArrayList<Pojo> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_name=findViewById(R.id.name);
        et_phone=findViewById(R.id.number);
        et=findViewById(R.id.sroll);
        et1=findViewById(R.id.snumber);
        et_roll=findViewById(R.id.roll);
        rv=findViewById(R.id.recyler);
        list =new ArrayList<>();
        dbreferance= FirebaseDatabase.getInstance().getReference("UserDetails");//sending all text from edittext
        //to fetch the db
        dbreferance.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    list.clear();
                    for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                        Pojo pojo=dataSnapshot.getValue(Pojo.class);
                        list.add(pojo);
                        MyAdapter adapter=new MyAdapter(MainActivity.this ,list);
                        rv.setAdapter(adapter);
                        rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));

                    }

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void submit(View view) {
        //to insert the data in firebase db
        String name =et_name.getText().toString();
        String roll=et_roll.getText().toString();
        String number=et_phone.getText().toString();
        if(name.isEmpty()|roll.isEmpty()|number.isEmpty()){
            Toast.makeText(this, "please fill the details", Toast.LENGTH_SHORT).show();
        }
        else{
            // String id =dbreferance.push().getKey();//unique key for each data
            Pojo pojo =new Pojo(name,roll,number);//gives quick reference of the data
            dbreferance.child(roll).setValue(pojo);//roll number is unique ,by using the roll number we can get the details of the user
            Toast.makeText(this, "submitted", Toast.LENGTH_SHORT).show();
        }
    }

    public void update(View view) {
        //to update db
        final String roll=et.getText().toString();
        final String num=et1.getText().toString();
        DatabaseReference reference=FirebaseDatabase.getInstance().getReference();
        Query query=reference.child("UserDetails").orderByChild("roll").equalTo(roll);
        final HashMap<String,Object> map=new HashMap<>();
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                    map.put("number",num);
                    dataSnapshot.getRef().updateChildren(map);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}