package main.java.model;

import java.util.Arrays;

public class BeginnerCompetitor extends Competitorclass {
    private int[] scores;

    /**
     * Constructor for AmateurCompetitor class.
     *
     * @param competitorid The competitor's id.
     * @param name             The competitor's name.
     * @param age              The competitor's age.
     * @param gender           The competitor's gender.
     * @param category         The competitor's category.
     * @param level            The competitor's level.
     * @param scores           An array of scores for the competitor.
     */
    public BeginnerCompetitor(int competitorid, String name, int age, String gender, String category, String level, int[] scores) {
        super(competitorid, name, age, gender, category, level, scores);
        this.scores = scores;
    }

    /**
     * Calculate the overall score for the amateur competitor.
     *
     * @return The overall score as a double value.
     */
    @Override
    public double getOverallScore() {
        if (scores.length < 2) return 0;
        int[] sortedScores = Arrays.copyOf(scores, scores.length);
        Arrays.sort(sortedScores);
        return (double) (sortedScores[sortedScores.length - 1] + sortedScores[sortedScores.length - 2]) / 2;
    }

    /**
     * Get encouragement based on the overall score.
     *
     * @return A string with encouragement based on the overall score.
     */
    public String getEncouragement() {
        double averageScore = getOverallScore();
        if (averageScore >= 4.5) {
            return "Outstanding performance!";
        } else if (averageScore >= 3.5) {
            return "Great job, keep improving!";
        } else {
            return "Good work! Results can get better if practice is done frequently.";
        }
    }
}
