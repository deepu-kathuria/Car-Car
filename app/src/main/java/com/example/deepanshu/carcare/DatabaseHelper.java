package com.example.deepanshu.carcare;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {



    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contacts.db";
    private static final String TABLE_NAME = "contacts";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASS= "pass";
    public static final String Email = "emailKey";
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String check = "check";
    SQLiteDatabase db ;
    Context context;



    private static final String TABLE_CREATE = "create table"+ TABLE_NAME + "("+ COLUMN_EMAIL +" text not null ," + COLUMN_PASS +" text not null);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    public int insertContact(contact c)
    {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_EMAIL,c.getEmail());
        values.put(COLUMN_PASS,c.getPassword());

        db.insert(TABLE_NAME,null,values);

        db.close();
        return 1;
    }

    public String searchPass(String email)
    {
         //SharedPreferences sharedpreferences;

        //sharedpreferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        db = this.getReadableDatabase();
        String query = "select * from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);

        String a,b;
        b="not found";

        if(cursor.moveToFirst())
        {

            do {
                a=cursor.getString(0);

                if(a.equals(email))
                {
                    b=cursor.getString(1);
                    break;
                }
            }while(cursor.moveToNext());

        }
        cursor.close();

       /* if(b != "not found")
        {


            //String n  = ed1.getText().toString();
            //String ph  = ed2.getText().toString();
            //String e  = ed3.getText().toString();

            //SharedPreferences.4
            SharedPreferences.Editor editor = sharedpreferences.edit();

            editor.putString(Email, email);
            editor.putString(check, "1");

            editor.commit();
        }*/
        return b;
    }
    /*public int isLoggedIn(){
        SharedPreferences sharedpreferences;

        sharedpreferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        if(sharedpreferences.getString("key", "") == "1") {
            Toast.makeText(this.context,"Password length must be more than 6", Toast.LENGTH_SHORT).show();
            //boolean t =1;
            return 1;
        }
        return 0;
    }
    */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXIST" + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}
