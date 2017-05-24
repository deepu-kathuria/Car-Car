
package com.example.deepanshu.carcare;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class main_expense extends Activity implements AdapterView.OnItemSelectedListener {

    EditText ed1,ed2,ed3,ed4;
    Button b1;
    Intent in;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getActionBar();
        actionBar.setHomeButtonEnabled(true);

        setContentView(R.layout.activity_main_expense);



        b1=(Button)findViewById(R.id.submit_expense);

        //selection = (TextView) findViewById(R.id.selection);

        ed1 = (EditText) findViewById(R.id.date_expense);
        ed2 = (EditText) findViewById(R.id.odometer_expense);
        ed3 = (EditText) findViewById(R.id.expense_type);
        ed4 = (EditText) findViewById(R.id.expense_value);




      final   Spinner spin = (Spinner) findViewById(R.id.reason_expense);

        List<String> reason_type = new ArrayList<String>();
        reason_type.add("Work");
        reason_type.add("Trip");

        ArrayAdapter<String> bb = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, reason_type);
        bb.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(bb);
        spin.setOnItemSelectedListener(this);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a,b,c,d,e,f;
                a=ed1.getText().toString().trim();
                b=ed2.getText().toString().trim();
                c=ed3.getText().toString().trim();
                d=ed4.getText().toString().trim();
                e=spin.getSelectedItem().toString();

                if(TextUtils.isEmpty(a) || TextUtils.isEmpty(b)||TextUtils.isEmpty(c)||TextUtils.isEmpty(d)) {
                    Toast.makeText(main_expense.this,"fill all the fields",Toast.LENGTH_SHORT).show();

                }
                else {

                    SQLiteDatabase db = openOrCreateDatabase("CARDB", Context.MODE_APPEND, null);

                    db.execSQL("CREATE  TABLE IF NOT EXISTS expense ( date VARCHAR ,audometer VARCHAR,ETYPE VARCHAR ,EVALUE VARCHAR ,REASON VARCHAR); ");
                    //db.execSQL("Delete from expense");
                    db.execSQL("insert into expense (date,audometer,ETYPE,EVALUE,REASON) values('" + a + "','" + b + "','" + c + "','" + d + "','" + e + "')");
                    Toast.makeText(main_expense.this, a, Toast.LENGTH_SHORT).show();
                }
            }
        });




    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
