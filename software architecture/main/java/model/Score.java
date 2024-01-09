public class Score {
    private int playerID;
    private int attack;
    private int defense;
    private int boosting;
    private int blocking;

    public Score(int playerID, int attack, int defense, int boosting, int blocking) {
        this.playerID = playerID;
        this.attack = attack;
        this.defense = defense;
        this.boosting = boosting;
        this.blocking = blocking;
    }

    public Score(int playerID2, int goal, int pointsystem, int scoreboard) {
    }

    // Getter methods
    public int getPlayerID() {
        return playerID;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getBoosting() {
        return boosting;
    }

    public int getBlocking() {
        return blocking;
    }


    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setBoosting(int boosting) {
        this.boosting = boosting;
    }

    public void setBlocking(int blocking) {
        this.blocking = blocking;
    }

    public int getGoal() {
        return 0;
    }

    public int getPointsystem() {
        return 0;
    }

    public int getScoreboard() {
        return 0;
    }
}
