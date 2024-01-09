import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVHandler {
    private static final String CSV_FILE = "tournament_data.csv";

    public static List<Player> readPlayersFromCSV() {
        List<Player> playersList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int playerID = Integer.parseInt(data[0]);
                String name = data[1];
                String dob = data[2];
               // int age = Integer.parseInt(data[3]); // Assuming age is now stored in CSV
                String category = data[4];
                int goal = Integer.parseInt(data[5]);
                int pointsystem = Integer.parseInt(data[6]);
                int scoreboard = Integer.parseInt(data[7]);

                Player player = new Player(name, dob, category, playerID);
                player.setScores(new Score(playerID, goal, pointsystem, scoreboard));
                playersList.add(player);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return playersList;
    }

    public static void writePlayerToCSV(Player player) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(CSV_FILE, true))) {
            writer.println(player.getPlayerID() + "," +
                    player.getName() + "," +
                    player.getDob() + "," +
                    player.calculateAge() + "," +
                    player.getCategory() + "," +
                    player.getScores().getGoal() + "," +
                    player.getScores().getPointsystem() + "," +
                    player.getScores().getScoreboard());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Player getPlayerById(int playerID) {
        List<Player> players = readPlayersFromCSV();
        for (Player player : players) {
            if (player.getPlayerID() == playerID) {
                return player;
            }
        }
        return null;
    }

    public static void updatePlayerScores(Player player) {
        // Find and update the player in the list
        List<Player> players = readPlayersFromCSV();
        boolean playerFound = false;

        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getPlayerID() == player.getPlayerID()) {
                players.set(i, player);
                playerFound = true;
                break;
            }
        }

        // If the player is not found, add the new player to the list
        if (!playerFound) {
            players.add(player);
        }

        // Rewrite the entire CSV file with the updated list of players
        try (PrintWriter writer = new PrintWriter(new FileWriter(CSV_FILE, false))) {
            for (Player updatedPlayer : players) {
                writer.println(updatedPlayer.getPlayerID() + "," +
                        updatedPlayer.getName() + "," +
                        updatedPlayer.getDob() + "," +
                        updatedPlayer.calculateAge() + "," +
                        updatedPlayer.getCategory() + "," +
                        updatedPlayer.getScores().getGoal() + "," +
                        updatedPlayer.getScores().getPointsystem() + "," +
                        updatedPlayer.getScores().getScoreboard());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
