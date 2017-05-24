package com.example.deepanshu.carcare;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FloatingActionButton fab_plus,fab_service,fab_refueling,fab_expense;
    Animation Fabopen,Fabclose,FabRclockwise,FabRanticlockwise;
    boolean isOpen = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.mytitle);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button kk = (Button) findViewById(R.id.kk);
        Button ss =(Button) findViewById(R.id.ss);
        Button qq = (Button)findViewById(R.id.qq);

        kk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),main_expense.class);
                startActivity(intent);
            }
        });
        ss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),main_refueling.class);
                startActivity(intent);
            }
        });
        qq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),main_service.class);
                startActivity(intent);
            }
        });





     fab_plus = (FloatingActionButton) findViewById(R.id.fab_plus);
        fab_refueling = (FloatingActionButton) findViewById(R.id.fab_refueling);
        fab_service= (FloatingActionButton) findViewById(R.id.fab_service);
        fab_expense= (FloatingActionButton) findViewById(R.id.fab_expense);
        Fabopen = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_open);
        Fabclose = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_close);
        FabRclockwise = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_clockwise);
        FabRanticlockwise = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_anticlockwise);

        fab_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isOpen){
                    fab_refueling.startAnimation(Fabclose);
                    fab_service.startAnimation(Fabclose);
                    fab_expense.startAnimation(Fabclose);
                    fab_plus.startAnimation(FabRanticlockwise);
                    fab_service.setClickable(false);
                    isOpen = false;

                }
                else {
                    fab_refueling.startAnimation(Fabopen);
                    fab_service.startAnimation(Fabopen);
                    fab_expense.startAnimation(Fabopen);
                    fab_plus.startAnimation(FabRclockwise);
                    fab_service.setClickable(true);
                    isOpen = true;
                }
            }

        });

        fab_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),main_service.class);
                startActivity(intent);

            }

        });

        fab_refueling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),main_refueling.class);
                startActivity(intent);

            }

        });
        fab_expense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),main_expense.class);
                startActivity(intent);

            }

        });

        Intent intent = getIntent();
        String id = intent.getStringExtra("stuff");


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header=navigationView.getHeaderView(0);
/*View view=navigationView.inflateHeaderView(R.layout.nav_header_main);*/
        TextView name = (TextView)header.findViewById(R.id.Car_name);

        name.setText(id);
        navigationView.setNavigationItemSelectedListener(this);




    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }*/
        if(id == R.id.logout){
            finish();
            Intent intent = new Intent(this,login.class);
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_refueling) {
            // Handle the camera action
            Intent i=new Intent(MainActivity.this,Refuilnav.class);
            startActivity(i);
        } else if (id == R.id.nav_expense) {
            Intent i=new Intent(MainActivity.this,expense.class);
            startActivity(i);


        } else if (id == R.id.nav_service) {
            Intent i=new Intent(MainActivity.this,service_nav.class);
            startActivity(i);
        }
        else if (id == R.id.contact){
            Intent i=new Intent(MainActivity.this,Helpline.class);
            startActivity(i);
        }
        else if (id == R.id.about_me){
            Intent i=new Intent(MainActivity.this,bout_Me.class);
            startActivity(i);
        }
        /*else if (id == R.id.login) {

            SessionManager session = new SessionManager(getApplicationContext());

            if (session.isLoggedIn()) {
                Toast.makeText(this,"You are already logged in ",Toast.LENGTH_SHORT).show();

            }

            Intent res = new Intent();
            String mPackage = "com.example.deepanshu.carcare";
            String mClass = ".login";
            res.setComponent(new ComponentName(mPackage,mPackage+mClass));
            startActivity(res);
        }
        else if (id == R.id.register) {
            Intent res = new Intent();
            String mPackage = "com.example.deepanshu.carcare";
            String mClass = ".register";
            res.setComponent(new ComponentName(mPackage,mPackage+mClass));
            startActivity(res);

        }/* else if (id == R.id.nav_send) {

        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
