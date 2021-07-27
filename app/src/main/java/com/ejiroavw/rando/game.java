package com.ejiroavw.rando;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.Random;

public class game extends AppCompatActivity {
    Handler handler;

    // Number of Tries
    public static int numberOfTries = 0;

    private EditText player_input;
    private TextView hint, tries, totalPoints, game_level, main_text, generating_number_animation_view;
    private Button submit;
    private TableLayout game_status;
    private com.daimajia.numberprogressbar.NumberProgressBar progressBar;

    public static int level = 1;

    //Generate Random Number
    Random rn = new Random();
    int randomNumberGenerated = rn.nextInt(setDifficulty(level)) + 1;


    //Total Points
    public static int totalPoints_accumulated = 0;

    //Previous Player Input
    public static String previousPlayerInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_test);
        getSupportActionBar().hide();
        initview();
        setupUI(findViewById(R.id.layout));
        main_text.setVisibility(View.INVISIBLE);
        hint.setText("Generating Number ...");

        handler = new Handler();{
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    Thread thread  = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            for (int i=0; i <100; i++){
                                updateProgressBar();
                                generatingNumberAnimation();
                                SystemClock.sleep(100);
                            }
                            finishGeneratingNumberAnimation();
                        }
                    });
                    thread.start();
                }
            },3000);
        }









        //To Display Total Points of User
        if (totalPoints_accumulated == 0) {
//            totalPoints.setVisibility(View.INVISIBLE);
            tries.setPadding(20, 0, 20, 0);
        } else if ((totalPoints_accumulated > 0) && (totalPoints_accumulated <= 99)) {
            tries.setPadding(17, 0, 17, 0);
            totalPoints.setText("Total Points: " + totalPoints_accumulated);
        } else {
            game_status.setColumnShrinkable(2, true);
        }

        game_level.setText("Level: " + level);


//        setFinishOnTouchOutside(false);

        submit.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                //Prevent User from being able to Keep Trying after GameOver
                if (numberOfTries <= 4) {
                    mainAlgorithm();
                } else {
                    tries.setVisibility(View.INVISIBLE);
                    createCustomDialog("loss");
                }

            }
        });

        player_input.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    switch (keyCode) {
                        case KeyEvent.KEYCODE_ENTER:
                            hideSoftKeyboard(game.this);

                        default:
                            break;
                    }
                }
                return false;
            }
        });


    }

    private  int  setDifficulty(int level){
        int difficulty = 0 ;
        if ((level >= 1) && (level <= 10)){
             difficulty = 10;
        }else if  ((level >= 11) && (level <= 20)){
             difficulty = 20;
        }
        else if  ((level >= 21) && (level <= 30)){
            difficulty = 30;
        }
        else if  ((level >= 31) && (level <= 40)){
            difficulty = 40;
        }
        else if  ((level >= 41) && (level <= 50)){
            difficulty = 50;
        }
        else if  ((level >= 51) && (level <= 60)){
            difficulty = 60;
        }
        else if  ((level >= 61) && (level <= 70)){
            difficulty = 70;
        }
        else if  ((level >= 71) && (level <= 80)){
            difficulty = 80;
        }
        else if  ((level >= 81) && (level <= 90)){
            difficulty = 90;
        }
        else if  ((level >= 91) && (level <= 100)){
            difficulty = 100;
        }
        else {
            hint.setText("You have Completed the game");
        }
        return difficulty;
    }

    private void updateProgressBar(){
        game.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressBar.incrementProgressBy(1);
            }
        });
    }

    @Override
    public void onBackPressed() {
        createCustomDialog("exit");
    }

    private void generatingNumberAnimation() {
        game.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Random gna = new Random();
                int randomNumberForAnimation = gna.nextInt(100 )+1;
                generating_number_animation_view.setText(""+randomNumberForAnimation+"");
            }
        });

}

    private void finishGeneratingNumberAnimation(){
        game.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                generating_number_animation_view.setText("Done");
                handler = new Handler();{
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            generating_number_animation_view.setVisibility(View.INVISIBLE);
                            progressBar.setVisibility(View.INVISIBLE);
                        }
                    },2000);
                }

                handler = new Handler();{
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            main_text.setVisibility(View.VISIBLE);
                            hint.setText("Number is Between 0 and "+setDifficulty(level));
                        }
                    },2000);
                }

            }
        });
    }

    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }

    public static void showSoftKeybaord(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);

    }


    public void setupUI(View view) {
        if (!(view instanceof EditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    hideSoftKeyboard(game.this);
                    return false;
                }
            });
        }

    }

    //Initialise all the views and Objects From the ACTIVITY


    private void initview() {
        hint = findViewById(R.id.game_hint_view);
        tries = findViewById(R.id.game_numberOfTries_view);
        player_input = findViewById(R.id.game_player_input_view);
        submit = findViewById(R.id.game_button_view);
        totalPoints = findViewById(R.id.game_total_points_view);
        game_level = findViewById(R.id.game_level_view);
        game_status = findViewById(R.id.game_status_view);
        main_text = findViewById(R.id.game_mainText_view);
        generating_number_animation_view = findViewById(R.id.game_generating_number_animation_view);
        progressBar = findViewById(R.id.number_progress_bar);
    }

    // Create Dialog for Different Case Scenarios

    public void createCustomDialog(String type){
        if (type == "loss"){
            final Dialog dialog = new Dialog(game.this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.activity_custom_dialog);

            TextView titleTextView = (TextView) dialog.findViewById(R.id.custom_dialog_loss_title);
            TextView messageTextView = (TextView) dialog.findViewById(R.id.custom_dialog_loss_message);
            Button positiveButton = (Button) dialog.findViewById(R.id.custom_dialog_loss_button_tryAgain);
            Button negativeButton = (Button) dialog.findViewById(R.id.custom_dialog_loss_button_exit);

            titleTextView.setText("Exceeded Number Of Tries!");
            messageTextView.setText("Game Over! Correct Number was " + randomNumberGenerated);
            positiveButton.setText("Try Again");
            negativeButton.setText("End Game");

            positiveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    numberOfTries = 0;
                    previousPlayerInput = null;
                    Intent reloadPage = new Intent(game.this, game.class);
                    finish();
                    startActivity(reloadPage);
                    overridePendingTransition(0, 0);
                    dialog.dismiss();
                }
            });
            negativeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    numberOfTries = 0;
                    previousPlayerInput = null;
                    Intent endGame = new Intent(game.this, main_menu.class);
                    startActivity(endGame);
                    dialog.dismiss();
                }
            });

            dialog.show();

        }else if (type == "win"){
            final Dialog dialog = new Dialog(game.this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.activity_custom_dialog);

            TextView titleTextView = (TextView) dialog.findViewById(R.id.custom_dialog_loss_title);
            TextView messageTextView = (TextView) dialog.findViewById(R.id.custom_dialog_loss_message);
            Button positiveButton = (Button) dialog.findViewById(R.id.custom_dialog_loss_button_tryAgain);
            Button negativeButton = (Button) dialog.findViewById(R.id.custom_dialog_loss_button_exit);

            titleTextView.setText("Level Cleared!");
            messageTextView.setText("Congratulations! You Guess the Correct Answer \n" +
                    "Total Point is : " + totalPoints_accumulated);
            positiveButton.setText("Continue");
            negativeButton.setText("End Game");

            positiveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    numberOfTries = 0;
                    previousPlayerInput = null;
                    Intent reloadPage = new Intent(game.this, game.class);
                    finish();
                    startActivity(reloadPage);
                    overridePendingTransition(0, 0);
                    dialog.dismiss();
                }
            });
            negativeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    numberOfTries = 0;
                    previousPlayerInput = null;
                    Intent endGame = new Intent(game.this, main_menu.class);
                    startActivity(endGame);
                    dialog.dismiss();
                }
            });

            dialog.show();

        }else if (type == "exit"){
            final Dialog dialog = new Dialog(game.this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.activity_custom_dialog);

            TextView titleTextView = (TextView) dialog.findViewById(R.id.custom_dialog_loss_title);
            TextView messageTextView = (TextView) dialog.findViewById(R.id.custom_dialog_loss_message);
            Button positiveButton = (Button) dialog.findViewById(R.id.custom_dialog_loss_button_tryAgain);
            Button negativeButton = (Button) dialog.findViewById(R.id.custom_dialog_loss_button_exit);

            titleTextView.setText("Exit Game");
            messageTextView.setText("Are you sure You want to Exit Game");
            positiveButton.setText("No");
            negativeButton.setText("Yes");

            positiveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    numberOfTries = 0;
                    previousPlayerInput = null;
                    Intent reloadPage = new Intent(game.this, game.class);
                    finish();
                    startActivity(reloadPage);
                    overridePendingTransition(0, 0);
                    dialog.dismiss();
                }
            });
            negativeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SharedPreferences preference  = getSharedPreferences("PREF",0);
                    SharedPreferences.Editor editor = preference.edit();
                    editor.putInt("total_points",totalPoints_accumulated);
                    editor.apply();

                    Intent gotoScoresPage = new Intent(game.this, scores.class);
                    finish();
                    startActivity(gotoScoresPage);
                    overridePendingTransition(0, 0);
                    dialog.dismiss();
                }
            });

            dialog.show();

        }
    }


    //Check If user Input(or User Guess) is the same as random Number Generated
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void mainAlgorithm() {
        numberOfTries++; //Track Number of Tries of User

        System.out.println("Correct Answer : " + randomNumberGenerated);
        String playerInput_string = player_input.getText().toString(); //Collect User Input
        player_input.setText(""); //Clear text in EditView so USER can easily input their next Guess

        //Check if the UserInput is the same as the number they have recently used: To prevent unnecessary Repetitiveness
        if ((previousPlayerInput == null) || (!previousPlayerInput.equals(playerInput_string))) {
            try {
                previousPlayerInput = playerInput_string;
                int playerInput = Integer.parseInt(playerInput_string);
                if (playerInput == randomNumberGenerated) {
                    System.out.println("Congratulations! You Guess the Correct Answer");
                    player_input.setBackgroundColor(getColor(R.color.green));
                    totalPoints_accumulated = totalPoints_accumulated + 20;  //calculate Total Points
                    level = level + 1;
                    System.out.println("Total Points : " + totalPoints_accumulated);
                    createCustomDialog("win"); //Create a Dialog for Winning Game
                } else {
                    if (playerInput < randomNumberGenerated) {
                        hint.setText("Try a Number Higher than " + playerInput_string);
                        tries.setText("Number of Tries: " + numberOfTries);
                        player_input.setBackgroundColor(getColor(R.color.red));
                        player_input.requestFocus();
                        showSoftKeybaord(game.this);
                    } else {
                        hint.setText("Try a Number Lower than " + playerInput_string);
                        tries.setText("Number of Tries: " + numberOfTries);
                        player_input.setBackgroundColor(getColor(R.color.red));
                        player_input.requestFocus();
                        showSoftKeybaord(game.this);
                    }
                }

            } catch (NumberFormatException e) {
                player_input.setError("Input a Number between 0 - 9");
                player_input.requestFocus();
                showSoftKeybaord(game.this);
                numberOfTries = numberOfTries - 1;// To Prevent numberOfTries from counting
                previousPlayerInput = " ";
            }
        } else {
            hint.setText("You Just Guessed That!, Try another Number");
            numberOfTries = numberOfTries - 1;
            tries.setText("Number of Tries: " + numberOfTries);
        }

        if (numberOfTries == 5) {
            System.out.println("GAME OVER!, Correct Number was " + randomNumberGenerated);
            createCustomDialog("custom_loss"); //Create a Dialog for loosing Game
        }

    }
}



