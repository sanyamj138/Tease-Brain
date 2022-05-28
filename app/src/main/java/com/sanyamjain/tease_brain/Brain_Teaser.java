package com.sanyamjain.tease_brain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class Brain_Teaser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brain_teaser);

        Button button;
        ArrayList<Integer> answers = new ArrayList<Integer>();
        TextView correct;
        TextView score;
        Button button0;
        Button button1;
        Button button2;
        Button button3;
        TextView question;
        TextView time;
        Button start;
        Button playAgain;
        ConstraintLayout constraintChange;

        int locationCorrect;
        int points = 0;
        int numberOfQuestions = 0;

        public void start(View view)
        {
            button.setVisibility(View.INVISIBLE);
            playAgain(findViewById(R.id.time));
            constraintChange.setVisibility(View.VISIBLE);
        }

        public void playAgain(View view)
        {
            points = 0;
            numberOfQuestions = 0;
            time.setText("30s");
            score.setText(Integer.toString(points) + "/" + Integer.toString(numberOfQuestions));
            newQuestion();
            playAgain.setVisibility(View.INVISIBLE);
            correct.setText("");

            new CountDownTimer(30100, 1000) {
                @Override
                public void onTick(long l) {
                    time.setText(String.valueOf((l / 1000) + "s"));
                }

                @Override
                public void onFinish() {
                    correct.setText("Done!");
                    playAgain.setVisibility(View.VISIBLE);
                }
            }.start();
        }

        public void answer(View view)
        {
            if(Integer.toString(locationCorrect).equals(view.getTag().toString())) {
                correct.setText("Correct!");
                points++;
            }
            else {
                correct.setText("Wrong!");
            }
            numberOfQuestions++;
            score.setText(Integer.toString(points) + "/" + Integer.toString(numberOfQuestions));
            newQuestion();
        }

        public void newQuestion()
        {
            Random random = new Random();

            int a = random.nextInt(49);
            int b = random.nextInt(51);

            question.setText(Integer.toString(a) + " + " + Integer.toString(b));

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

            button0.setText(Integer.toString(answers.get(0)));
            button1.setText(Integer.toString(answers.get(1)));
            button2.setText(Integer.toString(answers.get(2)));
            button3.setText(Integer.toString(answers.get(3)));
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            question = findViewById(R.id.question);
            button0 = findViewById(R.id.button2);
            button1 = findViewById(R.id.button3);
            button2 = findViewById(R.id.button4);
            button3 = findViewById(R.id.button5);
            correct = findViewById(R.id.correct);
            score = findViewById(R.id.score);
            button = findViewById(R.id.start);
            time = findViewById(R.id.time);
            playAgain = findViewById(R.id.button6);
            start = findViewById(R.id.start);
            constraintChange = findViewById(R.id.constraintChange);

            start.setVisibility(View.VISIBLE);
            constraintChange.setVisibility(View.INVISIBLE);
    }
}