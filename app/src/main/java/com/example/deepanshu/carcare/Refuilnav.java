package com.example.deepanshu.carcare;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Refuilnav extends Activity {
    ListView l1;
    ArrayList array1,array2,array3,array4,array5,array6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refuilnav);
        l1=(ListView)findViewById(R.id.listView);
        SQLiteDatabase db=openOrCreateDatabase("CARDB", Context.MODE_APPEND,null);
        array1=new ArrayList();
        array2=new ArrayList();
        array3=new ArrayList();
        array4=new ArrayList();
        array5=new ArrayList();
        array6=new ArrayList();
        String q="select * from refuil";
        Cursor c=db.rawQuery(q,null);
        String name1,name2,name3,name4,name5,name6;
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
            name6=c.getString(5);
            array6.add(name6);

        }
        MylistAdapter adapter=new MylistAdapter(this,array1,array2,array3,array4,array5,array6);
        l1.setAdapter(adapter);

    }
}
