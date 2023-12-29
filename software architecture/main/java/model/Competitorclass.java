package main.java.model;

import java.util.Arrays;
import java.util.stream.Collectors;

public abstract class Competitorclass {
    // Instance variables
    private int competitorid;
    private String name;
    private String gender;
    private int age;
    private String category;
    private String level;
    private int[] scores;

    /**
     * Constructor for the Competitor class.
     *
     * @param competitorid The competitor's id.
     * @param name             The competitor's name.
     * @param age              The competitor's age.
     * @param gender           The competitor's gender.
     * @param category         The competitor's category.
     * @param level            The competitor's level.
     * @param scores           An array of scores for the competitor.
     */
    public Competitorclass(int competitorid, String name, int age, String gender,String category, String level, int[] scores) {
        this.competitorid = competitorid;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.category = category;
        this.level = level;
        this.scores = scores;
    }

    // Getters and Setters
    public int getCompetitorid() {
        return competitorid;
    }

    public void setCompetitorid(int competitorid) {
        this.competitorid = competitorid;
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
     * Abstract method to get the overall score of the competitor.
     *
     * @return double representing the overall score.
     */
    public abstract double getOverallScore();

    /**
     * Method to get full details of the competitor.
     *
     * @return String representing full details.
     */
    public String getFullDetails() {
        // Convert scores array to a string
        String scoresString = Arrays.stream(scores)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
        // Format and return the full details of the competitor
        return "Competitor number " + competitorid + ", name " + name + ". " +
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
     * Method to get short details of the competitor.
     *
     * @return String representing short details.
     */
    public String getShortDetails() {
        // Format and return the short details of the competitor
        return "CN " + competitorid + " (" + getInitials(name) + ") has overall score " + getOverallScore() + ".";
    }

    /**
     * Generate a string representation of the Competitor object.
     *
     * @return A string containing competitor details.
     */
    @Override
    public String toString() {
        return "Competitor{" +
                "competitorid=" + competitorid +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", category='" + category + '\'' +
                ", level='" + level + '\'' +
                ", scores=" + Arrays.toString(scores) +
                '}';
    }
}
