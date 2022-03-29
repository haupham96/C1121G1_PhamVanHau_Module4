package dictionary.model;

public class Dictionary {
    private String english ;
    private String vietnam ;

    public Dictionary() {
    }

    public Dictionary(String english, String vietnam) {
        this.english = english;
        this.vietnam = vietnam;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getVietnam() {
        return vietnam;
    }

    public void setVietnam(String vietnam) {
        this.vietnam = vietnam;
    }
}
