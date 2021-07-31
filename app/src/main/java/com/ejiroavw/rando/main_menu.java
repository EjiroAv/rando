package com.ejiroavw.rando;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;

public class main_menu extends AppCompatActivity {
    SwitchCompat light_dark_mode_switch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        getSupportActionBar().hide();
        light_dark_mode_switch = findViewById(R.id.light_dark_mode_switch);
        if (Build.VERSION.SDK_INT >= 29){
            light_dark_mode_switch.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if (isChecked){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
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

        titleTextView.setText(getString(R.string.exit_dialog_title));
        messageTextView.setText(getString(R.string.exit_dialog_message));
        positiveButton.setText(getString(R.string.exit_dialog_positive_button));
        negativeButton.setText(getString(R.string.exit_dialog_negative_button));

        positiveButton.setOnClickListener(v -> dialog.dismiss());
        negativeButton.setOnClickListener(v -> {
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
            dialog.dismiss();
        });

        dialog.show();


    }
}