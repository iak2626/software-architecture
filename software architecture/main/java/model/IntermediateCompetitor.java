package main.java.model;

import java.util.Arrays;

public class IntermediateCompetitor extends Competitorclass {
    private int[] scores;

    public IntermediateCompetitor(int competitorid, String name, String email, int age, String gender, String country, String category, String level, int[] scores) {
        super(competitorid, name, age, gender, category, level, scores);
        this.scores = scores;
    }

    /**
     * Calculate the overall score for the IntermediateCompetitor.
     *
     * @return The calculated overall score.
     */
    @Override
    public double getOverallScore() {
        if (scores.length < 3) return 0;
        int[] sortedScores = Arrays.copyOf(scores, scores.length);
        Arrays.sort(sortedScores);
        return (double) (sortedScores[sortedScores.length - 1] + sortedScores[sortedScores.length - 2] + sortedScores[sortedScores.length - 3]) / 3;
    }

    /**
     * Assess the consistency of the IntermediateCompetitor's performance.
     *
     * @return A string indicating the assessment of consistency.
     */
    public String assessConsistency() {
        int[] scores = getScoreArray();
        int maxScore = Arrays.stream(scores).max().orElse(0);
        int minScore = Arrays.stream(scores).min().orElse(0);

        if (maxScore - minScore <= 1) {
            return "Highly consistent performance!";
        } else {
            return "You have some variations in your performance.";
        }
    }
}
