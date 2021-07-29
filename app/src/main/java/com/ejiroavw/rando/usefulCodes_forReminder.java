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

    /*    <TableLayout
        android:id="@+id/game_status_view_1"
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:layout_marginLeft="20dp"
        android:layout_marginTop="30dp"
        android:layout_marginRight="20dp"

        >

        <TableRow
            android:layout_width="match_parent"
            android:layout_weight="1">

            <TextView
                android:id="@+id/game_level_view_1"
                android:layout_width="wrap_content"
                android:layout_height="match_parent"
                android:layout_column="0"
                android:background="@drawable/ic_custom_button_background"
                android:fontFamily="@font/consola"
                android:gravity="center"
                android:paddingStart="20dp"
                android:paddingEnd="20dp"
                android:text="@string/level"
                android:textColor="@color/text_color"
                android:textSize="11sp" />

            <TextView
                android:id="@+id/game_numberOfTries_view_1"
                android:layout_width="wrap_content"
                android:layout_height="match_parent"
                android:layout_column="1"
                android:background="@drawable/ic_custom_button_background"
                android:fontFamily="@font/consola"
                android:gravity="center"
                android:paddingStart="20dp"
                android:paddingEnd="20dp"
                android:text="@string/game_number_of_tries"
                android:textColor="@color/text_color"
                android:textSize="11sp" />

            <TextView
                android:id="@+id/game_total_points_view_1"
                android:layout_width="wrap_content"
                android:layout_height="match_parent"
                android:layout_column="2"
                android:background="@drawable/ic_custom_button_background"
                android:fontFamily="@font/consola"
                android:gravity="center"
                android:paddingStart="20dp"
                android:paddingEnd="20dp"
                android:text="@string/total_points"
                android:textColor="@color/text_color"
                android:textSize="11sp" />
        </TableRow>



    </TableLayout>*/

       /* private void hintType(int playerInput, int randomNumberGenerated){
        int lowerBound, higherBound, firstDigit, secondDigit, result ,DigitMultiplicationBound, arithmeticOperation;
        int previousHint = Integer.parseInt(null);
        int hintType = 0;
        Random htr = new Random();

        arithmeticOperation = htr.nextInt(1);
        firstDigit = htr.nextInt(8)+ 2;
        secondDigit = htr.nextInt(8)+ 2;
        lowerBound = setDifficulty(level) - 10;
        higherBound = setDifficulty(level) + 10;
        DigitMultiplicationBound = randomNumberGenerated/10;

        if (level <= 10){
            if (numberOfTries == 3){
                hintType = 2;
            }else{
                hintType = 0;
            }
        }else if((level > 10) && (level <= 20)){
            if (numberOfTries == 1){
                hintType = 0;
            }else if(numberOfTries == 2){
                hintType = 2;
            }else if(numberOfTries == 3){
                hintType = 1;
            }else if(numberOfTries == 4){
                hintType = 0;
            }
            else if(numberOfTries == 5){
                hintType = 4;
            }

        }else if(level > 20){
            if (numberOfTries == 1){
                hintType = 0;
            }else{
                hintType = htr.nextInt(5)+1;
            }
        }

        if (previousHint == hintType){
            if (hintType == 1){
                hintType = hintType + 1;
            }else if (hintType == 5){
                hintType = hintType - 1;
            }
        }

        switch (hintType){
            case 0: if (playerInput < randomNumberGenerated){
                     hint.setText("Try A Number Higher than " + playerInput);
                    }else if(playerInput > randomNumberGenerated){
                     hint.setText("Try a Number Lower " + playerInput);
                    }
            break;

            case 1:
                    System.out.println("firstDigit" + firstDigit);
                    System.out.println("secondDigit"+secondDigit);
                    System.out.println("DMB" + DigitMultiplicationBound);
                    switch (arithmeticOperation) {
                        case 0:
                            result = firstDigit + secondDigit;
                            if (randomNumberGenerated < result) {
                                hint.setText("Number is Lower than " + firstDigit + " + " + secondDigit);
                            } else if (randomNumberGenerated > result) {
                                hint.setText("Number is Higher than " + firstDigit + " + " + secondDigit);
                            }
                            break;
                        case 1:
                            result = firstDigit * DigitMultiplicationBound;
                            int numberformat = htr.nextInt(2) + 1;
                            if (randomNumberGenerated < result) {
                                if (numberformat == 1) {
                                    hint.setText("Number is Lower than " + firstDigit + " * " + DigitMultiplicationBound);
                                } else if (numberformat == 2) {
                                    hint.setText("Number is Lower than " + DigitMultiplicationBound + " * " + firstDigit);
                                }

                            } else if (randomNumberGenerated > result) {
                                if (numberformat == 1) {
                                    hint.setText("Number is Higher than " + firstDigit + " * " + DigitMultiplicationBound);
                                } else if (numberformat == 2) {
                                    hint.setText("Number is Higher than " + DigitMultiplicationBound + " * " + firstDigit);
                                }
                            }
                            break;
                    }
            break;

            case 2: int isOddorEven = randomNumberGenerated % 2;
                    if (isOddorEven == 0){
                        hint.setText("Number is Even");
                    }else if (isOddorEven == 1){
                        hint.setText("Number is Odd");
                    }
            break;

            case 3:  lowerBound = setDifficulty(level) - 10;
                     higherBound = setDifficulty(level) + 10;
                    hint.setText("Number is between "+ lowerBound+" and "+higherBound);
            break;

            case 4: String randomNumberGenerated_string = Integer.toString(randomNumberGenerated);
                    Integer firstDigitOfRandomNumber = new Integer(randomNumberGenerated_string.charAt(0));
                    Integer secondDigitOfRandomNumber = new Integer(randomNumberGenerated_string.charAt(1));
                arithmeticOperation = htr.nextInt(4)+1;
                    if (arithmeticOperation == 1){
                        result = firstDigitOfRandomNumber + secondDigitOfRandomNumber;
                        hint.setText("Add digits together to Get " + result);
                    }else if (arithmeticOperation == 2){
                        result = firstDigitOfRandomNumber - secondDigitOfRandomNumber;
                        hint.setText("Subtract digits to Get " + result);
                    }else if (arithmeticOperation  == 3){
                        result = firstDigitOfRandomNumber * secondDigitOfRandomNumber;
                        hint.setText("Multiply Digits to Get " + result);
                    }else if (arithmeticOperation == 4){
                        result = firstDigitOfRandomNumber / secondDigitOfRandomNumber;
                        hint.setText("Divide digits to get " + result);
                    }
            break;

            case 5: int otherNumber = htr.nextInt(higherBound - lowerBound+ 1)+lowerBound;
                    if (otherNumber == randomNumberGenerated){
                        otherNumber = otherNumber+1;
                        hint.setText("Number is not "+otherNumber);
                    }else{
                        hint.setText("Number is not "+otherNumber);
                    }
            break;

            default:
                hint.setText("Number is Between 0 and "+setDifficulty(level));
        }

        previousHint = hintType;
        System.out.println("hintType"+hintType);
        System.out.println("arithmeticOperation"+arithmeticOperation);
    }*/


}
