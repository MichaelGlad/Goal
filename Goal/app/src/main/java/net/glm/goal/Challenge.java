package net.glm.goal;

import android.widget.Button;

/**
 * Created by alonz on 14/03/2018.
 */

public class Challenge {

    private String challengeNumber;
    private String goals;
    private String leaderboards;
    private String tryouts;
    private String calories;
    private String daysLeft;
    private String challengeTime;
    private String challengeDistance;
    private String cycles;




    public Challenge(String challenge, String goals,  String leaderboards, String tryouts, String calories, String daysLeft,
                     String challengeTime, String challengeDistance, String cycles) {
        this.challengeNumber = challenge;
        this.goals = goals;
        this.leaderboards = leaderboards;
        this.tryouts = tryouts;
        this.calories = calories;
        this.daysLeft = daysLeft;
        this.challengeTime = challengeTime;
        this.challengeDistance = challengeDistance;
        this.cycles = cycles;
    }

    public void setChallenge(String challenge) {
        this.challengeNumber = challenge;
    }

    public String getChallenge() {
        return challengeNumber;
    }

    public String getCalories() {
        return calories;
    }

    public String getCycles() {
        return cycles;
    }

    public String getGoals() {
        return goals;
    }

    public String getChallengeDistance() {
        return challengeDistance;
    }

    public String getChallengeNumber() {
        return challengeNumber;
    }

    public String getChallengeTime() {
        return challengeTime;
    }

    public String getDaysLeft() {
        return daysLeft;
    }

    public String getLeaderboards() {
        return leaderboards;
    }

    public String getTryouts() {
        return tryouts;
    }

}
