package com.studentdb.demo.Dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.studentdb.demo.Student;
import com.studentdb.demo.StudentDbHelper.StudentDBHelper;

import java.util.ArrayList;
import java.util.List;

public class Dao {
    private StudentDBHelper studentDBHelper;
    public Dao(Context context){
        studentDBHelper=new StudentDBHelper(context);
    }
    public void add(String name,String sex){
        SQLiteDatabase db=  studentDBHelper.getWritableDatabase();
        Log.i("DB:","1");
        db.execSQL("insert into student (name,sex)values (?,?)",new Object[]{name,sex});
        Log.i("DB:","2"+name+sex);
        db.close();
    }
    public void delete(String name){
        SQLiteDatabase db=  studentDBHelper.getWritableDatabase();
        Log.i("DB:","1");
        db.execSQL("delete from student where name=?",new Object[]{name});
        Log.i("DB:","2");
        db.close();
    }
    public void update(String name,String newsex){
        SQLiteDatabase db=  studentDBHelper.getWritableDatabase();
        Log.i("DB:","1");
        db.execSQL("update student set sex=? where name=?",new Object[]{newsex,name});
        Log.i("DB:","2");
        db.close();
    }
    public String find(String name){
        String sex=null;
        SQLiteDatabase db=  studentDBHelper.getReadableDatabase();
        Cursor cursor=db.rawQuery("select sex from student where name = ?",new String[]{name});
        boolean resoult =cursor.moveToNext();
        if (resoult){
            sex=cursor.getString(cursor.getPosition());
        }
        cursor.close();
        db.close();
        return sex;
    }
    public List<Student> findAll(){
        List<Student> students=new ArrayList<Student>();
        SQLiteDatabase db=studentDBHelper.getReadableDatabase();
        Cursor cursor=db.rawQuery("select name,sex from student",null);
        while (cursor.moveToNext()){
            String name=cursor.getString(0);
            String sex=cursor.getString(1);
            Student student=new Student();
            student.setName(name);
            student.setSex(sex);
            students.add(student);
        }
        cursor.close();
        db.close();
        return students;
    }
}
