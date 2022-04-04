package picture_of_day.model;

import javax.persistence.*;

@Entity
public class FeedBack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_feedback")
    private Integer idFeedback ;

    @Column(name="star")
    private Integer star ;

    @Column(name = "author")
    private String author ;

    @Column(name = "feedBack")
    private String feedBack ;

    @Column(name = "likes")
    private Integer likes ;

    @Column(name = "date_picture")
    private String datePicture ;

    public FeedBack() {
    }

    public FeedBack(Integer star, String author, String feedBack, Integer likes, String datePicture) {
        this.star = star;
        this.author = author;
        this.feedBack = feedBack;
        this.likes = likes;
        this.datePicture = datePicture;
    }

    public FeedBack(Integer idFeedback, Integer star, String author, String feedBack, Integer likes, String datePicture) {
        this.idFeedback = idFeedback;
        this.star = star;
        this.author = author;
        this.feedBack = feedBack;
        this.likes = likes;
        this.datePicture = datePicture;
    }

    public Integer getIdFeedback() {
        return idFeedback;
    }

    public void setIdFeedback(Integer idFeedback) {
        this.idFeedback = idFeedback;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public String getDatePicture() {
        return datePicture;
    }

    public void setDatePicture(String datePicture) {
        this.datePicture = datePicture;
    }
}
