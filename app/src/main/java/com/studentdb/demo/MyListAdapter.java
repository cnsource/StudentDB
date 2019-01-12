package com.studentdb.demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MyListAdapter extends BaseAdapter {
    private List<Student> students=null;
    private Context context;
    public MyListAdapter(Context context,List<Student> students){
        this.students=students;
        this.context=context;
    }
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
    public View getView(int position, View convertView, ViewGroup parent) {
        Student student=getItem(position);
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        LinearLayout layout = (LinearLayout) layoutInflater.inflate(R.layout.info_item,null);
        if (convertView!=null){
            layout= (LinearLayout) convertView;
        }  else {
            layout = (LinearLayout) layoutInflater.inflate(R.layout.info_item,null);
        }
        TextView name=layout.findViewById(R.id.name);
        TextView sex =layout.findViewById(R.id.sex);
        name.setText(student.getName());
        sex.setText(student.getSex());
        return layout;
    }
}
