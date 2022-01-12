package com.codecademy.rockpaperscissors;
// Help provided from and ideas sourced from "Programming with Professor Sluiter"
// Youtube Video: https://www.youtube.com/watch?v=YKbrbiIrjAA
// Youtube Account: https://www.youtube.com/channel/UCUSqKFDbRaaWQTaMN3r4Pbg
// Free open source Creative Commons images sourced from the following:
// https://commons.wikimedia.org/wiki/File:Rock-paper-scissors_(rock).png
// https://en.m.wikipedia.org/wiki/File:Rock-paper-scissors_(paper).png
// https://commons.wikimedia.org/wiki/File:Rock-paper-scissors_(scissors).png
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button b_rock, b_paper, b_scissors;
    TextView tv_score;
    ImageView iv_humanChoice, iv_computerChoice;
    int humanScore=0, computerScore =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_paper = (Button) findViewById(R.id.b_paper);
        b_rock = (Button) findViewById(R.id.b_rock);
        b_scissors = (Button) findViewById(R.id.b_scissors);

        iv_computerChoice = (ImageView)findViewById(R.id.iv_computerChoice);
        iv_humanChoice = (ImageView)findViewById(R.id.iv_humanChoice);

        tv_score = (TextView)findViewById(R.id.tv_score);




        b_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_humanChoice.setImageResource(R.drawable.paper);
                String message = play_turn("paper");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                tv_score.setText("Human Score: " + Integer.toString(humanScore) + ", Computer Score: " + Integer.toString(computerScore));
            }
        });

        b_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_humanChoice.setImageResource(R.drawable.rock);
                String message = play_turn("rock");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                tv_score.setText("Human Score: " + Integer.toString(humanScore) + ", Computer Score: " + Integer.toString(computerScore));
            }
        });

        b_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_humanChoice.setImageResource(R.drawable.scissors);
                String message = play_turn("scissors");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                tv_score.setText("Human Score: " + Integer.toString(humanScore) + ", Computer Score: " + Integer.toString(computerScore));
            }
        });




    }

    public String play_turn(String player_choice){

        String computer_choice ="";
        Random r = new Random();

        int computer_choice_number = r.nextInt(3)+1;

        if(computer_choice_number == 1){
            computer_choice = "rock";
        }else if(computer_choice_number == 2){
            computer_choice = "scissors";
        }else if(computer_choice_number == 3){
            computer_choice = "paper";
        }

        if(computer_choice == "rock"){
            iv_computerChoice.setImageResource(R.drawable.rock);
        }else if(computer_choice == "scissors") {
            iv_computerChoice.setImageResource(R.drawable.scissors);
        }else if(computer_choice == "paper"){
            iv_computerChoice.setImageResource(R.drawable.paper);
        }

        if(computer_choice == player_choice){
            return "LAME! it is a draw. Nobody won :)";
        }else if(player_choice == "rock" && computer_choice == "scissors"){
            humanScore++;
            return "Rock crushes scissors! You win.... for now :D";
        }else if(player_choice == "rock" && computer_choice == "paper"){
            computerScore++;
            return "Paper covers rock! Computer wins and is superior to you!";
        }else if(player_choice == "scissors" && computer_choice == "rock"){
            computerScore++;
            return "Rock crushes scissors! Computer wins and is superior to you!";
        }else if(player_choice == "scissors" && computer_choice == "paper"){
            humanScore++;
            return "Scissors cuts paper! you win.... for now :D";
        }else if(player_choice == "paper" && computer_choice == "rock"){
            humanScore++;
            return "Paper covers rock! you win.... for now :D";
        }else if(player_choice == "paper" && computer_choice == "scissors"){
            computerScore++;
            return "Scissors cuts paper! Computer wins and is superior to you!";
        }else{
            return "Error";
        }


    }
}