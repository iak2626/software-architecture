package main.java.model;
public class Match {
    private String matchID;
    private int playerId; // The user associated with the match
    private int score;     // The score in the match
    private String result; // The result of the match (e.g., Win/Loss)

    // Constructor with matchID, userID, score, and result
    public Match(String matchID, int playerId, int score, String result) {
        this.matchID = matchID;
        this.playerId = playerId;
        this.score = score;
        this.result = result;
    }

    public String getMatchID() {
        return matchID;
    }

    public void setMatchID(String matchID) {
        this.matchID = matchID;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}
