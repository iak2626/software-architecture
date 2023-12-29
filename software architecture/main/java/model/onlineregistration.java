package main.java.model;

import java.util.ArrayList;
import java.util.Date;

public class onlineregistration {
    private int playerID;
    private int teamID;
    private ArrayList<Competitorclass> competitors;

    public onlineregistration(int playerID, ArrayList<Competitorclass> competitors, int teamID) {
        this.playerID = playerID;
        this.competitors = competitors;
        this.teamID = teamID;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public ArrayList<Competitorclass> getCompetitors() {
        return competitors;
    }

    public void setCompetitors(ArrayList<Competitorclass> competitors) {
        this.competitors = competitors;
    }
    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }
   

    public void registerCompetitor(Competitorclass competitor) {
        // Implementation for registering a competitor
        System.out.println("Registering competitor: " + competitor.getName());
    }

    public Competitorclass searchCompetitor(int competitorID) {
        // Implementation for searching a competitor by ID
        System.out.println("Searching for competitor with ID: " + competitorID);
        return null; // Replace with actual implementation
    }

    public void approveOnlineRegistration(int competitorID) {
        // Implementation for approving registration
        System.out.println("Approving registration for competitor with ID: " + competitorID);
    }

    public void rejectOnlineRegistration(int competitorID) {
        // Implementation for rejecting registration
        System.out.println("Rejecting registration for competitor with ID: " + competitorID);
    }

    public void viewDetails() {
        // Implementation for viewing registration details
        System.out.println("Viewing registration details");
    }

    public void generateReports() {
        // Implementation for generating reports
        System.out.println("Generating reports");
    }

    @Override
    public String toString() {
        return "onlineregistration{" +
                "playerID=" + playerID +
                ", competitors=" + competitors +
                 "teamID=" + teamID +'\'' +
                '}';
    }
}