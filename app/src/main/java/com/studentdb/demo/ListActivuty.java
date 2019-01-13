package com.studentdb.demo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.studentdb.demo.Dao.Dao;

import java.util.List;

public class ListActivuty extends AppCompatActivity {
private ListView ls;
private Dao dao;
private List<Student> students;
private MyListAdapter adapter=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        dao=new Dao(this);
        ls=findViewById(R.id.ls);
        refresh();
    }
public void refresh(){
        students=dao.findAll();
    if (adapter==null){
        adapter=new MyListAdapter();
    } else {
        adapter.notifyDataSetChanged();
    }
    ls.setAdapter(adapter);
}
private class MyListAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return students.size();
        }

        @Override
        public Student getItem(int position) {
            return students.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            final Student student=getItem(position);
            LayoutInflater layoutInflater=LayoutInflater.from(ListActivuty.this);
            LinearLayout layout = (LinearLayout) layoutInflater.inflate(R.layout.info_item,null);
            if (convertView!=null){
                layout= (LinearLayout) convertView;
            }  else {
                layout = (LinearLayout) layoutInflater.inflate(R.layout.info_item,null);
            }
            TextView name=layout.findViewById(R.id.name);
            TextView sex =layout.findViewById(R.id.sex);
            layout.findViewById(R.id.iv).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dao.delete(student.getName());
                    refresh();
                }
            });
            name.setText(student.getName());
            sex.setText(student.getSex());
            return layout;
        }
    }
}

