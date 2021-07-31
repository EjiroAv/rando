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

        getSupportActionBar().hide();


      handler = new Handler();
      handler.postDelayed(() -> {
          Intent splashtologin = new Intent(MainActivity.this, main_menu.class);
          startActivity(splashtologin);
          finish();
      },5000);



    }
}