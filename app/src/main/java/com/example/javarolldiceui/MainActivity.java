package com.example.javarolldiceui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // collect data for the views

    TextView txt_score;
    ImageView die1;
    ImageView die2;
    Button btn_roll;
    Button btn_play_again;

    // declare variables
    int score = 0;
    int repeat = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_score = findViewById(R.id.score);
        die1 = findViewById(R.id.die1);
        die2 = findViewById(R.id.die2);
        btn_roll = findViewById(R.id.btn_roll);


        btn_roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (repeat <= 4 && score >= 30) {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                    alertDialog.setTitle("Success");
                    alertDialog.setMessage("You have won!!!");
                    alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(MainActivity.this, "You won", Toast.LENGTH_LONG).show();
                        }
                    });

                    alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_LONG).show();
                        }
                    });

                    alertDialog.show();
                } else if (repeat >= 4 && score < 30) {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                    alertDialog.setTitle("You Lost");
                    alertDialog.setMessage("You lost!!!");
                    alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });

                    alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });

                    alertDialog.show();
                } else {
                    // get the random values for the dice
                    int rand1 = new Random().nextInt(6) + 1;
                    score += rand1;
                    int rand2 = new Random().nextInt(6) + 1;
                    score += rand2;
                    txt_score.setText(Integer.toString(score));
                    // call the selectDieImage twice with parameters rand1 and rand2
                    selectDieImage(rand1, die1);
                    selectDieImage(rand2, die2);
                    repeat +=1;
                }
            }
        });

    }



    private void selectDieImage(int rand1, ImageView die) {
        int die_head = 1;
        switch(rand1) {
            case 1:
                die_head =  R.drawable.dice_1;
                break;
            case 2:
                die_head =  R.drawable.dice_2;
                break;
            case 3:
                die_head =  R.drawable.dice_3;
                break;
            case 4:
                die_head = R.drawable.dice_4;
                break;
            case 5:
                die_head = R.drawable.dice_5;
                break;
            case 6:
                die_head =  R.drawable.dice_6;
                break;
        }
        // set the image resource for the die1 object
        die.setImageResource(die_head);
    }
    }