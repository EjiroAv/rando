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
/*if (level <= 20) {
            if (game_playerInput < randomNumberGenerated) {
                hint.setText("Try a Number Higher than " + game_playerInput);
            } else if (game_playerInput > randomNumberGenerated) {
                hint.setText("Try a number Lower than " + game_playerInput);
            }
        } else if ((level >= 21) && (level <= 30)) {
            if (numberOfTries == 3) {
                if (randomNumberGenerated % 2 == 0) {
                    hint.setText("Number is Even");
                } else {
                    hint.setText("Number is Odd");
                }
            } else {
                if (game_playerInput < randomNumberGenerated) {
                    hint.setText("Try a Number Higher than " + game_playerInput);
                } else if (game_playerInput > randomNumberGenerated) {
                    hint.setText("Try a number Lower than " + game_playerInput);
                }
            }
        } else if ((level >= 31) && (level <= 40)) {
            if (numberOfTries == 2) {
                Random adr = new Random();
                int operation = adr.nextInt(1);
                int firstNumber = adr.nextInt(20) + 1;
                int secondNumber = adr.nextInt(20) + 1;
                int result;

                if (operation == 0) {
                    result = firstNumber + secondNumber;
                    if (result > randomNumberGenerated) {
                        hint.setText("Number is Lower than " + firstNumber + " + " + secondNumber);
                    } else if (result < randomNumberGenerated) {
                        hint.setText("Number is Greater than " + firstNumber + " + " + secondNumber);
                    }
                } else if (operation == 1) {
                    result = firstNumber * secondNumber;
                    if (result > randomNumberGenerated) {
                        hint.setText("Number is Lower than " + firstNumber + " * " + secondNumber);
                    } else if (result < randomNumberGenerated) {
                        hint.setText("Number is Greater than " + firstNumber + " * " + secondNumber);
                    }
                }
            } else if (numberOfTries == 3) {
                if (randomNumberGenerated % 2 == 0) {
                    hint.setText("Number is Even");
                } else {
                    hint.setText("Number is Odd");
                }
            } else if (numberOfTries == 4) {
                if (randomNumberGenerated > 10) {
                    int numberBreakDown = randomNumberGenerated;
                    String numberBreakDownString = Integer.toString(numberBreakDown);
                    char firstDigitChar = numberBreakDownString.charAt(0);
                    char secondDigitChar = numberBreakDownString.charAt(1);
                    Integer firstDigitInt = new Integer(Character.getNumericValue(firstDigitChar));
                    Integer secondDigitInt = new Integer(Character.getNumericValue(secondDigitChar));
                    int result;
                    Random dr = new Random();
                    int operation = dr.nextInt(1);
                    if (operation == 0) {
                        result = firstDigitInt + secondDigitInt;
                        hint.setText("Add digits to get " + result);
                    } else if (operation == 1) {
                        result = firstDigitInt + secondDigitInt;
                        hint.setText("Multiply digits to get " + result);
                    }
                }
            } else {
                if (game_playerInput < randomNumberGenerated) {
                    hint.setText("Try a Number Higher than " + game_playerInput);
                } else if (game_playerInput > randomNumberGenerated) {
                    hint.setText("Try a number Lower than " + game_playerInput);
                }
            }
        } else if ((level >= 41) && (level <= 50)) {
            if (numberOfTries == 2) {
                Random adr = new Random();
                int operation = adr.nextInt(1);
                int firstNumber = adr.nextInt(20) + 1;
                int secondNumber = adr.nextInt(20) + 1;
                int result;

                if (operation == 0) {
                    result = firstNumber + secondNumber;
                    if (result > randomNumberGenerated) {
                        hint.setText("Number is Lower than " + firstNumber + " + " + secondNumber);
                    } else if (result < randomNumberGenerated) {
                        hint.setText("Number is Greater than " + firstNumber + " + " + secondNumber);
                    }
                } else if (operation == 1) {
                    result = firstNumber * secondNumber;
                    if (result > randomNumberGenerated) {
                        hint.setText("Number is Lower than " + firstNumber + " * " + secondNumber);
                    } else if (result < randomNumberGenerated) {
                        hint.setText("Number is Greater than " + firstNumber + " * " + secondNumber);
                    }
                }
            } else if (numberOfTries == 3) {
                if (randomNumberGenerated % 2 == 0) {
                    hint.setText("Number is Even");
                } else {
                    hint.setText("Number is Odd");
                }
            } else if (numberOfTries == 4) {
                if (randomNumberGenerated > 10) {
                    int numberBreakDown = randomNumberGenerated;
                    String numberBreakDownString = Integer.toString(numberBreakDown);
                    char firstDigitChar = numberBreakDownString.charAt(0);
                    char secondDigitChar = numberBreakDownString.charAt(1);
                    Integer firstDigitInt = new Integer(Character.getNumericValue(firstDigitChar));
                    Integer secondDigitInt = new Integer(Character.getNumericValue(secondDigitChar));
                    int result;
                    Random dr = new Random();
                    int operation = dr.nextInt(1);
                    if (operation == 0) {
                        result = firstDigitInt + secondDigitInt;
                        hint.setText("Add digits to get " + result);
                    } else if (operation == 1) {
                        result = firstDigitInt + secondDigitInt;
                        hint.setText("Multiply digits to get " + result);
                    }
                }
            } else if (numberOfTries == 5) {
                if ((randomNumberGenerated <= 10) && (randomNumberGenerated >= (setDifficulty(level) - 10))) {
                    if (game_playerInput < randomNumberGenerated) {
                        hint.setText("Try a Number Higher than " + game_playerInput);
                    } else if (game_playerInput > randomNumberGenerated) {
                        hint.setText("Try a number Lower than " + game_playerInput);
                    }
                } else {
                    int UpperBound = randomNumberGenerated + 10;
                    int LowerBound = randomNumberGenerated - 10;
                    hint.setText("Number is between " + LowerBound + " and " + UpperBound);
                }
            }
        } else if ((level >= 51) && (level <= 60)) {
            if (numberOfTries == 2) {
                Random adr = new Random();
                int operation = adr.nextInt(1);
                int firstNumber = adr.nextInt(20) + 1;
                int secondNumber = adr.nextInt(20) + 1;
                int result;

                if (operation == 0) {
                    result = firstNumber + secondNumber;
                    if (result > randomNumberGenerated) {
                        hint.setText("Number is Lower than " + firstNumber + " + " + secondNumber);
                    } else if (result < randomNumberGenerated) {
                        hint.setText("Number is Greater than " + firstNumber + " + " + secondNumber);
                    }
                } else if (operation == 1) {
                    result = firstNumber * secondNumber;
                    if (result > randomNumberGenerated) {
                        hint.setText("Number is Lower than " + firstNumber + " * " + secondNumber);
                    } else if (result < randomNumberGenerated) {
                        hint.setText("Number is Greater than " + firstNumber + " * " + secondNumber);
                    }
                }
            } else if (numberOfTries == 3) {
                if (randomNumberGenerated % 2 == 0) {
                    hint.setText("Number is Even");
                } else {
                    hint.setText("Number is Odd");
                }
            } else if (numberOfTries == 4) {
                if (randomNumberGenerated > 10) {
                    int numberBreakDown = randomNumberGenerated;
                    String numberBreakDownString = Integer.toString(numberBreakDown);
                    char firstDigitChar = numberBreakDownString.charAt(0);
                    char secondDigitChar = numberBreakDownString.charAt(1);
                    Integer firstDigitInt = new Integer(Character.getNumericValue(firstDigitChar));
                    Integer secondDigitInt = new Integer(Character.getNumericValue(secondDigitChar));
                    int result;
                    Random dr = new Random();
                    int operation = dr.nextInt(1);
                    if (operation == 0) {
                        result = firstDigitInt + secondDigitInt;
                        hint.setText("Add digits to get " + result);
                    } else if (operation == 1) {
                        result = firstDigitInt + secondDigitInt;
                        hint.setText("Multiply digits to get " + result);
                    }
                }
            } else if (numberOfTries == 5) {
                if ((randomNumberGenerated <= 10) && (randomNumberGenerated >= (setDifficulty(level) - 10))) {
                    if (game_playerInput < randomNumberGenerated) {
                        hint.setText("Try a Number Higher than " + game_playerInput);
                    } else if (game_playerInput > randomNumberGenerated) {
                        hint.setText("Try a number Lower than " + game_playerInput);
                    }
                } else {
                    int UpperBound = randomNumberGenerated + 10;
                    int LowerBound = randomNumberGenerated - 10;
                    hint.setText("Number is between " + LowerBound + " and " + UpperBound);
                }
            } else if (numberOfTries == 6) {
                if ((randomNumberGenerated < (game_playerInput - 5)) && (randomNumberGenerated > (game_playerInput + 5))) {
                    Random orn = new Random();
                    if (game_playerInput > randomNumberGenerated) {
                        hint.setText("Number is Not " + (game_playerInput - 5));
                    } else if (game_playerInput < randomNumberGenerated) {
                        hint.setText("Number is not " + (game_playerInput + 5));
                    }
                }
            }

        } else if ((level >= 61) && (level <= 100)) {
            if (numberOfTries == 2) {
                Random adr = new Random();
                int operation = adr.nextInt(1);
                int firstNumber = adr.nextInt(20) + 1;
                int secondNumber = adr.nextInt(20) + 1;
                int result;

                if (operation == 0) {
                    result = firstNumber + secondNumber;
                    if (result > randomNumberGenerated) {
                        hint.setText("Number is Lower than " + firstNumber + " + " + secondNumber);
                    } else if (result < randomNumberGenerated) {
                        hint.setText("Number is Greater than " + firstNumber + " + " + secondNumber);
                    }
                } else if (operation == 1) {
                    result = firstNumber * secondNumber;
                    if (result > randomNumberGenerated) {
                        hint.setText("Number is Lower than " + firstNumber + " * " + secondNumber);
                    } else if (result < randomNumberGenerated) {
                        hint.setText("Number is Greater than " + firstNumber + " * " + secondNumber);
                    }
                }
            } else if (numberOfTries == 3) {
                if (randomNumberGenerated % 2 == 0) {
                    hint.setText("Number is Even");
                } else {
                    hint.setText("Number is Odd");
                }
            } else if (numberOfTries == 4) {
                if (randomNumberGenerated > 10) {
                    int numberBreakDown = randomNumberGenerated;
                    String numberBreakDownString = Integer.toString(numberBreakDown);
                    char firstDigitChar = numberBreakDownString.charAt(0);
                    char secondDigitChar = numberBreakDownString.charAt(1);
                    Integer firstDigitInt = new Integer(Character.getNumericValue(firstDigitChar));
                    Integer secondDigitInt = new Integer(Character.getNumericValue(secondDigitChar));
                    int result;
                    Random dr = new Random();
                    int operation = dr.nextInt(1);
                    if (operation == 0) {
                        result = firstDigitInt + secondDigitInt;
                        hint.setText("Add digits to get " + result);
                    } else if (operation == 1) {
                        result = firstDigitInt + secondDigitInt;
                        hint.setText("Multiply digits to get " + result);
                    }
                }
            } else if (numberOfTries == 5) {
                if ((randomNumberGenerated <= 10) && (randomNumberGenerated >= (setDifficulty(level) - 10))) {
                    if (game_playerInput < randomNumberGenerated) {
                        hint.setText("Try a Number Higher than " + game_playerInput);
                    } else if (game_playerInput > randomNumberGenerated) {
                        hint.setText("Try a number Lower than " + game_playerInput);
                    }
                } else {
                    int UpperBound = randomNumberGenerated + 10;
                    int LowerBound = randomNumberGenerated - 10;
                    hint.setText("Number is between " + LowerBound + " and " + UpperBound);
                }
            } else if (numberOfTries == 6) {
                if ((randomNumberGenerated < (game_playerInput - 5)) && (randomNumberGenerated > (game_playerInput + 5))) {
                    Random orn = new Random();
                    if (game_playerInput > randomNumberGenerated) {
                        hint.setText("Number is Not " + (game_playerInput - 5));
                    } else if (game_playerInput < randomNumberGenerated) {
                        hint.setText("Number is not " + (game_playerInput + 5));
                    }
                }
            } else if (numberOfTries == 7) {
                int numberBreakDown = randomNumberGenerated;
                String numberBreakDownString = Integer.toString(numberBreakDown);
                char firstDigitChar = numberBreakDownString.charAt(0);
                char secondDigitChar = numberBreakDownString.charAt(1);
                Integer firstDigitInt = new Integer(Character.getNumericValue(firstDigitChar));
                Integer secondDigitInt = new Integer(Character.getNumericValue(secondDigitChar));
                Random srn = new Random();

                if (randomNumberGenerated <= 10) {
                    if (randomNumberGenerated % 2 == 0) {
                        hint.setText("Number is Even");
                    } else {
                        hint.setText("Number is Odd");
                    }
                } else if (randomNumberGenerated >= 11) {
                    int option = srn.nextInt(1);
                    if (option == 1) {
                        if (firstDigitInt == 0) {
                            hint.setText("One of the Digits has the same shape as an Alphabetical Letter");
                        } else if (firstDigitInt == 1) {
                            hint.setText("My number cannot be Divisible by Any number");
                        } else if (firstDigitInt == 2) {
                            hint.setText("One of My Digits results in an even number every time you add it to itself");
                        } else if (firstDigitInt == 3) {
                            hint.setText("One of the Digits Is the same number as the Blades on a Fan");
                        }else if (firstDigitInt == 4){
                            hint.setText("One of the Digits is the sum of 2 numbers \n and \n " +
                                    "also the result of the multiplication of the same 2 numbers ");
                        }else if (firstDigitInt == 5){
                            hint.setText("One of the Digits is Only Divisible by 1 and itself");
                        }else if (firstDigitInt == 6){
                            hint.setText("One of the Digits is the Number of wheels on 3 Bicycles");
                        }else if (firstDigitInt == 7){
                            hint.setText("One of the Digits is Even after a Letter is removed");
                        }else if (firstDigitInt == 8){
                            hint.setText("One of the Digits is a result of 2x + 4");
                        }else if (firstDigitInt == 9){
                            hint.setText("One of the Digits is Just a number turned Upside down");
                        }
                    }else if(option == 0){
                        if (secondDigitInt < firstDigitInt){
                            hint.setText("First Digit is Greater than Second Digit");
                        }else if (secondDigitInt > firstDigitInt){
                            hint.setText("Second Digit is Greater than Second Number");
                        }
                    }
                }

            }
        }
    */

}
