package com.ejiroavw.rando;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class scores extends AppCompatActivity {
    private TextView total_points_view, scoreRank_1_init,scoreRank_2_init,scoreRank_3_init,scoreRank_4_init,scoreRank_5_init;
    int totalPoints_int,score_rank_1, score_rank_2, score_rank_3,score_rank_4,score_rank_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);
        getSupportActionBar().hide();
        initialiseViews();

        Intent intent = getIntent();
        String activity = intent.getStringExtra("activity");
        if(activity.equals("main_menu")){
            total_points_view.setVisibility(View.INVISIBLE);
        }else{
            total_points_view.setText(getString(R.string.total_points,totalPoints_int));
        }


        SharedPreferences preferences = getSharedPreferences("PREF", 0);
        totalPoints_int = preferences.getInt("total_points",0);
        score_rank_1 = preferences.getInt("score_rank_1",0);
        score_rank_2 = preferences.getInt("score_rank_2",0);
        score_rank_3 = preferences.getInt("score_rank_3",0);
        score_rank_4 = preferences.getInt("score_rank_4",0);
        score_rank_5 = preferences.getInt("score_rank_5",0);

        if(totalPoints_int > score_rank_5){
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("score_rank_5",totalPoints_int);
            editor.apply();
        }
        if(totalPoints_int > score_rank_4){
            int temp = score_rank_4;
            score_rank_4 = totalPoints_int;
            score_rank_5 = temp;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("score_rank_5",score_rank_5);
            editor.putInt("score_rank_4", score_rank_4);
            editor.apply();
        }
        if(totalPoints_int > score_rank_3){
            int temp = score_rank_3;
            score_rank_3 = totalPoints_int;
            score_rank_4 = temp;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("score_rank_4",score_rank_4);
            editor.putInt("score_rank_3", score_rank_3);
            editor.apply();
        }
        if(totalPoints_int > score_rank_2){
            int temp = score_rank_2;
            score_rank_2 = totalPoints_int;
            score_rank_3 = temp;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("score_rank_3",score_rank_3);
            editor.putInt("score_rank_2", score_rank_2);
            editor.apply();
        }
        if(totalPoints_int > score_rank_1){
            int temp = score_rank_1;
            score_rank_1 = totalPoints_int;
            score_rank_2 = temp;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("score_rank_2",score_rank_2);
            editor.putInt("score_rank_1", score_rank_1);
            editor.apply();
        }

        if (score_rank_1 == 0){
            total_points_view.setText(getString(R.string.no_score_found));
        }else{
            scoreRank_1_init.setText(getString(R.string.score_rank_1_string,score_rank_1));
            scoreRank_2_init.setText(getString(R.string.score_rank_2_string,score_rank_2));
            scoreRank_3_init.setText(getString(R.string.score_rank_3_string,score_rank_3));
            scoreRank_4_init.setText(getString(R.string.score_rank_4_string,score_rank_4));
            scoreRank_5_init.setText(getString(R.string.score_rank_5_string,score_rank_5));
        }



    }

    private void initialiseViews(){
        total_points_view = findViewById(R.id.current_total_points_view);
        scoreRank_1_init = findViewById(R.id.scores_rank_1_view);
        scoreRank_2_init = findViewById(R.id.scores_rank_2_view);
        scoreRank_3_init = findViewById(R.id.scores_rank_3_view);
        scoreRank_4_init = findViewById(R.id.scores_rank_4_view);
        scoreRank_5_init = findViewById(R.id.scores_rank_5_view);
    }
}