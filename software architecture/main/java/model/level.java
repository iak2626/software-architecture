package main.java.model;

public class level {
    private int levelID;
    private String levelName;
    private String levelDescription;
    private int categoryID;

    public level(int levelID, String levelName, String levelDescription, int categoryID) {
        this.levelID = levelID;
        this.levelName = levelName;
        this.levelDescription = levelDescription;
        this.categoryID = categoryID;
    }

    public int getLevelID() {
        return levelID;
    }

    public void setLevelID(int levelID) {
        this.levelID = levelID;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }
    public String getLevelDescription() {
        return levelDescription;
    }

    public void setLevelDescription(String levelDescription) {
        this.levelDescription = levelDescription;
    }
    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }
    @Override
    public String toString() {
        return "Level{" +
                "levelID=" + levelID +
                ", levelName='" + levelName + '\'' +
                 ", levelDescription='" + levelDescription + '\'' +
                  ", categoryID='" + categoryID + '\'' +
                '}';
    }
}