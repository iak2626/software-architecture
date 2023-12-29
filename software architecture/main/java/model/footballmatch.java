package main.java.model;

import java.util.Date;

public class footballmatch {
    private int matchID;
    private String matchName;
    private Date matchDate;
    private String location;
    private int    refreeID;
    private int competitorID;

    /**
      @param matchID  
      @param matchName  
      @param matchDate  
      @param location 
      @param refreeID 
      @param competitorID  
     */
    public footballmatch(int matchID, String matchName, Date matchDate, String location, int refreeID, int competitorID) {
        this.matchID = matchID;
        this.matchName = matchName;
        this.matchDate = matchDate;
        this.location = location;
        this.refreeID = refreeID;
        this.competitorID = competitorID

    }

    public int getmatchID() {
        return matchID;
    }

    public void setMatchID(int matchID) {
        this.matchID = matchID;
    }

    public String getMatchName() {
        return matchName;
    }

    public void setmatchName(String matchName) {
        this.matchName = matchName;
    }

    public Date getmatchDate() {
        return matchDate;
    }

    public void setmatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getRefreeID() {
        return refreeID;
    }

    public void setrefreeID(int refreeID) {
        this.refreeID = refreeID;
    }
 public int getcompetitorID() {
        return competitorID;
    }

    public void setcompetitorID(int competitorID) {
        this.competitorID = competitorID;
    }
    public void startMatch() {
        System.out.println("Starting the match: " + matchName);
    }

    public void endMatch() {
        System.out.println("Ending the match: " + matchName);
    }

    public void generateResults() {
        System.out.println("Results are being generated for the match: " + matchName);
    }

    /**
     */
    public void scheduleMatch() {
        System.out.println("Scheduling the match: " + matchName);
    }

    @Override
    public String toString() {
        return "footballmatch{" +
                "matchID=" + matchID +
                ", matchName='" + matchName + '\'' +
                ", matchDate=" + matchDate +
                ", location='" + location + '\'' +
                ", refreeID='" + refreeID + '\'' +
                ", competitorID='" + competitorID + '\'' +
                '}';
    }
}