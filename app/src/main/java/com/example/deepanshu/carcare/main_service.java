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

public class main_service extends Activity implements AdapterView.OnItemSelectedListener {

    EditText ed1,ed2,ed3,ed4;
    Button b1;
    Intent in;

    String a,b,c,d,e;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getActionBar();
        actionBar.setHomeButtonEnabled(true);

        setContentView(R.layout.activity_main_service);



        b1=(Button)findViewById(R.id.submit_service);

        //selection = (TextView) findViewById(R.id.selection);

        ed1 = (EditText) findViewById(R.id.date_service);
        ed2 = (EditText) findViewById(R.id.odometer);
        ed3 = (EditText) findViewById(R.id.service_cost);




        final Spinner spin = (Spinner) findViewById(R.id.service_type);

        List<String> reason_type = new ArrayList<String>();
        reason_type.add("Air Conditioning");
        reason_type.add("Air Filter");
        reason_type.add("Battery");
        reason_type.add("Belts");
        reason_type.add("Body/Chassis");
        reason_type.add("Brake Fluid");
        reason_type.add("Brake Pad");

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
                d=spin.getSelectedItem().toString();

                if(TextUtils.isEmpty(a) || TextUtils.isEmpty(b)||TextUtils.isEmpty(c)) {
                    Toast.makeText(main_service.this,"fill all the fields",Toast.LENGTH_SHORT).show();

                }
                else {

                    SQLiteDatabase db = openOrCreateDatabase("CARDB", Context.MODE_APPEND, null);
                    db.execSQL("CREATE  TABLE IF NOT EXISTS service ( date VARCHAR ,audometer VARCHAR,STYPE VARCHAR ,SVALUE VARCHAR ); ");
                    db.execSQL("insert into service (date,audometer,STYPE,SVALUE) values('" + a + "','" + b + "','" + c + "','" + d + "')");
                    Toast.makeText(main_service.this, "Hi", Toast.LENGTH_SHORT).show();
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
