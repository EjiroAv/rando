package com.ejiroavw.rando;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class main_menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu_test);
        getSupportActionBar().hide();
    }

    public void playButtonClicked (View view){

        Intent game_menu = new Intent(main_menu.this, game.class);
        startActivity(game_menu);
        overridePendingTransition(0,0);

    }
    public void scoresButtonClicked (View view){
        Intent scores = new Intent(main_menu.this, scores.class);
        startActivity(scores);
        overridePendingTransition(0,0);
    }

    public void exitButtonClicked(View view){

        AlertDialog.Builder exitConfirmationDialog = new AlertDialog.Builder(main_menu.this);
        exitConfirmationDialog.setTitle("EXIT");
        exitConfirmationDialog.setMessage("Are you really sure you want to Exit?");
        exitConfirmationDialog.setCancelable(false);
        exitConfirmationDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(main_menu.this, "See You Later", Toast.LENGTH_SHORT).show();
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        })
                .setNegativeButton("No, I Love this Game so Much!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(main_menu.this, "Alright Then Let's Continue", Toast.LENGTH_SHORT).show();
                    }
                });
        AlertDialog exitConfirmationDialog_onCreate = exitConfirmationDialog.create();
        exitConfirmationDialog_onCreate.show();

    }
}