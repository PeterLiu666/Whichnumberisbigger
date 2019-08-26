package com.example.whichnumberisbigger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity
{
    private Button buttonLeft;
    private Button buttonRight;
    private TextView textViewScore;
    private BiggerNumberGame game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireWidgets();
        setListeners();
        // Construct the game
        // Initialize the game
        game = new BiggerNumberGame(0, 1000000);
        game.generateRandomNumber();
        updateDisplay();





    }

    private void updateDisplay()
    {

        buttonLeft.setText(String.valueOf(game.getNum1()));
        buttonRight.setText(String.valueOf(game.getNum2()));
        textViewScore.setText(String.valueOf(game.getScore()));

    }

    private void setListeners()
    {
        // creating an Anonymous Inner Class that implements View.OnClickListener
        // overriding the one abstract method onClick
        buttonLeft.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                int answer = Integer.parseInt(buttonLeft.getText().toString());
                String message = game.checkAnswer(answer);
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                game.generateRandomNumber();
                updateDisplay();


            }

        });

        buttonRight.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                int answer = Integer.parseInt(buttonRight.getText().toString());
                String message = game.checkAnswer(answer);
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                game.generateRandomNumber();
                updateDisplay();


            }

        });

        textViewScore.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(MainActivity.this, game.getScore(), Toast.LENGTH_SHORT).show();


            }

        });





    }

    private void wireWidgets()
    {
        buttonLeft = findViewById(R.id.button_main_left);
        buttonRight = findViewById(R.id.button_main_right);
        textViewScore = findViewById(R.id.textView_main_score);
    }


}
