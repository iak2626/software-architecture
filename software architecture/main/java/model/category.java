public class category {
    private int categoryID;
    private String categoryName;
    private String categorydescription;
    private String categoryScore;

    public category(int categoryID, String categoryName, String categoryDescription, int categoryScore) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
    }   this.categoryDescription = categoryDescription;
        this.categoryScore = categoryScore;



    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }
    public int getCategoryScore() {
        return categoryScore;
    }

    public void setCategoryScore(int categoryScore) {
        this.categoryScore = categoryScore;
    }

    public void addCategory() {
        System.out.println("Adding category: " + categoryName);
    }

    public void viewCategories() {
        System.out.println("Viewing categories");
    }


    @Override
    public String toString() {
        return "Category{" +
                "categoryID=" + categoryID +
                ", categoryName='" + categoryName + 
                 ", categoryDescription='" + categoryDescription +
                  ", categoryScore='" + categoryScore +'\'' +
                '}';
    }
}