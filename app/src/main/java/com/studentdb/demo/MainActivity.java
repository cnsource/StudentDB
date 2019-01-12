package com.studentdb.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.studentdb.demo.Dao.Dao;
import com.studentdb.demo.StudentDbHelper.StudentDBHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private EditText name ;
private RadioGroup eg_sex;
private Dao dao=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name);
        eg_sex=findViewById(R.id.sex);
        dao=new Dao(this);
    }
    public void saveinfo(View view){
        String name = this.name.getText().toString();
        if (TextUtils.isEmpty(name)){
            Toast.makeText(this, "请输入姓名", Toast.LENGTH_SHORT).show();
        }
        String sex="male";
        int id =eg_sex.getCheckedRadioButtonId();
        if (R.id.female==id){
            sex="female";
        }
        dao.add(name,sex);
        Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
    }
    public void deleteinfo(View view){
        String name = this.name.getText().toString();
        if (TextUtils.isEmpty(name)){
            Toast.makeText(this, "请输入姓名", Toast.LENGTH_SHORT).show();
        }
        String sex="male";
        int id =eg_sex.getCheckedRadioButtonId();
        if (R.id.female==id){
            sex="female";
        }
        dao.delete(name);
        Toast.makeText(this, "删除成功", Toast.LENGTH_SHORT).show();
    }
    public void updateinfo(View view){
        String name = this.name.getText().toString();
        if (TextUtils.isEmpty(name)){
            Toast.makeText(this, "请输入姓名", Toast.LENGTH_SHORT).show();
        }
        String sex="male";
        int id =eg_sex.getCheckedRadioButtonId();
        if (R.id.female==id){
            sex="female";
        }
        dao.update(name,sex);
        Toast.makeText(this, "更新成功", Toast.LENGTH_SHORT).show();
    }
    public void findinfo(View view){
        String name = this.name.getText().toString();
        if (TextUtils.isEmpty(name)){
            Toast.makeText(this, "请输入姓名", Toast.LENGTH_SHORT).show();
        }
        String info=dao.find(name);
        Toast.makeText(this,info, Toast.LENGTH_SHORT).show();
    }
    public void findAll(View view){
        List<Student> students=dao.findAll();
        for (Student student:students){
            Log.i("StuInfo:",student.toString());
        }
    }
}
