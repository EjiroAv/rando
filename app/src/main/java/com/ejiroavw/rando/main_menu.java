package com.ejiroavw.rando;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class main_menu extends AppCompatActivity {
    Switch light_dark_mode_switch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu_test);
        getSupportActionBar().hide();
        light_dark_mode_switch = findViewById(R.id.light_dark_mode_switch);
        if (Build.VERSION.SDK_INT >= 29){
            SharedPreferences sharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE);
            final SharedPreferences.Editor editor = sharedPreferences.edit();
            final boolean isDarkModeOn = sharedPreferences.getBoolean("isDarkModeOn", false);

            // When user reopens the app
            // after applying dark/light mode
            if (isDarkModeOn) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                light_dark_mode_switch.setChecked(true);
            }
            else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                light_dark_mode_switch.setChecked(false);
            }
            light_dark_mode_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked){
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                        editor.putBoolean("isDarkModeOn", true);
                        editor.apply();
                    }else {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                        editor.putBoolean("isDarkModeOn", false);
                        editor.apply();
                    }
                }
            });
        }else {
            light_dark_mode_switch.setVisibility(View.GONE);
        }


    }

    public void playButtonClicked (View view){

        Intent game_menu = new Intent(main_menu.this, game.class);
        startActivity(game_menu);
        overridePendingTransition(0,0);

    }
    public void scoresButtonClicked (View view){
        Intent scores = new Intent(main_menu.this, scores.class);
        scores.putExtra("activity","main_menu");
        startActivity(scores);
        overridePendingTransition(0,0);
    }

    public void exitButtonClicked(View view){
        final Dialog dialog = new Dialog(main_menu.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.activity_custom_dialog);

        TextView titleTextView = (TextView) dialog.findViewById(R.id.custom_dialog_loss_title);
        TextView messageTextView = (TextView) dialog.findViewById(R.id.custom_dialog_loss_message);
        Button positiveButton = (Button) dialog.findViewById(R.id.custom_dialog_loss_button_tryAgain);
        Button negativeButton = (Button) dialog.findViewById(R.id.custom_dialog_loss_button_exit);

        titleTextView.setText("Exit Game");
        messageTextView.setText("Are you sure you want to EXIT Game?");
        positiveButton.setText("No");
        negativeButton.setText("Yes");

        positiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        negativeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
                dialog.dismiss();
            }
        });

        dialog.show();


    }
}