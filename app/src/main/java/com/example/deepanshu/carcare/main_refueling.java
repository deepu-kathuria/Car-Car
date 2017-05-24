
package com.example.deepanshu.carcare;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class main_refueling extends Activity implements AdapterView.OnItemSelectedListener {

    EditText ed1,ed2,ed3,ed4;
    Button b1;
    Intent in;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getActionBar();
        actionBar.setHomeButtonEnabled(true);

        setContentView(R.layout.activity_main_refueling);



         b1=(Button)findViewById(R.id.sbumit_fuel);

        //selection = (TextView) findViewById(R.id.selection);

        ed1 = (EditText) findViewById(R.id.date_expense);
        ed2 = (EditText) findViewById(R.id.odometer_expense);
        ed3 = (EditText) findViewById(R.id.editText4);
        ed4 = (EditText) findViewById(R.id.editText5);

        final Spinner spin = (Spinner) findViewById(R.id.reason_expense);
        final Spinner spin1 = (Spinner) findViewById(R.id.service_type);

        List<String> type_fuel = new ArrayList<String>();
        type_fuel.add("CNG");
        type_fuel.add("Diesel");
        type_fuel.add("Electric");
        type_fuel.add("Ethanol");
        type_fuel.add("Gas Premimium");
        type_fuel.add("Gasoline");

        ArrayAdapter<String> aa = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, type_fuel);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spin.setAdapter(aa);
        spin.setOnItemSelectedListener(this);

        List<String> reason_type = new ArrayList<String>();
        reason_type.add("Work");
        reason_type.add("Trip");

        ArrayAdapter<String> bb = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, reason_type);
        bb.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(bb);
        spin1.setOnItemSelectedListener(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a,b,c,d,e,f;
                a=ed1.getText().toString().trim();
                b=ed2.getText().toString().trim();
                c=ed3.getText().toString().trim();
                d=ed4.getText().toString().trim();
                e=spin.getSelectedItem().toString();
                f=spin1.getSelectedItem().toString();

                if(TextUtils.isEmpty(a) || TextUtils.isEmpty(b)||TextUtils.isEmpty(c)||TextUtils.isEmpty(d)) {
                    Toast.makeText(main_refueling.this,"fill all the fields",Toast.LENGTH_SHORT).show();

                }
                else {

                    SQLiteDatabase db = openOrCreateDatabase("CARDB", Context.MODE_APPEND, null);
                    db.execSQL("CREATE  TABLE IF NOT EXISTS refuil ( date VARCHAR ,audometer VARCHAR,PRICE VARCHAR ,COST VARCHAR,FTYPE VARCHAR ,REASON VARCHAR); ");

                    //db.execSQL("Delete from refuil");
                    //db.execSQL("Delete from service");
                    db.execSQL("insert into refuil (date,audometer,PRICE,COST,FTYPE,REASON) values('" + a + "','" + b + "','" + c + "','" + d + "','" + e + "','" + f + "')");
                    Toast.makeText(main_refueling.this, "Hi", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
