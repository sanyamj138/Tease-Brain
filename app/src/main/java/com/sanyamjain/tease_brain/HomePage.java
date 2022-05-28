package com.sanyamjain.tease_brain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        Button ticTacToe, guessThatNumber, brainTeaser;

        ticTacToe = findViewById(R.id.ticTacToe);
        guessThatNumber = findViewById(R.id.guessThatNumber);
        brainTeaser = findViewById(R.id.brainTeaser);

        ticTacToe.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent ticTacToeIntent = new Intent(HomePage.this, TicTacToe.class);
                startActivity(ticTacToeIntent);
            }
        });

        guessThatNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent guessThatNumberIntent = new Intent(HomePage.this, GuessThatNumber.class);
                startActivity(guessThatNumberIntent);
            }
        });

        brainTeaser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent brainTeaser = new Intent(HomePage.this, Brain_Teaser.class);
                startActivity(brainTeaser);
            }
        });
    }

}