package com.aasem.inspire_info_soft.myschool;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.aasem.inspire_info_soft.myschool.DataClasses.UserStudentTop;
import com.aasem.inspire_info_soft.myschool.Fragments.UnderConstruction;
import com.aasem.inspire_info_soft.myschool.Utill.URL;
import com.bumptech.glide.Glide;
import com.fxn.cue.Cue;
import com.fxn.cue.enums.Duration;
import com.fxn.cue.enums.Type;
import com.lovejjfg.shadowcircle.CircleImageView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final int TIME_INTERVAL = 2000; // # milliseconds, desired time passed between two back presses.
    private long mBackPressed;
    Toolbar toolbar;
    DrawerLayout drawer;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    Context context;
    CircleImageView iv_user_dp;
    TextView tv_user_name,tv_user_mobile_no;
    public static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialization();
        setTitle("My School");
        setSupportActionBar(toolbar);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        //Open Default Fragment
        fragmentManager.beginTransaction().setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right).replace(R.id.container,new Dashboard()).commit();

        if (!SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, Login.class));
        }
        UserStudentTop userStudent = SharedPrefManager.getInstance(this).getUserStudent();

        tv_user_name.setText(""+userStudent.getName());
        tv_user_mobile_no.setText(""+userStudent.getContactNo());

        Glide.with(context)
                .load(URL.dp_folder+userStudent.getProfile())
                .dontAnimate()
                .placeholder(R.drawable.ic_user)
                .error(R.drawable.ic_user)
                .into(iv_user_dp);

    }

    void initialization()
    {
        context=this;
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        fragmentManager=getSupportFragmentManager();

        View header=navigationView.getHeaderView(0);
        iv_user_dp=(CircleImageView)header.findViewById(R.id.iv_user_dp);
        tv_user_mobile_no=(TextView)header.findViewById(R.id.tv_user_mobile_no);
        tv_user_name=(TextView)header.findViewById(R.id.tv_user_name);
    }

    public static void OpenFrgment(Fragment fragment)
    {
        fragmentManager.beginTransaction().setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right).replace(R.id.container,fragment).addToBackStack(null).commit();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }else {
            if(fragmentManager.getBackStackEntryCount()>1)
            {
                fragmentManager.popBackStack();
            }
            else {

                if(Dashboard.isOpen) {
                    if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis()) {
                        super.onBackPressed();
                        return;
                    } else {
                        Cue.init()
                                .with(context)
                                .setDuration(Duration.SHORT)
                                .setGravity(Gravity.BOTTOM)
                                .setMessage("Tap back button in order to exit")
                                .setType(Type.SECONDARY)
                                .show();
                        mBackPressed = System.currentTimeMillis();
                    }
                }
                else
                {
                    super.onBackPressed();
                }
            }
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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch (id)
        {

            case R.id.nav_manage:
                SharedPrefManager sharedPrefManager=new SharedPrefManager(context);
                sharedPrefManager.logout();
                startActivity(new Intent(context,Login.class));
                finish();
                break;
            case R.id.nav_home:
                OpenFrgment(new Dashboard());
                break;
            default:
                OpenFrgment(new UnderConstruction());
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
