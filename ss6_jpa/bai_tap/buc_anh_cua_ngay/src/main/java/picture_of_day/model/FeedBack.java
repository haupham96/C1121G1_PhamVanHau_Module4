package picture_of_day.model;

import javax.persistence.*;

@Entity
public class FeedBack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    private Integer star ;

    private String author ;

    private String comment ;

    @Column(columnDefinition = "Integer default 0")
    private Integer likes ;

    private String datePicture ;

    public FeedBack() {
    }

    public FeedBack(Integer star, String author, String comment, Integer likes, String datePicture) {
        this.star = star;
        this.author = author;
        this.comment = comment;
        this.likes = likes;
        this.datePicture = datePicture;
    }

    public FeedBack(Integer id, Integer star, String author, String comment, Integer likes, String datePicture) {
        this.id = id;
        this.star = star;
        this.author = author;
        this.comment = comment;
        this.likes = likes;
        this.datePicture = datePicture;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
