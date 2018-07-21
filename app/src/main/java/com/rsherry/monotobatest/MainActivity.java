package com.rsherry.monotobatest;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    //Bind views using Butterknife
    @BindView(R.id.teamAPoint) Button teamAPointButton;
    @BindView(R.id.teamBPoint) Button teamBPointButton;
    @BindView(R.id.teamAPoints) TextView teamAPoints;
    @BindView(R.id.teamBPoints) TextView teamBPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        final MainActivityViewModel mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        mainActivityViewModel.getScoreTeamA().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                teamAPoints.setText(String.valueOf(integer));

            }
        });
        mainActivityViewModel.getScoreTeamB().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                teamBPoints.setText(String.valueOf(integer));
            }
        });

        teamAPointButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivityViewModel.addToTeamA(1);
            }
        });

        teamBPointButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivityViewModel.addToTeamB(1);
            }
        });
    }
}
