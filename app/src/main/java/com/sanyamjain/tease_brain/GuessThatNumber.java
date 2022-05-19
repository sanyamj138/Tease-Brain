package com.sanyamjain.tease_brain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class GuessThatNumber extends AppCompatActivity {

    Button guessButton;
    Button exitButton;
    EditText numberGuess;

    // #77004AAD

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_that_number);

        Random ran = new Random();
        int randomNumber = ran.nextInt(100);
        final int[] count = {1};
        guessButton = findViewById(R.id.guessButton);
        numberGuess = findViewById(R.id.numberGuess);
        exitButton = findViewById(R.id.exitButton);

        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int guessValue = Integer.parseInt(numberGuess.getText().toString());

                Log.i("Info", "Entered Number: " + guessValue);

                if (guessValue == randomNumber) {
                    Toast.makeText(GuessThatNumber.this, "Congratulations!", Toast.LENGTH_SHORT).show();
                    Toast.makeText(GuessThatNumber.this, "Number found in " + count[0] + " counts " , Toast.LENGTH_SHORT).show();
                    // count++;
                }
                else if (guessValue < randomNumber) {
                    Toast.makeText(GuessThatNumber.this, "Number is Quite More", Toast.LENGTH_SHORT).show();
                    // count++;
                }
                else {
                    Toast.makeText(GuessThatNumber.this, "Number is Quite Less", Toast.LENGTH_SHORT).show();
                    // count++;
                }
                count[0]++;
            }
        });

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Info", "Exiting");
                Intent GuessThatNumberIntent = new Intent(GuessThatNumber.this, HomePage.class);
                startActivity(GuessThatNumberIntent);
            }
        });
    }
}