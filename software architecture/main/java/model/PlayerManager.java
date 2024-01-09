import java.util.ArrayList;
import java.util.List;

public class PlayerManager {
    private List<Player> players;

    public PlayerManager() {
        this.players = new ArrayList<>();
    }

    public void registerPlayer(String name, String email, String dateOfBirth, String category) {
        int playerID = generateRandomPlayerID();
        Player newPlayer = new Player(name, email, dateOfBirth, category, playerID);
        players.add(newPlayer);
        CSVHandler.writePlayerToCSV(newPlayer); 
    }

    private int generateRandomPlayerID() {
        return 100 + (int) (Math.random() * 900); 
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player findPlayerById(int playerID) {
        for (Player player : players) {
            if (player.getPlayerID() == playerID) {
                return player;
            }
        }
        return null; 
    }

    public void registerPlayer(String name, String dob, String category) {
    }
}