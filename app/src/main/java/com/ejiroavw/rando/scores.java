package com.ejiroavw.rando;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class scores extends AppCompatActivity {
    private TextView header, total_point, scoreRank_1_init,scoreRank_2_init,scoreRank_3_init,scoreRank_4_init,scoreRank_5_init;
    int totalPoints,score_rank_1, score_rank_2, score_rank_3,score_rank_4,score_rank_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);
        getSupportActionBar().hide();
        initialiseViews();

        Intent intent = getIntent();
        String activity = intent.getStringExtra("activity");
        if(activity == "main_menu"){
            total_point.setVisibility(View.INVISIBLE);
        }else{
            total_point.setText("Total Points: "+ totalPoints);
        }


        SharedPreferences preferences = getSharedPreferences("PREF", 0);
        totalPoints = preferences.getInt("total_points",0);
        score_rank_1 = preferences.getInt("score_rank_1",0);
        score_rank_2 = preferences.getInt("score_rank_2",0);
        score_rank_3 = preferences.getInt("score_rank_3",0);
        score_rank_4 = preferences.getInt("score_rank_4",0);
        score_rank_5 = preferences.getInt("score_rank_5",0);

        if(totalPoints > score_rank_5){
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("score_rank_5",totalPoints);
            editor.apply();
        }
        if(totalPoints > score_rank_4){
            int temp = score_rank_4;
            score_rank_4 = totalPoints;
            score_rank_5 = temp;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("score_rank_5",score_rank_5);
            editor.putInt("score_rank_4", score_rank_4);
            editor.apply();
        }
        if(totalPoints > score_rank_3){
            int temp = score_rank_3;
            score_rank_3 = totalPoints;
            score_rank_4 = temp;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("score_rank_4",score_rank_4);
            editor.putInt("score_rank_3", score_rank_3);
            editor.apply();
        }
        if(totalPoints > score_rank_2){
            int temp = score_rank_2;
            score_rank_2 = totalPoints;
            score_rank_3 = temp;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("score_rank_3",score_rank_3);
            editor.putInt("score_rank_2", score_rank_2);
            editor.apply();
        }
        if(totalPoints > score_rank_1){
            int temp = score_rank_1;
            score_rank_1 = totalPoints;
            score_rank_2 = temp;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("score_rank_2",score_rank_2);
            editor.putInt("score_rank_1", score_rank_1);
            editor.apply();
        }

        if (score_rank_1 == 0){
            total_point.setText("No points on Record, Play Game to get Points");
        }else{
            scoreRank_1_init.setText("|1|   "+score_rank_1 +"|");
            scoreRank_2_init.setText("|2|   "+score_rank_2 +"|");
            scoreRank_3_init.setText("|3|   "+score_rank_3 +"|");
            scoreRank_4_init.setText("|4|   "+score_rank_4 +"|");
            scoreRank_5_init.setText("|5|   "+score_rank_5 +"|");
        }



    }

    private void initialiseViews(){
        header = findViewById(R.id.high_score_header_view);
        total_point = findViewById(R.id.current_total_points_view);
        scoreRank_1_init = findViewById(R.id.scores_rank_1_view);
        scoreRank_2_init = findViewById(R.id.scores_rank_2_view);
        scoreRank_3_init = findViewById(R.id.scores_rank_3_view);
        scoreRank_4_init = findViewById(R.id.scores_rank_4_view);
        scoreRank_5_init = findViewById(R.id.scores_rank_5_view);
    }
}