package com.studentdb.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.studentdb.demo.Dao.Dao;

public class ListActivuty extends AppCompatActivity {
private ListView ls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ls=findViewById(R.id.ls);
        Dao dao=new Dao(this);
        ls.setAdapter(new MyListAdapter(this,dao.findAll()));
    }

}
