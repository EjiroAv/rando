package com.ejiroavw.rando;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
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