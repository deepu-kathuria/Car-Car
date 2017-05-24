package com.example.deepanshu.carcare;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class expense extends Activity {
    ListView l1;
    ArrayList array1,array2,array3,array4,array5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);
        l1=(ListView)findViewById(R.id.listView1);
        SQLiteDatabase db=openOrCreateDatabase("CARDB", Context.MODE_APPEND,null);
        array1=new ArrayList();
        array2=new ArrayList();
        array3=new ArrayList();
        array4=new ArrayList();
        array5=new ArrayList();
        //array6=new ArrayList();
        String q="select * from expense";
        Cursor c=db.rawQuery(q,null);
        String name1,name2,name3,name4,name5;
        while (c.moveToNext())
        {
            name1=c.getString(0);
            array1.add(name1);
            name2=c.getString(1);
            array2.add(name2);
            name3=c.getString(2);
            array3.add(name3);
            name4=c.getString(3);
            array4.add(name4);
            name5=c.getString(4);
            array5.add(name5);



        }
     //   Toast.makeText(expense.this,array1.get(0).toString(),Toast.LENGTH_SHORT).show();
        MylistAdapter1 adapter=new MylistAdapter1(this,array1,array2,array3,array4,array5);
        l1.setAdapter(adapter);

    }
}
