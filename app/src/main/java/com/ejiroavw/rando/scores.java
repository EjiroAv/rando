package com.ejiroavw.rando;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class scores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);
        getSupportActionBar().hide();
    }
}