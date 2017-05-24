package com.example.deepanshu.carcare;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by Deepanshu on 3/2/2017.
 */
public class register extends Activity implements View.OnClickListener{

    DatabaseHelper helper = new DatabaseHelper(this);

    private Button buttonRegistered;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewSignin;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);*/

        setContentView(R.layout.register);

//        int check = helper.isLoggedIn();


        /*if(firebaseAuth.getCurrentUser() != null)
        {
            //profile activity here


            startActivity(new Intent(getApplicationContext(),MainActivity.class));

        }*/

        progressDialog = new ProgressDialog(this);

        buttonRegistered = (Button) findViewById(R.id.register);
        editTextEmail = (EditText) findViewById(R.id.email_register);
        editTextPassword = (EditText) findViewById(R.id.password_register);
        textViewSignin = (TextView) findViewById(R.id.textViewSignin);


        buttonRegistered.setOnClickListener(this);
        textViewSignin.setOnClickListener(this);
    }




    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(this, register.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    public void onRegisterClick()
    {

        int t = 0;
        String email = editTextEmail.getText().toString();
        String pass = editTextPassword.getText().toString();

        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (!email.matches(emailPattern))
        {
            Toast.makeText(getApplicationContext(),"Invalid email address", Toast.LENGTH_SHORT).show();
        }
        else if(pass.length() < 6)
        {
            Toast.makeText(getApplicationContext(),"Password length must be more than 6", Toast.LENGTH_SHORT).show();
        }

        else
        {

            contact c = new contact();
            c.setEmail(email);
            c.setPassword(pass);
            t = helper.insertContact(c);
            if(t==1)
            {
                Toast.makeText(this,"User Registered",Toast.LENGTH_SHORT).show();
            }

        }



    }

    @Override
    public void onClick(View v) {

        String email = editTextEmail.getText().toString();
        String pass = editTextPassword.getText().toString();

        if(v== textViewSignin) {
            finish();
            Intent intent = new Intent(this, login.class);
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
        else if(v== buttonRegistered)
        onRegisterClick();

    }
}
