import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReportGenerator {
    private List<Score> scores;

    public ReportGenerator() {
        this.scores = readScoresFromCSV();
    }

    public String generateAverageScoreReport(int playerID) {
        double averageScore = calculateAverageScore(playerID);
        int playerAge = getPlayerAge(playerID); // Get player age
        return "Average Score Report for Player " + playerID + " (Age: " + playerAge + "): " + averageScore;
    }

    public String generateFullReport(int playerID) {
        StringBuilder fullReport = new StringBuilder("Full Report for Player " + playerID + ":\n");
        int playerAge = getPlayerAge(playerID); // Get player age
        fullReport.append("Player Age: ").append(playerAge).append("\n");

        for (Score score : scores) {
            if (score.getPlayerID() == playerID) {
                fullReport.append("Attack: ").append(score.getAttack()).append("\n");
                fullReport.append("Defense: ").append(score.getDefense()).append("\n");
                fullReport.append("Boosting: ").append(score.getBoosting()).append("\n");
                fullReport.append("Blocking: ").append(score.getBlocking()).append("\n");
            }
        }
        return fullReport.toString();
    }

    private List<Score> readScoresFromCSV() {
        List<Score> scoresList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("tournament_data.csv"))) {
            String line;
            // Skip the header line if it exists
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int playerID = Integer.parseInt(data[0]);
                int attack = Integer.parseInt(data[5]);  // Adjust index based on the new format
                int defense = Integer.parseInt(data[6]); // Adjust index based on the new format
                int boosting = Integer.parseInt(data[7]); // Adjust index based on the new format
                int blocking = Integer.parseInt(data[8]); // Adjust index based on the new format
                scoresList.add(new Score(playerID, attack, defense, boosting, blocking));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return scoresList;
    }

    private double calculateAverageScore(int playerID) {
        int totalScore = 0;
        int count = 0;
        for (Score score : scores) {
            if (score.getPlayerID() == playerID) {
                totalScore += score.getAttack() + score.getDefense() + score.getBoosting() + score.getBlocking();
                count += 4; // Number of categories
            }
        }
        return count > 0 ? (double) totalScore / count : 0;
    }

    private int getPlayerAge(int playerID) {
        Player player = CSVHandler.getPlayerById(playerID);
        if (player != null) {
            return player.calculateAge();
        } else {
            System.out.println("Player not found with ID: " + playerID);
            return -1; // Indicate that player age is not available
        }
    }
}
