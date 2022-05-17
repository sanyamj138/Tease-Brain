package com.sanyamjain.tease_brain;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;

public class TicTacToe extends AppCompatActivity {

    TextView tapToStart;

    int activePlay = 0;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] positions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 4, 8}, {3, 4, 6}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {2, 4, 6}};
    boolean gameActive = true;

    public void tap(View view) {

        Button playAgain = findViewById(R.id.playAgain);

        tapToStart = findViewById(R.id.tapToStart);
        tapToStart.setVisibility(View.INVISIBLE);
        playAgain.setVisibility(View.VISIBLE);

        ImageView counter = (ImageView) view;

        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if(gameState[tappedCounter] == 2 && gameActive) {

            gameState[tappedCounter] = activePlay;

            if (activePlay == 0) {
                counter.setImageResource(R.drawable.cross);
                activePlay = 1;
            } else {
                counter.setImageResource(R.drawable.circles);
                activePlay = 0;
            }

            for (int[] position : positions) {
                if (gameState[position[0]] == gameState[position[1]] && gameState[position[1]] == gameState[position[2]] && gameState[position[0]] != 2) {

                    String winner = " ";

                    gameActive = false;
                    if (activePlay == 1) {
                        winner = "Team Cross";
                    } else {
                        winner = "Team Circle";
                    }

                    // button = findViewById(R.id.button);
                    TextView winnerAnnounce = (TextView) findViewById(R.id.winnerAnnounce);
                    // textView = findViewById(R.id.textView);

                    winnerAnnounce.setText(String.format("%s Win!", winner));

                    playAgain.setText("Play Again");
                    playAgain.setVisibility(View.VISIBLE);
                    winnerAnnounce.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    public void again(View view)
    {
        Button playAgain = (Button) findViewById(R.id.playAgain);
        TextView winnerAnnounce = (TextView) findViewById(R.id.winnerAnnounce);
        TextView tapToStart = (TextView) findViewById(R.id.tapToStart);

        // GridLayout gridLayout = (GridLayout) findViewById(R.id.gridOut);
        androidx.gridlayout.widget.GridLayout gridLayout = findViewById(R.id.board);

        tapToStart.setVisibility(View.VISIBLE);
        playAgain.setText("Retry");
        playAgain.setVisibility(View.INVISIBLE);
        winnerAnnounce.setVisibility(View.INVISIBLE);


        for(int i=0; i<gridLayout.getChildCount(); i++) {
            ImageView counter = (ImageView) gridLayout.getChildAt(i);
            counter.setImageDrawable(null);
        }

        Arrays.fill(gameState, 2);
        activePlay = 0;
        gameActive = true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);

    }
}