package com.example.dp_project;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class db_class extends SQLiteOpenHelper{
    private static Context contexts;

    // Constructor to pass Context
    public db_class(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.contexts=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE employees (E_ID Integer Primary Key Autoincrement, E_Name Text,E_number Text,E_Address Text,E_city Text,E_salary Integer)");
        db.execSQL("CREATE TABLE users (U_ID Integer Primary Key Autoincrement, U_email Text,E_pass Text)");
        db.execSQL("CREATE TABLE jobs (J_ID Integer Primary Key Autoincrement, J_name Text,J_tye Text,J_skill Text)");
        db.execSQL("CREATE TABLE subscribers (S_ID Integer Primary Key Autoincrement, S_email Text)");
    }
    public void sub(String a)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues objContentValues = new ContentValues();
        objContentValues.put("S_email",a);
        db.insert("subscribers",null,objContentValues);
        db.close();
        Toast.makeText(contexts," number inserted ="+a, Toast.LENGTH_LONG).show();
    }
    public void unsub(String a)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        db.delete("subscribers", "S_email" + "=?", new String[]{a});
        db.close();
        Toast.makeText(contexts," number removed ="+a, Toast.LENGTH_LONG).show();
    }
    public void insertjobs(String a,String b,String c)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues objContentValues = new ContentValues();
        objContentValues.put("J_name",a);
        objContentValues.put("J_tye",b);
        objContentValues.put("J_skill",c);
        db.insert("jobs",null,objContentValues);
        db.close();
        Toast.makeText(contexts," Job inserted ="+a, Toast.LENGTH_LONG).show();
    }
    public List<String> getData()
    {
        ArrayList<String> names = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT S_email FROM subscribers",null);
        if(cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") String a = cursor.getString(cursor.getColumnIndex("S_email"));
                String data = a;

                // Adding the book data to the list
                names.add(data);

            } while (cursor.moveToNext());
        }
        cursor.close();
        return names;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + "employees");
        db.execSQL("DROP TABLE IF EXISTS" + "users");
        db.execSQL("DROP TABLE IF EXISTS" + "jobs");
        db.execSQL("DROP TABLE IF EXISTS" + "subscribers");
        onCreate(db);
    }
    public void register(String mail,String pass)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues objContentValues = new ContentValues();
        objContentValues.put("U_email",mail);
        objContentValues.put("E_pass",pass);
        db.insert("users",null,objContentValues);
        db.close();

    }

    public int getuser(String mail)
    {
        int id2 = 5000;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT U_ID FROM users WHERE U_email = '"+mail+"'",null);
        if (cursor != null && cursor.moveToFirst()) {
            id2 = cursor.getInt(0);
        }
        cursor.close();
        return id2;
    }
    public int getpass(String mail)
    {
        int id2 = 1000;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT U_ID FROM users WHERE E_pass = '"+mail+"'",null);
        if (cursor != null && cursor.moveToFirst()) {
            id2 = cursor.getInt(0);
        }
        cursor.close();
        cursor.close();
        return id2;
    }


    public  void insertuser(String name,String ph,String add,String city,int Sal)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues objContentValues = new ContentValues();
        objContentValues.put("E_Name",name);
        objContentValues.put("E_number",ph);
        objContentValues.put("E_Address",add);
        objContentValues.put("E_city",city);
        objContentValues.put("E_salary",Sal);
        db.insert("employees",null,objContentValues);
        Toast.makeText(contexts,"Hired", Toast.LENGTH_LONG).show();
        db.close();
    }
 /*   public  void insertuser(String name,String ph,String add,String city,int Sal)
    {
        Toast.makeText(contexts," salary inserted ="+Sal, Toast.LENGTH_LONG).show();
    }*/
}
