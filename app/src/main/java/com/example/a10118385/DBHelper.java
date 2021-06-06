package com.example.a10118385;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class DBHelper extends SQLiteOpenHelper{

    //Tanggal   :04 Juni 2021
    //NIM       :10118385
    //Nama      :Julian Arisky Lase
    //Kelas     :IF9

    public DBHelper(@Nullable Context context) {
        super(context, "db_note", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE tbl_note (id TEXT,title TEXT,category TEXT ,description TEXT,date TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE tbl_note");
    }

    public Cursor read() {
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery("SELECT * FROM tbl_note ",null);
    }


    public boolean create(Diary note) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO tbl_note VALUES ('"+note.getId()+"','"+note.getTitle()+"','"+note.getCategory()+"','"+note.getDesc()+"','"+note.getDate()+"')");
        return true;
    }

    public boolean update(Diary note) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE tbl_note SET title ='"+note.getTitle()+"' , category = '"+note.getCategory()+"' , description = '"+note.getDesc()+"' , date = '"+note.getDate()+"' WHERE id='"+note.getId()+"'");
        return true;
    }

    public boolean delete(String id) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM tbl_note WHERE id='"+id+"'");
        return true;
    }
}
