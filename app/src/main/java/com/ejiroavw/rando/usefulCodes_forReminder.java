package com.ejiroavw.rando;

import android.content.DialogInterface;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

public class usefulCodes_forReminder {
      /*Create Alert Dialog
       public void createDialog(String type) {
        if (type == "loss") {
            AlertDialog.Builder alertDialogTest = new AlertDialog.Builder(game.this);
            alertDialogTest.setCancelable(false);
            alertDialogTest.setTitle("Exceeded Number Of Tries!");
            alertDialogTest.setMessage("Game Over! Correct Number was " + randomNumberGenerated);
            alertDialogTest.setPositiveButton("Try Again!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //Reset number of Tries and Previous Player Input
                    numberOfTries = 0;
                    previousPlayerInput = null;
                    Intent reloadPage = new Intent(game.this, game.class);
                    finish();
                    startActivity(reloadPage);
                    overridePendingTransition(0, 0);
                }
            })
                    .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            numberOfTries = 0;
                            previousPlayerInput = null;
                            Intent endGame = new Intent(game.this, main_menu.class);
                            startActivity(endGame);
                        }
                    });
            AlertDialog alertDialogTest_onCreate = alertDialogTest.create();
            alertDialogTest_onCreate.show();
        }
        else if (type == "win") {
            AlertDialog.Builder alertDialogTest = new AlertDialog.Builder(game.this);
            alertDialogTest.setCancelable(false);
            alertDialogTest.setTitle("Level Cleared!");
            alertDialogTest.setMessage("Congratulations! You Guess the Correct Answer \n" +
                    "Total Point is : " + totalPoints_accumulated);
            alertDialogTest.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    numberOfTries = 0;
                    previousPlayerInput = null;
                    Intent reloadPage = new Intent(game.this, game.class);
                    finish();
                    startActivity(reloadPage);
                    overridePendingTransition(0, 0);
                }
            })
                    .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            numberOfTries = 0;
                            previousPlayerInput = null;
                            Intent endGame = new Intent(game.this, main_menu.class);
                            startActivity(endGame);
                        }
                    });
            AlertDialog alertDialogTest_onCreate = alertDialogTest.create();
            alertDialogTest_onCreate.show();
        }else if(type == "exit"){
            AlertDialog.Builder alertDialogTest = new AlertDialog.Builder(game.this);
            alertDialogTest.setCancelable(false);
            alertDialogTest.setTitle("End Game");
            alertDialogTest.setMessage("Are you sure You want to End Game");
            alertDialogTest.setPositiveButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //Reset number of Tries and Previous Player Input
                    numberOfTries = 0;
                    previousPlayerInput = null;
                    Intent reloadPage = new Intent(game.this, game.class);
                    finish();
                    startActivity(reloadPage);
                    overridePendingTransition(0, 0);
                }
            })
                    .setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            SharedPreferences preference  = getSharedPreferences("PREF",0);
                            SharedPreferences.Editor editor = preference.edit();
                            editor.putInt("total_points",totalPoints_accumulated);
                            editor.apply();

                            Intent gotoScoresPage = new Intent(game.this, scores.class);
                            finish();
                            startActivity(gotoScoresPage);
                            overridePendingTransition(0, 0);

                        }
                    });
            AlertDialog alertDialogTest_onCreate = alertDialogTest.create();
            alertDialogTest_onCreate.show();
        }

    }*/

/*    AlertDialog.Builder exitConfirmationDialog = new AlertDialog.Builder(main_menu.this);
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
        exitConfirmationDialog_onCreate.show();*/


}
