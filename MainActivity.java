package com.example.minitrial;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String[] questions = {"Ramcharitmanas was written by Maharishi Valmiki?","The President of India is Smt. Droupadi Murmu",
            "ISRO stands for Indian Space Research Office?", "MS Dhoni is the only captain to win all 3 limited overs ICC trophies?",
            "Virat Kohli is the most expensive player in the IPL Auctions?", "India have won 2 gold medals in Olymics in individual events?", "Suryakumar Yadav has the record of highest score in T20Is for India?","Current RBI governor is Mr. Shaktikanta Das?", "Kargil War happened in 1999?","There are 29 states in India?"};
    private boolean[] answers = {false,true, false, true, false, true, false,true,true,false};
    private int[] fname={R.drawable.ram,R.drawable.murmu,R.drawable.isro,R.drawable.msd,R.drawable.vk,R.drawable.neeraj,R.drawable.surya,R.drawable.rbi,R.drawable.kargil,R.drawable.india};
    private int score = 0;
    Button yes;
    Button no;
    TextView question;
    ImageView img;

    private int index= 0;
    private int iind=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);
        question = findViewById(R.id.question);
        img= findViewById(R.id.img);
        img.setImageResource(R.drawable.ram);

        question.setText(questions[index]);
        yes.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {

                // If the array is not going out of bounds
                Handler handler=new Handler();
                if (index <= questions.length - 1) {
                    // If you have given correct answer
                    if(answers[index]){
                        yes.setBackgroundColor(Color.GREEN);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                yes.setBackgroundColor(Color.BLUE);
                            }
                        }, 200);

                        score++;
                    }
                    else
                    {
                        yes.setBackgroundColor(Color.RED);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                yes.setBackgroundColor(Color.BLUE);
                            }
                        }, 200);
                    }
                    // Go to the next question
                    index++;
                    iind++;
                    if (index <= questions.length - 1) {
                        question.setText(questions[index]);
                        img.setImageResource(fname[iind]);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Your Score: "+score+" / 10", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "Restart the app to play again", Toast.LENGTH_SHORT).show();
                }
            }


        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // If the array is not going out of bounds
                if (index <= questions.length - 1) {
                    // If you have given correct answer
                    Handler handler= new Handler();
                    if(!answers[index]){
                        no.setBackgroundColor(Color.GREEN);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                no.setBackgroundColor(Color.BLUE);
                            }
                        }, 200);
                        score++;

                    }
                    else
                    {
                        no.setBackgroundColor(Color.RED);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                no.setBackgroundColor(Color.BLUE);
                            }
                        }, 200);
                    }
                    // Go to the next question
                    index++;
                    iind++;
                    if (index <= questions.length - 1) {
                        question.setText(questions[index]);
                        img.setImageResource(fname[iind]);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Your Score: "+score+" / 10", Toast.LENGTH_SHORT).show();
                    }


                }
                else{
                    Toast.makeText(MainActivity.this, "Restart the app to play again", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }



}