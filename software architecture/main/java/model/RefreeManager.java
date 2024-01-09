import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class RefreeManager {
    private List<Refree> refree;

    public RefreeManager() {
        this.refree = new ArrayList<>();
        
        refree.add(new Refree("admin", "root"));
    }

    public boolean login(String username, String password) {
        for (Refree refree : refree) {
            if (refree.login(username, password)) {
                return true; 
            }
        }
        return false; 
    }

    public void inputScores(int playerID, int goal, int pointsystem, int scoreboard) {
        Score newScore = new Score(playerID, goal, pointsystem, scoreboard);
        saveScoreToCSV(newScore);
    }

    private void saveScoreToCSV(Score score) {
        
        Player player = CSVHandler.getPlayerById(score.getPlayerID());

        if (player != null) {
            player.setScores(score);
            CSVHandler.updatePlayerScores(player);
        } else {
            System.out.println("Player not found with ID: " + score.getPlayerID());
        }
    }
}
