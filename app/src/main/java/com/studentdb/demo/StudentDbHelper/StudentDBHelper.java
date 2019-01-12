package com.studentdb.demo.StudentDbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class StudentDBHelper extends SQLiteOpenHelper {
    public StudentDBHelper(Context context) {
        super(context, "Student.db", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table student (id integer primary key autoincrement,name text,sex text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
