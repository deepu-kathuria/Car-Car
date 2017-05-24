package com.example.deepanshu.carcare;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends Activity implements View.OnClickListener{

    private Button buttonSignIn;

    private TextView textViewSignUp;
    private EditText editTextEmail;
    private EditText editTextPassword;
    SharedPreferences sharedpreferences;
    public static final String Email = "emailKey";
    public static final String MyPREFERENCES = "mypref";

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        setContentView(R.layout.login);

        editTextEmail = (EditText) findViewById(R.id.email_login);
        editTextPassword = (EditText) findViewById(R.id.password_login);
        buttonSignIn = (Button) findViewById(R.id.buttonSignin);
        textViewSignUp = (TextView) findViewById(R.id.textViewSignUp);

        buttonSignIn.setOnClickListener(this);
        textViewSignUp.setOnClickListener(this);
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


    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
    private void loginUser(){

        String email = editTextEmail.getText().toString();
        String pass = editTextPassword.getText().toString();

        String password = helper.searchPass(email);

        if( pass.equals(password))
        {
            /*sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

            //String n  = ed1.getText().toString();
            //String ph  = ed2.getText().toString();
            //String e  = ed3.getText().toString();

                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString(Email, email);
                //editor.putString(Phone, ph);

                editor.commit();*/
            finish();
            Intent intent = new Intent(this,add_car.class);
            startActivity(intent);

        }
        else
        {
            Toast toast = Toast.makeText(this,"Credentials did not match",Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    @Override
    public void onClick(View v) {

        String email = editTextEmail.getText().toString();
        String pass = editTextPassword.getText().toString();

        if(v==textViewSignUp)
        {
            finish();
            Intent intent = new Intent(this,register.class);
            startActivity(intent);
        }

        else if(TextUtils.isEmpty(email)) {
            Toast.makeText(this,"fill all the fields",Toast.LENGTH_SHORT).show();
            return;
        }

        else if(TextUtils.isEmpty(pass)) {
            Toast.makeText(this,"fill all the fields",Toast.LENGTH_SHORT).show();
            return;
        }
        else if(v==buttonSignIn) {
            loginUser();
        }


    }
}
