package main.java.model;

public class rewards {
    private int rewardID;
    private String rewardName;
    private String rewardDescription;
    private String rewardLevel;
    

    /**
  
      @param rewardID    
      @param rewardName   
      @param rewardDescription
      @param rewardLevel
         
     */
    public rewards(int rewardID, String rewardName, String rewardDescription , String rewardLevel) {
        this.rewardID = rewardID;
        this.rewardName = rewardName;
        this.rewardDescription = rewardDescription;
        this.rewardLevel = rewardLevel;
    }

    public int getRewardID() {
        return rewardID;
    }

    public void setRewardID(int rewardID) {
        this.rewardID = rewardID;
    }

    public String getRewardName() {
        return rewardName;
    }

    public void setRewardName(String RewardName) {
        this.rewardName = rewardName;
    }

     public String getRewardDescription() {
        return rewardDescription;
    }

    public void setRewardDescription(String rewardDescription) {
        this.rewardDescription = rewardDescription;
    }

     public String getRewardLevel() {
        return rewardLevel;
    }

    public void setRewardLevel(String rewardLevel) {
        this.rewardLevel = rewardLevel;
    }

    /**
     */
    public void createAward() {
        System.out.println("Creating award: " + rewardName);
    }

    /**
     */
    public void viewAwardDetails() {
        System.out.println("Viewing details for award: " + rewardName);
    }

    @Override
    public String toString() {
        return "Awards{" +
                "rewardID=" + rewardID +
                ", rewardName='" + rewardName + '\'' +
                ", rewardDescription=" + rewardDescription +
                ", rewardLevel=" + rewardLevel +
                '}';
    }
}