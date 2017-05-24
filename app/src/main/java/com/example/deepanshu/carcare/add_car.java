package com.example.deepanshu.carcare;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

public class add_car extends Activity implements AdapterView.OnItemSelectedListener{
    EditText ed1,ed2,ed3;
    Button b1;
    Intent in;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String Phone = "phoneKey";
    public static final String Email = "emailKey";
    SharedPreferences sharedpreferences;
    String a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);

        b1=(Button)findViewById(R.id.button);

        //selection = (TextView) findViewById(R.id.selection);
        final Spinner spin = (Spinner) findViewById(R.id.brand);

        List<String> brand = new ArrayList<String>();
        brand.add("BMW");
        brand.add("Mercedes");
        brand.add("Audi");
        brand.add("Pagani");
        brand.add("Rolls Royce");
        brand.add("Hyundai");

        ArrayAdapter<String> aa = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, brand);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);
        spin.setOnItemSelectedListener(this);





        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // String n  = ed1.getText().toString();
                //String ph  = ed2.getText().toString();
                //String e  = ed3.getText().toString();
                String t = spin.getSelectedItem().toString();

                /*SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString(Name, n);
                editor.putString(Phone, ph);
                editor.putString(Email, e);
                editor.commit();*/
                EditText e1 = (EditText) findViewById(R.id.model);
                a = e1.getText().toString().trim();
                if(TextUtils.isEmpty(a)) {
                    Toast.makeText(add_car.this,"fill all the fields",Toast.LENGTH_SHORT).show();

                }
                else {
                    finish();
                    in = new Intent(add_car.this, MainActivity.class);

                    Bundle bundle = new Bundle();

//Add your data to bundle
                    bundle.putString("stuff", t);

//Add the bundle to the intent
                    in.putExtras(bundle);

                    startActivity(in);
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        //Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}