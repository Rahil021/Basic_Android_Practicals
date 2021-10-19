package com.example.madpracticals.Practical10;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class helper extends SQLiteOpenHelper {
    //DB info
//create ur database and table here...
    public static String dbname = "data";
    //public static String dbname2 = "book_data";
    public static String tbname = "pract10";
    public static String tbname2 = "rented_books";
    //Table columns
    public static String id = "id";
    public static String name = "name";
    public static String book = "book";
    public static String book_id = "book_id";
    public static String amt_pday = "amt_pday";
    public static String reg_date = "reg_date";
    public static String due_date = "due_date";
    public static String book_status = "book_status";
    //version code
    public static int dbversion = 1; // 1 for createquery & 2 for createquery2

    static String createquery = "create table " + tbname + "(" + id + " integer primary key autoincrement," + name + " varchar(50)," + book + " varchar(50)," + reg_date + " varchar(50)," + due_date + " varchar(50));";

//    static String createquery2 = "create table " + tbname2 + "(" + id + " integer primary key autoincrement," + name + " varchar(50)," + book + " varchar(50)," + book_id + " integer(10)," + amt_pday + " varchar(10)," + reg_date + " varchar(50)," + due_date + " varchar(50));";

    static String createquery2 = "create table " + tbname2 + "(" + id + " integer primary key autoincrement," + name + " varchar(50)," + book + " varchar(50)," + book_id + " integer(10)," + amt_pday + " varchar(10)," + reg_date + " varchar(50)," + due_date + " varchar(50)," + book_status + " integer(10));";

    //create table "tablename"(id integerprimary key autoincrement,name varchar(50),book varchar(50),reg_datevarchar(50),due_date varchar(50))

    //UPDATE Customers
    //SET ContactName = 'Alfred Schmidt', City= 'Frankfurt'
    //WHERE CustomerID = 1;

    public helper(Context context) {
        super(context, dbname, null, dbversion);
        Log.d("avoid", "DB created");
        Log.v("avoid",createquery);
        Log.v("avoid",createquery2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createquery2);
        db.execSQL(createquery);
        Log.d("avoid", "table created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    //insert query for database
    public void insert(String name, String book, String reg_date, String due_date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("book", book);
        cv.put("reg_date", reg_date);
        cv.put("due_date", due_date);
        db.insert(tbname, null, cv);
        Log.d("avoid", "data inserted");
    }

    public void insert2(String name, String book, Integer book_id, String amt_pday, String reg_date, String due_date,Integer book_status) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("book", book);
        cv.put("book_id", book_id);
        cv.put("amt_pday", amt_pday);
        cv.put("reg_date", reg_date);
        cv.put("due_date", due_date);
        cv.put("book_status", book_status);
        db.insert(tbname2, null, cv);
        Log.d("avoid", "data inserted");
    }

    // to retrieve all data
    public ArrayList<pojo> getData() {
        ArrayList<pojo> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select * from " + tbname;
        Cursor c = db.rawQuery(query, null);
        while (c.moveToNext()) {
            String id = c.getString(0);
            String name = c.getString(1);
            String book = c.getString(2);
            String reg_date = c.getString(3);
            String due_date = c.getString(4);
            pojo p = new pojo();
            p.setId(id);
            p.setName(name);
            p.setBook(book);
            p.setReg_date(reg_date);
            p.setDue_date(due_date);
            list.add(p);
        }
        return list;
    }

    public ArrayList<pojo> getData2() {
        ArrayList<pojo> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select * from " + tbname2;
        Cursor c = db.rawQuery(query, null);
        while (c.moveToNext()) {
            String id = c.getString(0);
            String name = c.getString(1);
            String book = c.getString(2);
            Integer book_id = Integer.valueOf(c.getString(3));
            String amt_pday = c.getString(4);
            String reg_date = c.getString(5);
            String due_date = c.getString(6);
            Integer book_status = Integer.valueOf(c.getString(7));
            pojo p = new pojo();
            p.setId(id);
            p.setName(name);
            p.setBook(book);
            p.setReg_date(reg_date);
            p.setDue_date(due_date);
            p.setBook_id(book_id);
            p.setAmt_pday(amt_pday);
            p.setBook_status(book_status);
            list.add(p);
        }
        return list;
    }

    //to retrieve particular raw data
    public Cursor returnBook(String rtnname, String rtnbook) {

        //ArrayList<pojoReturn> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * From " + tbname + " WHERE " + name + "='" + rtnname + "' and " + book + "='" + rtnbook + "'";
        Cursor c = db.rawQuery(query, null);

        /*while(c.moveToNext())
        {
        String id = c.getString(0);
        String name = c.getString(1);
        String book = c.getString(2);
        String reg_date = c.getString(3);
        String due_date = c.getString(4);
        pojoReturn p = new pojoReturn();
        p.setRtnid(id);
        p.setRtnname(name);
        p.setRtnbook(book);
        p.setRtnreg_rtndate(reg_date);
        p.setRtndue_date(due_date);
        list.add(p);
        }*/
        return c;
    }

    //delete data from db...
    public void delete(String sid) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "delete from " + tbname2 + " where " + id + "=" + sid;
        db.execSQL(sql);
        Log.d("avoid", "deleted");
    }

    public void update(Integer sid,Integer int_book_status){

        SQLiteDatabase db = this.getWritableDatabase();
        String updateQuery = "update " + tbname2 + " set " + book_status + "=" + int_book_status + " where " + id + "=" + sid;
        db.execSQL(updateQuery);
        Log.d("avoid", "updated" + updateQuery);
    }

}
