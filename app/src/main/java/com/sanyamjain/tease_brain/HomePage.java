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

        Button ticTacToe, guessThatNumber, teaseBrain;

        ticTacToe = findViewById(R.id.ticTacToe);
        guessThatNumber = findViewById(R.id.guessThatNumber);
        teaseBrain = findViewById(R.id.teaseBrain);

        ticTacToe.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent ticTacToeIntent = new Intent(HomePage.this, TicTacToe.class);
                startActivity(ticTacToeIntent);
            }
        });
    }

}