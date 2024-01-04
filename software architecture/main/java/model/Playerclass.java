package main.java.model;

import java.util.Arrays;
import java.util.stream.Collectors;

public abstract class Playerclass {
    // Instance variables
    private int playerId;
    private String name;
    private String gender;
    private int age;
    private String category;
    private String level;
    private int[] scores;

    /**
     * Constructor for the Player class.
     *
     * @param playerId The player's id.
     * @param name      The player's name.
     * @param age       The player's age.
     * @param gender    The player's gender.
     * @param category  The player's category.
     * @param level     The player's level.
     * @param scores    An array of scores for the player.
     */
    public PlayerClass(int playerId, String name, int age, String gender, String category, String level, int[] scores) {
        this.playerId = playerId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.category = category;
        this.level = level;
        this.scores = scores;
    }

    // Getters and Setters
    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLevel() {
        return level;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int[] getScoreArray() {
        return scores;
    }

    public void setScoreArray(int[] scores) {
        this.scores = scores;
    }

    /**
     * Abstract method to get the overall score of the player.
     *
     * @return double representing the overall score.
     */
    public abstract double getOverallScore();

    /**
     * Method to get full details of the player.
     *
     * @return String representing full details.
     */
    public String getFullDetails() {
        // Convert scores array to a string
        String scoresString = Arrays.stream(scores)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
        // Format and return the full details of the player
        return "Player number " + playerId + ", name " + name + ". " +
                name + " is a " + level + " aged " + age + " and received these scores: " + scoresString + " and has an overall score of " + getOverallScore() + ".";
    }

    /**
     * Helper method to get initials from the name.
     *
     * @param name String representing the full name.
     * @return String representing initials.
     */
    private String getInitials(String name) {
        if (name == null || name.isEmpty()) {
            return "";
        }

        StringBuilder initials = new StringBuilder();
        for (String part : name.split("\\s+")) {
            if (!part.isEmpty()) {
                initials.append(part.charAt(0));
            }
        }

        return initials.toString().toUpperCase();
    }

    /**
     * Method to get short details of the player.
     *
     * @return String representing short details.
     */
    public String getShortDetails() {
        // Format and return the short details of the player
        return "PN " + playerId + " (" + getInitials(name) + ") has overall score " + getOverallScore() + ".";
    }

    /**
     * Generate a string representation of the Player object.
     *
     * @return A string containing player details.
     */
    @Override
    public String toString() {
        return "Player{" +
                "playerId=" + playerId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", category='" + category + '\'' +
                ", level='" + level + '\'' +
                ", scores=" + Arrays.toString(scores) +
                '}';
    }
}
