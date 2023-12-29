package main.java.model;

import java.util.Arrays;

public class ProfessionalCompetitor extends Competitorclass {
    private int[] scores;

    public ProfessionalCompetitor(int competitorID, String name, int age, String gender, String category, String level, int[] scores) {
        super(competitorID, name, age, gender, category, level, scores);
        this.scores = scores;
    }

    @Override
    public double getOverallScore() {
        if (scores.length < 4) return 0;
        int[] sortedScores = Arrays.copyOf(scores, scores.length);
        Arrays.sort(sortedScores);
        int sum = 0;
        for (int i = sortedScores.length - 1; i >= sortedScores.length - 4; i--) {
            sum += sortedScores[i];
        }
        return (double) sum / 4;
    }

    /**
     * Analyze the winning chances based on the overall score.
     *
     * @return A message indicating the winning chances.
     */
    public String analyzeWinningChances() {
        double averageScore = getOverallScore();
        if (averageScore >= 4.8) {
            return "You are so close to victory!";
        } else if (averageScore >= 4.5) {
            return "Very close to the top, push a bit more!";
        } else {
            return "You are doing well enough, just need some improvement to win!";
        }
    }
}

