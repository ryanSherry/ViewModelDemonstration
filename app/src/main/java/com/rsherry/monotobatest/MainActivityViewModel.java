package com.rsherry.monotobatest;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

public class MainActivityViewModel extends android.arch.lifecycle.ViewModel {

    public MutableLiveData<Integer> scoreTeamA;

    public MutableLiveData<Integer> scoreTeamB;

    public MainActivityViewModel() {
        scoreTeamA = new MutableLiveData<>();
        scoreTeamB = new MutableLiveData<>();

        scoreTeamA.setValue(0);
        scoreTeamB.setValue(0);
    }

    public void addToTeamA(int amount) {
        scoreTeamA.setValue(scoreTeamA.getValue() + amount);
    }

    public void addToTeamB(int amount) {
        scoreTeamB.setValue(scoreTeamB.getValue() + amount);
    }
    
    public LiveData<Integer> getScoreTeamA() {
        return scoreTeamA;
    }

    public LiveData<Integer> getScoreTeamB() {
        return scoreTeamB;
    }

    public void clearScoreTeamA() {
        scoreTeamA.setValue(0);
    }

    public void clearScoreTeamB() {
        scoreTeamA.setValue(0);
    }
}
