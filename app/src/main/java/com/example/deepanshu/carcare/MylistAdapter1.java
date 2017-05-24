package com.example.deepanshu.carcare;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Deepanshu on 4/29/2017.
 */
public class MylistAdapter1 extends ArrayAdapter<String> {
    private Activity context;
    private ArrayList arr1;
    private ArrayList arr2;
    private ArrayList arr3;
    private ArrayList arr4;
    private ArrayList arr5;

    public MylistAdapter1(Activity context,ArrayList array1, ArrayList array2, ArrayList array3, ArrayList array4, ArrayList array5)
    {
        super(context,R.layout.activity_intro,array1);
      //  super(context,R.layout.activity_expense_nav,array1);
        this.context=context;
        arr1=array1;
        arr2=array2;
        arr3=array3;
        arr4=array4;
        arr5=array5;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowview=inflater.inflate(R.layout.activity_expense_nav,null,true);
        TextView t1,t2,t3,t4,t5;


        t1=(TextView)rowview.findViewById(R.id.textView2);
        t2=(TextView)rowview.findViewById(R.id.textView3);
        t3=(TextView)rowview.findViewById(R.id.textView6);
        t4=(TextView)rowview.findViewById(R.id.textView7);
        t5=(TextView)rowview.findViewById(R.id.textView8);

        t1.setText(arr1.get(position).toString());
        t2.setText(arr2.get(position).toString());
        t3.setText(arr3.get(position).toString());
        t4.setText(arr4.get(position).toString());
        t5.setText(arr5.get(position).toString());
        return rowview;
    }
}
