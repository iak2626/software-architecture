package main.java.model;

import java.util.Arrays;

public class matchscores {
    private int scoreID;
    private int competitorID;
    private int tournamentID;

    public matchscores(int scoreID, int competitorID, int tournamentID) {
        this.scoreID = scoreID;
        this.competitorID = competitorID;
        this.tournamentID = tournamentID
    }

    public int getScoreID() {
        return scoreID;
    }

    public void setScoreID(int scoreID) {
        this.scoreID = scoreID;
    }

    public int getCompetitorID() {
        return competitorID;
    }

    public void setCompetitorID(int competitorID) {
        this.competitorID = competitorID;
    }

    public int getTournamentID() {
        return tournamentID;
    }

    public void setTournamentID(int tournamentID) {
        this.tournamentID = tournamentID;
    }
    
    

    public void addScore(int score) {
        // Implementation for adding score
        System.out.println("Adding score: " + score);
    }

    public int calculateTotalScore() {
        int totalScore = 0;

        
        for (int score : score) {
            totalScore += score;
        }

        return totalScore;
    }

    @Override
    public String toString() {
        return "RaceScores{" +
                "scoreID=" + scoreID +
                ", competitorID=" + competitorID +
                ", tournamentID=" + tournamentID +
                '}';
    }
}