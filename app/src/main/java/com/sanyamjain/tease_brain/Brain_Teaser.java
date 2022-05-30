package com.sanyamjain.tease_brain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class Brain_Teaser extends AppCompatActivity {

    ArrayList<Integer> answers = new ArrayList<Integer>();
//    TextView Correct;
    TextView Score;
    Button Option1;
    Button Option2;
    Button Option3;
    Button Option4;
    TextView Question;
    TextView Timer;
    Button PlayAgain;

    int locationCorrect;
    int points = 0;
    int numberOfQuestions = 0;

    public void playGame(View view)
    {
        points = 0;
        numberOfQuestions = 0;
        Timer.setText("30s");
        Score.setText(Integer.toString(points) + "/" + Integer.toString(numberOfQuestions));
        newQuestion();
        PlayAgain.setVisibility(View.INVISIBLE);
        // Correct.setText("");

        new CountDownTimer(30100, 1000) {
            @Override
            public void onTick(long l) {
                Timer.setText(String.valueOf((l / 1000) + "s"));
            }

            @Override
            public void onFinish() {
                // Correct.setText("Done!");
                PlayAgain.setVisibility(View.VISIBLE);
            }
        }.start();
    }

    public void answer(View view)
    {
//        if(Integer.toString(locationCorrect).equals(view.getTag().toString())) {
//            // Correct.setText("Correct!");
//            points++;
//        }
//        else {
//             Correct.setText("Wrong!");
//        }

        numberOfQuestions++;
         Score.setText(Integer.toString(points) + "/" + Integer.toString(numberOfQuestions));
        newQuestion();
    }

    public void newQuestion()
    {
        Random random = new Random();

        int a = random.nextInt(49);
        int b = random.nextInt(51);

        Question.setText(Integer.toString(a) + " + " + Integer.toString(b));

        locationCorrect = random.nextInt(4);

        answers.clear();

        for(int i = 0; i < 4; i++)
        {
            if(i == locationCorrect) {
                answers.add(a+b);
            } else {
                int wrongAnswer = random.nextInt(99);
                while (wrongAnswer == a + b) {
                    wrongAnswer = random.nextInt(99);
                }
                answers.add(wrongAnswer);
            }
        }

        Option1.setText(Integer.toString(answers.get(0)));
        Option2.setText(Integer.toString(answers.get(1)));
        Option3.setText(Integer.toString(answers.get(2)));
        Option4.setText(Integer.toString(answers.get(3)));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brain_teaser);

        Question = findViewById(R.id.Question);
        Option1 = findViewById(R.id.Option1);
        Option2 = findViewById(R.id.Option2);
        Option3 = findViewById(R.id.Option3);
        Option4 = findViewById(R.id.Option4);
//        Correct = findViewById(R.id.Correct);
        Score = findViewById(R.id.Score);
        Timer = findViewById(R.id.Timer);
        PlayAgain = findViewById(R.id.PlayAgain);

        playGame(findViewById(R.id.Timer));
    }

}