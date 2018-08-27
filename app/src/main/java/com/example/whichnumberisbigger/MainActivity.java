package com.example.whichnumberisbigger;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //instance variable
    //access programmatically
    private Button buttonLeft;
    private Button buttonRight;
    private TextView textViewscore;
    private int score;
    private int leftNum;
    private int rightNum;
    private int genNumber;

    public static final int MAX_NUM = 1000;
    public static final int MIN_NUM = 1;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireWidgets();
        randomizeAndUpdateDisplay();
    }

    private void wireWidgets() {
        buttonLeft = findViewById(R.id.button_main_left);
        buttonRight = findViewById(R.id.button_main_right);
        textViewscore = findViewById(R.id.textview_main_score);

    }

    private void onLeftClick(View view) {
        String message;
        if (leftNum > rightNum) {
            score++;
            message = "Correct!";
        } else {
            score--;
            message = "Less Correct!";
        }



    randomizeAndUpdateDisplay();
   Toast.makeText(this,message,Toast.LENGTH_SHORT).

    show();

}

    private void onRightClick(View view){

        String message;
        if(rightNum > leftNum) {
            score++;
            message = "Correct!";
        }
        else{

                score--;
                message = "Less Correct!";
            }

        }

    private void checkAnswer(boolean leftPressed){
        String message;
        if((leftNum > rightNum && !leftPressed) ||
            rightNum > leftNum && !leftPressed){
            score ++;
            message= "correct!";
        }
        else{
            score--;
            message = "Less Correct!";
             }
        }


    private void randomizeAndUpdateDisplay() {
        // TODO set the score
        String scoreString = getResources().getString(R.string.main_score);
        textViewscore.setText(scoreString + score);
        

        //TODO randomize number
        randomizeNumber();
        buttonLeft.setText(String.valueOf(leftNum));
        buttonRight.setText(String.valueOf(rightNum));
        //TODO set the button
    }
    private int genNumber(){
        int range = MAX_NUM - MAX_NUM +1;
        return MAX_NUM + (int )Math.random() * range;
    }

    private void randomizeNumber() {
        // generate a random number for the left
        leftNum = genNumber();
        rightNum = genNumber();

        //generate a random for the right but make sure it doesn't
        while(leftNum == rightNum) {
            rightNum = genNumber();
        }
    }
}
