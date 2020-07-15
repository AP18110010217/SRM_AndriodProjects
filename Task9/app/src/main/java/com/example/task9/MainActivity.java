package com.example.task9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv=findViewById(R.id.recycler);

        int images[] = {R.drawable.alpha,R.drawable.beta,R.drawable.cupcake, R.drawable.donut,R.drawable.eclair,R.drawable.froyo, R.drawable.gingerbread,R.drawable.honeycomb,R.drawable.kitkat,R.drawable.icecreamsandwich, R.drawable.jellybean,  R.drawable.kitkat,  R.drawable.lollipop,  R.drawable.marshmallow,  R.drawable.nougat,  R.drawable.pie };
        String names[]={"Alpha","Beta","Cupcake","Donut","Eclair","Froyo","Gingerbead","Honeycomb","Icecreamsandwitch","Jellybean","Kitkat","Lollipop","Marshmallow","Nougat","Oreo","Pie "};
        String versions[] = {"1.0", "1.1", "1.5", "1.6", "2.0 - 2.1", "2.2", "2.3", "3.0", "4.0", "4.1", "4.4", "5.0", "6.0", "7.0", "8.0", "9.0", "10.0", "11.0"};
        String api[] = {"1", "2", "3", "4", "5-7", "8", "9-10", "11-13", "14-15", "16-18", "19-20", "21-22", "23", "24-25", "26-27", "28", "29", "30"};
        String release[]={"sep23,2008","feb9,2009","apr27,2009","sep15,2009","may20,2010","dec6,2010","feb22,2011","oct18,2011","july9,2012","nov12,2014","oct31,2013","nov12,2014","oct5,2015","aug22,2016","aug21,2017","dec5,2017"};

        rv.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter adapter=new MyAdapter(this,images,names,versions,api,release);
        rv.setAdapter(adapter);


    }
}