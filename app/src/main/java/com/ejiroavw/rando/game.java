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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Objects;
import java.util.Random;

public class game extends AppCompatActivity {
    Handler handler;

    private EditText player_input;
    private TextView hint, tries, totalPoints, game_level, main_text, generating_number_animation_view;
    private Button submit, hint_button;
    private LinearLayout game_status;
    private com.daimajia.numberprogressbar.NumberProgressBar progressBar;
    private RelativeLayout layout;


    Random rn = new Random();
    int randomNumberGenerated = rn.nextInt(setDifficulty(level)) + 1;

    public static int numberOfTries = 0;
    public static int level = 1;
    public static int limit = 0;
    public static int totalPoints_accumulated = 0;
    public static String previousPlayerInput;
    public static String msg;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Objects.requireNonNull(getSupportActionBar()).hide();
        initview();
        setViewsInvisible();
        layout.setVisibility(View.VISIBLE);

        handler = new Handler();
        {
            handler.postDelayed(() -> {

                Thread thread = new Thread(() -> {
                    for (int i = 0; i < 100; i++) {
                        updateProgressBar();
                        generatingNumberAnimation();
                        SystemClock.sleep(20);
                    }
                    finishGeneratingNumberAnimation();
                });
                thread.start();
            }, 1000);
        }

        game_level.setText(getString(R.string.level, level));
        totalPoints.setText(getString(R.string.total_points, totalPoints_accumulated));
        System.out.println(randomNumberGenerated);


        submit.setOnClickListener(view -> {
            mainAlgorithm();
            setHintVisible();


        });

        player_input.setOnKeyListener((v, keyCode, event) -> {
            if (event.getAction() == KeyEvent.ACTION_DOWN) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    hideSoftKeyboard(game.this);
                }
            }
            return false;
        });

        player_input.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                setupUI(findViewById(R.id.layout));
            }
        });

        hint_button.setOnClickListener(v -> createCustomDialog("hint"));


    }

    private int setDifficulty(int level) {
        int difficulty = 0;
        if ((level >= 1) && (level <= 10)) {
            difficulty = 10;
        } else if ((level >= 11) && (level <= 20)) {
            difficulty = 20;
        } else if ((level >= 21) && (level <= 30)) {
            difficulty = 30;
        } else if ((level >= 31) && (level <= 40)) {
            difficulty = 40;
        } else if ((level >= 41) && (level <= 50)) {
            difficulty = 50;
        } else if ((level >= 51) && (level <= 60)) {
            difficulty = 60;
        } else if ((level >= 61) && (level <= 70)) {
            difficulty = 70;
        } else if ((level >= 71) && (level <= 80)) {
            difficulty = 80;
        } else if ((level >= 81) && (level <= 90)) {
            difficulty = 90;
        } else if ((level >= 91) && (level <= 100)) {
            difficulty = 100;
        } else {
            hint.setText(getString(R.string.end_of_game));
        }
        return difficulty;
    }

    private void setHint(int game_playerInput) {
        Random shr = new Random();
        int options = 0;
        if (level <= 10) {
            options = shr.nextInt(1);
        } else if (level <= 30) {
            options = shr.nextInt(2);
        } else if (level <= 40) {
            options = shr.nextInt(3);
        } else if (level <= 50) {
            options = shr.nextInt(4);
        } else if (level <= 60) {
            options = shr.nextInt(5);
        } else if (level <= 100) {
            options = shr.nextInt(6);
        }
        if (options == 0) {
            Random adr = new Random();
            int operation = adr.nextInt(1);
            int firstNumber = adr.nextInt(20) + 1;
            int secondNumber = adr.nextInt(20) + 1;
            int result;


            if (operation == 0) {
                result = firstNumber + secondNumber;
                if (result > randomNumberGenerated) {
                    msg = ("Number is Lower than " + firstNumber + " + " + secondNumber);
                } else if (result < randomNumberGenerated) {
                    msg = ("Number is Greater than " + firstNumber + " + " + secondNumber);
                }
            } else if (operation == 1) {
                result = firstNumber * secondNumber;
                if (result > randomNumberGenerated) {
                    msg = ("Number is Lower than " + firstNumber + " * " + secondNumber);
                } else if (result < randomNumberGenerated) {
                    msg = ("Number is Greater than " + firstNumber + " * " + secondNumber);
                }
            }
        } else if (options == 1) {
            if (randomNumberGenerated % 2 == 0) {
                msg = ("Number is Even");
            } else {
                msg = ("Number is Odd");
            }
        } else if (options == 2) {
            if (randomNumberGenerated > 10) {
                int numberBreakDown = randomNumberGenerated;
                String numberBreakDownString = Integer.toString(numberBreakDown);
                char firstDigitChar = numberBreakDownString.charAt(0);
                char secondDigitChar = numberBreakDownString.charAt(1);
                int firstDigitInt = Character.getNumericValue(firstDigitChar);
                int secondDigitInt = Character.getNumericValue(secondDigitChar);
                int result;
                Random dr = new Random();
                int operation = dr.nextInt(1);
                if (operation == 0) {
                    result = firstDigitInt + secondDigitInt;
                    msg = ("Add digits to get " + result);
                } else if (operation == 1) {
                    result = firstDigitInt + secondDigitInt;
                    msg = ("Multiply digits to get " + result);
                }
            }
        } else if (options == 3) {
            if ((randomNumberGenerated <= 10) && (randomNumberGenerated >= (setDifficulty(level) - 10))) {
                if (game_playerInput < randomNumberGenerated) {
                    msg = ("Try a Number Higher than " + game_playerInput);
                } else if (game_playerInput > randomNumberGenerated) {
                    msg = ("Try a number Lower than " + game_playerInput);
                }
            } else {
                int UpperBound = randomNumberGenerated + 10;
                int LowerBound = randomNumberGenerated - 10;
                msg = ("Number is between " + LowerBound + " and " + UpperBound);
            }
        } else if (options == 4) {
            if ((randomNumberGenerated < (game_playerInput - 5)) && (randomNumberGenerated > (game_playerInput + 5))) {
                if (game_playerInput > randomNumberGenerated) {
                    msg = ("Number is Not " + (game_playerInput - 5));
                } else if (game_playerInput < randomNumberGenerated) {
                    msg = ("Number is not " + (game_playerInput + 5));
                }
            }
        } else if (options == 5) {
            int numberBreakDown = randomNumberGenerated;
            String numberBreakDownString = Integer.toString(numberBreakDown);
            char firstDigitChar = numberBreakDownString.charAt(0);
            char secondDigitChar = numberBreakDownString.charAt(1);
            int firstDigitInt = Character.getNumericValue(firstDigitChar);
            int secondDigitInt = Character.getNumericValue(secondDigitChar);
            Random srn = new Random();

            if (randomNumberGenerated <= 10) {
                if (randomNumberGenerated % 2 == 0) {
                    msg = ("Number is Even");
                } else {
                    msg = ("Number is Odd");
                }
            } else {
                int option = srn.nextInt(1);
                if (option == 1) {
                    if (firstDigitInt == 0) {
                        msg = ("One of the Digits has the same shape as an Alphabetical Letter");
                    } else if (firstDigitInt == 1) {
                        msg = ("My number cannot be Divisible by Any number");
                    } else if (firstDigitInt == 2) {
                        msg = ("One of My Digits results in an even number every time you add it to itself");
                    } else if (firstDigitInt == 3) {
                        msg = ("One of the Digits Is the same number as the Blades on a Fan");
                    } else if (firstDigitInt == 4) {
                        msg = ("One of the Digits is the sum of 2 numbers \n and \n " +
                                "also the result of the multiplication of the same 2 numbers ");
                    } else if (firstDigitInt == 5) {
                        msg = ("One of the Digits is Only Divisible by 1 and itself");
                    } else if (firstDigitInt == 6) {
                        msg = ("One of the Digits is the Number of wheels on 3 Bicycles");
                    } else if (firstDigitInt == 7) {
                        msg = ("One of the Digits is Even after a Letter is removed");
                    } else if (firstDigitInt == 8) {
                        msg = ("One of the Digits is a result of 2x + 4");
                    } else if (firstDigitInt == 9) {
                        msg = ("One of the Digits is Just a number turned Upside down");
                    }
                } else if (option == 0) {
                    if (secondDigitInt < firstDigitInt) {
                        msg = ("First Digit is Greater than Second Digit");
                    } else if (secondDigitInt > firstDigitInt) {
                        msg = ("Second Digit is Greater than Second Number");
                    }
                }
            }

        }

    }


    private void setHintVisible() {
        if (numberOfTries >= 3) {
            hint_button.setVisibility(View.VISIBLE);
        } else {
            hint_button.setVisibility(View.INVISIBLE);
        }
    }

    private void setViewsInvisible() {
        main_text.setVisibility(View.INVISIBLE);
        player_input.setVisibility(View.INVISIBLE);
        hint_button.setVisibility(View.INVISIBLE);
        submit.setVisibility(View.INVISIBLE);
        game_status.setVisibility(View.INVISIBLE);
        hint.setVisibility(View.INVISIBLE);
    }

    private void setViewsVisible() {
        main_text.setVisibility(View.VISIBLE);
        player_input.setVisibility(View.VISIBLE);
        submit.setVisibility(View.VISIBLE);
        game_status.setVisibility(View.VISIBLE);
        hint.setVisibility(View.VISIBLE);
    }

    private void updateProgressBar() {
        game.this.runOnUiThread(() -> progressBar.incrementProgressBy(1));
    }


    @Override
    public void onBackPressed() {
        createCustomDialog("exit");
    }

    private void generatingNumberAnimation() {
        game.this.runOnUiThread(() -> {
            Random gna = new Random();
            int randomNumberForAnimation = gna.nextInt(100) + 1;
            generating_number_animation_view.setText(getString(R.string.random_number_for_animation, randomNumberForAnimation));
        });

    }

    private void finishGeneratingNumberAnimation() {
        game.this.runOnUiThread(() -> {
            generating_number_animation_view.setText(getString(R.string.random_number_generation_done));
            handler = new Handler();
            {
                handler.postDelayed(() -> layout.setVisibility(View.INVISIBLE), 1000);
            }

            handler = new Handler();
            {
                handler.postDelayed(() -> {
                    setViewsVisible();
                    hint.setText(getString(R.string.hint_after_load, setDifficulty(level)));
                }, 1000);
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
            view.setOnTouchListener((v, event) -> {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        hideSoftKeyboard(game.this);
                        break;
                    case MotionEvent.ACTION_UP:
                        v.performClick();
                        break;
                }
                return false;
            });
        }

    }

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
        layout = findViewById(R.id.generating_number_animation_layout);
        hint_button = findViewById(R.id.hint_button_view);
    }


    public void createCustomDialog(String type) {
        switch (type) {
            case "loss": {
                final Dialog dialog = new Dialog(game.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.activity_custom_dialog);

                TextView titleTextView = dialog.findViewById(R.id.custom_dialog_loss_title);
                TextView messageTextView = dialog.findViewById(R.id.custom_dialog_loss_message);
                Button positiveButton = dialog.findViewById(R.id.custom_dialog_loss_button_tryAgain);
                Button negativeButton = dialog.findViewById(R.id.custom_dialog_loss_button_exit);

                titleTextView.setText(getString(R.string.loss_dialog_title));
                messageTextView.setText(getString(R.string.loss_dialog_message, randomNumberGenerated));
                positiveButton.setText(getString(R.string.loss_dialog_positive_button));
                negativeButton.setText(getString(R.string.loss_dialog_negative_button));

                positiveButton.setOnClickListener(v -> {
                    numberOfTries = 0;
                    previousPlayerInput = null;
                    Intent reloadPage = new Intent(game.this, game.class);
                    finish();
                    startActivity(reloadPage);
                    overridePendingTransition(0, 0);
                    dialog.dismiss();
                });
                negativeButton.setOnClickListener(v -> {
                    numberOfTries = 0;
                    previousPlayerInput = null;
                    Intent endGame = new Intent(game.this, main_menu.class);
                    startActivity(endGame);
                    dialog.dismiss();
                });

                dialog.show();

                break;
            }
            case "win": {
                final Dialog dialog = new Dialog(game.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.activity_custom_dialog);

                TextView titleTextView = dialog.findViewById(R.id.custom_dialog_loss_title);
                TextView messageTextView = dialog.findViewById(R.id.custom_dialog_loss_message);
                Button positiveButton = dialog.findViewById(R.id.custom_dialog_loss_button_tryAgain);
                Button negativeButton = dialog.findViewById(R.id.custom_dialog_loss_button_exit);

                titleTextView.setText(getString(R.string.win_dialog_title));
                messageTextView.setText(getString(R.string.win_dialog_message, totalPoints_accumulated));
                positiveButton.setText(getString(R.string.win_dialog_positive_button));
                negativeButton.setText(getString(R.string.win_dialog_negative_button));

                positiveButton.setOnClickListener(v -> {
                    numberOfTries = 0;
                    previousPlayerInput = null;
                    Intent reloadPage = new Intent(game.this, game.class);
                    finish();
                    startActivity(reloadPage);
                    overridePendingTransition(0, 0);
                    dialog.dismiss();
                });
                negativeButton.setOnClickListener(v -> {
                    numberOfTries = 0;
                    previousPlayerInput = null;
                    Intent endGame = new Intent(game.this, main_menu.class);
                    startActivity(endGame);
                    dialog.dismiss();
                });

                dialog.show();

                break;
            }
            case "exit": {
                final Dialog dialog = new Dialog(game.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.activity_custom_dialog);

                TextView titleTextView = dialog.findViewById(R.id.custom_dialog_loss_title);
                TextView messageTextView = dialog.findViewById(R.id.custom_dialog_loss_message);
                Button positiveButton = dialog.findViewById(R.id.custom_dialog_loss_button_tryAgain);
                Button negativeButton = dialog.findViewById(R.id.custom_dialog_loss_button_exit);

                titleTextView.setText(getString(R.string.exit_dialog_title));
                messageTextView.setText(getString(R.string.exit_dialog_message));
                positiveButton.setText(getString(R.string.exit_dialog_positive_button));
                negativeButton.setText(getString(R.string.exit_dialog_negative_button));

                positiveButton.setOnClickListener(v -> {
                    numberOfTries = 0;
                    previousPlayerInput = null;
                    dialog.dismiss();
                });
                negativeButton.setOnClickListener(v -> {
                    SharedPreferences preference = getSharedPreferences("PREF", 0);
                    SharedPreferences.Editor editor = preference.edit();
                    editor.putInt("total_points", totalPoints_accumulated);
                    editor.apply();

                    Intent gotoScoresPage = new Intent(game.this, scores.class);
                    gotoScoresPage.putExtra("activity","main_menu");
                    finish();
                    startActivity(gotoScoresPage);
                    overridePendingTransition(0, 0);
                    dialog.dismiss();
                });

                dialog.show();

                break;
            }
            case "hint": {
                final Dialog dialog = new Dialog(game.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.activity_custom_dialog);

                TextView titleTextView = dialog.findViewById(R.id.custom_dialog_loss_title);
                TextView messageTextView = dialog.findViewById(R.id.custom_dialog_loss_message);
                Button positiveButton = dialog.findViewById(R.id.custom_dialog_loss_button_tryAgain);
                Button negativeButton = dialog.findViewById(R.id.custom_dialog_loss_button_exit);

                titleTextView.setText(getString(R.string.hint_dialog_title));
                messageTextView.setText(msg);
                positiveButton.setText(getString(R.string.hint_dialog_button));
                negativeButton.setVisibility(View.GONE);

                positiveButton.setOnClickListener(v -> dialog.dismiss());
                dialog.show();

                break;
            }
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    public void mainAlgorithm() {
        numberOfTries++;

        System.out.println("Correct Answer : " + randomNumberGenerated);
        String playerInput_string = player_input.getText().toString();
        player_input.setText("");


        if ((previousPlayerInput == null) || (!previousPlayerInput.equals(playerInput_string))) {
            try {
                previousPlayerInput = playerInput_string;
                int playerInput = Integer.parseInt(playerInput_string);
                if (playerInput > setDifficulty(level)) {
                    hint.setText(getString(R.string.hint_after_load));
                    numberOfTries = numberOfTries - 1;
                } else {
                    if (playerInput == randomNumberGenerated) {
                        System.out.println("Congratulations! You Guess the Correct Answer");
                        player_input.setBackgroundColor(getColor(R.color.green));
                        totalPoints_accumulated = totalPoints_accumulated + 20;
                        level = level + 1;
                        System.out.println("Total Points : " + totalPoints_accumulated);
                        createCustomDialog("win");
                    } else {
                        if (playerInput < randomNumberGenerated) {
                            hint.setText(getString(R.string.game_hint_higher, playerInput_string));
                        } else {
                            hint.setText(getString(R.string.game_hint_lower, playerInput_string));

                        }
                        setHint(playerInput);
                        tries.setText(getString(R.string.game_number_of_tries, numberOfTries));
                        player_input.setBackgroundColor(getColor(R.color.red));
                        player_input.requestFocus();
                        showSoftKeybaord(game.this);
                    }

                }

            } catch (NumberFormatException e) {
                player_input.setError("Input a Number between 0 - 9");
                player_input.requestFocus();
                showSoftKeybaord(game.this);
                numberOfTries = numberOfTries - 1;
                previousPlayerInput = " ";
            }
        } else {
            hint.setText(getString(R.string.hint_warning));
            numberOfTries = numberOfTries - 1;
            tries.setText(getString(R.string.game_number_of_tries, numberOfTries));
        }
        if (level <= 50) {
            limit = 5;
        } else if (level <= 60) {
            limit = 6;
        } else if (level <= 100) {
            limit = 7;
        }
        if (numberOfTries == limit) {
            System.out.println("GAME OVER!, Correct Number was " + randomNumberGenerated);
            createCustomDialog("loss");
        }

    }
}



