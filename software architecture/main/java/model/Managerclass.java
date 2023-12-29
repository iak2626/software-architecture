package main.java.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Managerclass {
    private CompetitorList competitorList;

    public Managerclass() {
        this.competitorList = new CompetitorList();
    }
    public CompetitorList getCompetitorList() {
        return this.competitorList;
    }
    public void setCompetitorList(CompetitorList list) {
        this.competitorList = list;
    }
    public void loadCompetitorsFromFile(String filename) {
        this.competitorList.loadCompetitorsFromFile(filename);
    }

    public void produceFinalReport(String filename) {
        this.competitorList.produceFinalReport(filename);
    }

    public void displayCompetitorShortDetails() {
        this.competitorList.displayCompetitorShortDetails();
    }
}
