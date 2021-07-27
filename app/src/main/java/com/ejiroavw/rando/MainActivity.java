package com.ejiroavw.rando;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        View decorview = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorview.setSystemUiVisibility(uiOptions);
        ActionBar actionBar = getActionBar();
        actionBar.hide();*/
        getSupportActionBar().hide();


      handler = new Handler();
      handler.postDelayed(new Runnable() {
                              @Override
                              public void run() {
                                  Intent splashtologin = new Intent(MainActivity.this, main_menu.class);
                                  startActivity(splashtologin);
                                  finish();
                              }
                          },5000);


       /* Thread splash = new Thread(){
            public void run(){
                try {
                    sleep(5*1000);

                    Intent loginpage = new Intent(getBaseContext(),login_page.class);
                    startActivity(loginpage);
                    finish();
                } catch (Exception e){

                }
            }
        };

        splash.start();*/


    }
}