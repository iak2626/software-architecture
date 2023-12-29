package main.java.model;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.Iterator;

public class CompetitorList {
    public List<Competitorclass> competitors;

    public CompetitorList() {
        this.competitors = new ArrayList<>();
    }

    // Getters and Setters
    public void setCompetitorList(List<Competitorclass> competitors) {
        this.competitors = competitors;
    }

    public List<Competitorclass> getCompetitorList() {
        return this.competitors;
    }

    /**
     * Helper class to hold both the competitor with the highest score and the score itself.
     */
    private static class HighestScoreResult {
        Competitorclass competitor;
        double score;

        HighestScoreResult(Competitorclass competitor, double score) {
            this.competitor = competitor;
            this.score = score;
        }
    }

    /**
     * Method to add a competitor to the list.
     *
     * @param competitor The competitor to be added to the list.
     * @return void
     */
    public void addCompetitor(Competitorclass competitor) {
        this.competitors.add(competitor);
    }

    /**
     
     *
     * @param competitorNumber The number of the competitor to be removed.
     * @return true if a competitor was removed, false otherwise.
     */
    public boolean removeCompetitor(int competitorid) {
        Iterator<Competitorclass> iterator = competitors.iterator();
        while (iterator.hasNext()) {
            Competitorclass competitor = iterator.next();
            if (competitor.getCompetitorid() == competitorid) {
                iterator.remove();
                return true; // Competitor found and removed
            }
        }
        return false;
    }

    /**
     * Finds and returns a competitor from the list based on the competitor number.
     *
     * @param competitorNumber The number of the competitor to be searched.
     * @return Optional.
     */
    public Optional<Competitorclass> findCompetitorByid(int id) {
        return competitors.stream()
                .filter(c -> c.getCompetitorid() == id)
                .findFirst();
    }

    /**
     * Get competitors from a file and populate competitorList with the data.
     *
     * @param fileName name of file to be read
     * @return void
     */
    public void loadCompetitorsFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                int competitorid = Integer.parseInt(details[0].trim());
                String name = details[1].trim();
                int age = Integer.parseInt(details[3].trim());
                String gender = details[4].trim();
                String category = details[6].trim();
                String level = details[7].trim();
                int[] scores = Arrays.stream(details, 8, details.length).mapToInt(Integer::parseInt).toArray();

                Competitorclass competitor;
                switch (level.toLowerCase()) {
                    case "BeginnerCompetitior":
                        competitor = new BeginnerCompetitor(competitorid, name, age, gender, category, level, scores);
                        break;
                 case "IntermediateCompetitior":
                        competitor = new IntermediateCompetitor(competitorid, name, level, age, gender, category, level, level, scores);
                        break;
                    case "ProfessionalCompetitor":
                        competitor = new ProfessionalCompetitor(competitorid, name, age, gender, category, level, scores);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid competitor level: " + level);
                }
                if (competitor != null) {
                    this.addCompetitor(competitor);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Calculates the mean (average) overall score of all competitors.
     *
     * @return The mean overall score.
     */
    public double findMeanOverallScore() {
        if (competitors.isEmpty()) {
            return 0.0; // Return 0 if there are no competitors
        }
        double sum = 0.0;
        for (Competitorclass competitor : competitors) {
            sum += competitor.getOverallScore();
        }
        return sum / competitors.size(); // Calculate the average
    }

    /**
     * Calculates the median overall score of all competitors.
     *
     * @return The median overall score.
     */
    public double findMedianOverallScore() {
        // Get the overall scores of all competitors
        List<Double> scores = competitors.stream()
                .map(Competitorclass::getOverallScore)
                .sorted()
                .collect(Collectors.toList());

        if (scores.isEmpty()) {
            return 0.0; // Return 0 if there are no competitors
        }

        int middle = scores.size() / 2;
        if (scores.size() % 2 == 1) {
            // If the size is odd, return the middle score
            return scores.get(middle);
        } else {
            // If the size is even, return the average of the middle scores
            return (scores.get(middle - 1) + scores.get(middle)) / 2.0;
        }
    }

    /**
     * Calculates the mode of the individual scores of all competitors.
     *
     * @return A set containing the mode(s) of the scores.
     */
    public Set<Integer> findModeIndividualScores() {
        Map<Integer, Integer> scoreFrequencies = new HashMap<>();

        // Count the frequency of each score
        for (Competitorclass competitor : competitors) {
            for (int score : competitor.getScoreArray()) {
                scoreFrequencies.merge(score, 1, Integer::sum);
            }
        }

        if (scoreFrequencies.isEmpty()) {
            return Collections.emptySet(); // Return an empty set if there are no scores
        }

        // Find the maximum frequency
        int maxFrequency = Collections.max(scoreFrequencies.values());

        // Collect scores that have the maximum frequency
        return scoreFrequencies.entrySet().stream()
                .filter(entry -> entry.getValue() == maxFrequency)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    /**
     * Finds the highest score and the corresponding competitor.
     *
     * @return HighestScoreResult containing both the highest scoring competitor and the score.
     */
    private HighestScoreResult findHighestScoreAndCompetitor() {
        if (competitors.isEmpty()) {
            return new HighestScoreResult(null, 0.0);
        }

        Competitorclass highestScoringCompetitor = null;
        double highestScore = Double.MIN_VALUE;

        for (Competitorclass competitor : competitors) {
            double score = competitor.getOverallScore();
            if (highestScoringCompetitor == null || score > highestScore) {
                highestScoringCompetitor = competitor;
                highestScore = score;
            }
        }

        return new HighestScoreResult(highestScoringCompetitor, highestScore);
    }

    /**
     * Finds the competitor with the highest overall score.
     *
     * @return The competitor with the highest overall score.
     */
    public Competitorclass findDetailsOfHighestOverallScoreCompetitor() {
        HighestScoreResult result = findHighestScoreAndCompetitor();
        return result.competitor;
    }

    /**
     * Finds the highest overall score among all competitors.
     *
     * @return The highest overall score.
     */
    public double findHighestOverallScore() {
        HighestScoreResult result = findHighestScoreAndCompetitor();
        return result.score;
    }

    /**
     * Calculates the frequency of each individual score across all competitors.
     *
     * @return A map with scores as keys and their frequencies as values.
     */
    public Map<Integer, Integer> findFrequencyOfIndividualScores() {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (Competitorclass competitor : competitors) {
            for (int score : competitor.getScoreArray()) {
                frequencyMap.put(score, frequencyMap.getOrDefault(score, 0) + 1);
            }
        }

        return frequencyMap;
    }

    /**
     * Finds the lowest overall score among all competitors.
     *
     * @return The lowest overall score.
     */
    public double findLowestOverallScore() {
        if (competitors.isEmpty()) {
            return 0.0; // Return 0 if there are no competitors
        }

        double lowestScore = Double.MAX_VALUE; // Start with the largest possible double value

        for (Competitorclass competitor : competitors) {
            double score = competitor.getOverallScore();
            if (score < lowestScore) {
                lowestScore = score; // Update the lowest score found
            }
        }

        return lowestScore;
    }

    /**
     * Produces a final report and writes it to a text file.
     *
     * @param reportPath The path of the report file.
     */
    public void produceFinalReport(String reportPath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(reportPath))) {
            // Write the table of competitors with full details
            writer.write("Table of Competitors:\n");
            for (Competitorclass competitor : competitors) {
                writer.write(competitor.getFullDetails() + "\n");
            }
            writer.newLine();

            // Write details of the competitor with the highest overall score
            Competitorclass topCompetitor = findDetailsOfHighestOverallScoreCompetitor();
            writer.write("Competitor with the Highest Overall Score:\n");
            if (topCompetitor != null) {
                writer.write(topCompetitor.getFullDetails() + "\n");
            } else {
                writer.write("No competitors found.\n");
            }
            writer.newLine();

            // Write mode of individual scores
            Set<Integer> modeSet = findModeIndividualScores();
            writer.write("Mode of Individual Scores: ");
            if (!modeSet.isEmpty()) {
                for (Integer score : modeSet) {
                    writer.write(score + " ");
                }
                writer.newLine();
            } else {
                writer.write("No mode found.\n");
            }

            // Write other summary statistics
            writer.write("Mean Overall Score: " + findMeanOverallScore() + "\n");
            writer.write("Median Overall Score: " + findMedianOverallScore() + "\n");
            writer.write("Lowest Overall Score: " + findLowestOverallScore() + "\n");

            // Write frequency report of individual scores
            writer.write("Frequency of Individual Scores:\n");
            Map<Integer, Integer> frequencyMap = findFrequencyOfIndividualScores();
            for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
                writer.write("Score " + entry.getKey() + ": " + entry.getValue() + " times\n");
            }

            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Allows user input for a competitor number and displays short details if valid.
     */
    public void displayCompetitorShortDetails() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter competitor id: ");
            int id = scanner.nextInt();

            Optional<Competitorclass> matchingCompetitor = findCompetitorByid(id);

            if (matchingCompetitor.isPresent()) {
                System.out.println("Short details: " + matchingCompetitor.get().getShortDetails());
            } else {
                System.out.println("No competitor found with this id: " + id);
            }
        }
    }

    public void updateCompetitor(Competitorclass updatedCompetitor) {
        for (int i = 0; i < competitors.size(); i++) {
            if (competitors.get(i).getCompetitorid() == updatedCompetitor.getCompetitorid()) {
                competitors.set(i, updatedCompetitor);
                break;
            }
        }
    }
}
