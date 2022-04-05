package picture_of_day.model;


public class Picture {
    private Integer idPicture ;
    private String url ;
    private String day ;

    public Picture() {
    }

    public Picture(String url, String day) {
        this.url = url;
        this.day = day;
    }

    public Picture(Integer idPicture, String url, String day) {
        this.idPicture = idPicture;
        this.url = url;
        this.day = day;
    }

    public Integer getIdPicture() {
        return idPicture;
    }

    public void setIdPicture(Integer idPicture) {
        this.idPicture = idPicture;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
