package com.aasem.inspire_info_soft.myschool;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    private ImageView iv_app_logo;
    private TextView tv_app_name;
    Animation uptodown,downtoup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        iv_app_logo = (ImageView) findViewById(R.id.iv_app_logo);
        tv_app_name = (TextView) findViewById(R.id.tv_app_name);

        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this,R.anim.downtoup);
        iv_app_logo.setAnimation(uptodown);
        tv_app_name.setAnimation(downtoup);


        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    sharedElementTransition();
                }
                else
                {
                    openLogin();
                }
            }
        }, 3000);
    }

    public void openLogin()
    {
        startActivity(new Intent(SplashScreen.this,Login.class));
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void sharedElementTransition() {
        try {
            Pair[] pair = new Pair[2];
            pair[0] = new Pair<View, String>(iv_app_logo, "iv_app_logo_shared");
            pair[1] = new Pair<View, String>(tv_app_name, "tv_app_name_shared");

            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, pair);
            Intent i = new Intent(SplashScreen.this, Login.class);
            startActivity(i, options.toBundle());
            finish();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            openLogin();
        }
    }
}
