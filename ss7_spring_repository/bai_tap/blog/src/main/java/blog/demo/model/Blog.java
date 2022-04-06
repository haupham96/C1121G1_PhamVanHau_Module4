package blog.demo.model;

import javax.persistence.*;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String author;
    private String blogName;
    private String blogDescription;
    private String blogDetail;
    private String date;

    @ManyToOne
    @JoinColumn(name = "categoryId", referencedColumnName = "id")
    private Category category;

    public Blog() {
    }

    public Blog(String author, String blogName, String blogDescription, String blogDetail, String date) {
        this.author = author;
        this.blogName = blogName;
        this.blogDescription = blogDescription;
        this.blogDetail = blogDetail;
        this.date = date;

    }

    public Blog(Integer id, String author, String blogName, String blogDescription, String blogDetail, String date) {
        this.id = id;
        this.author = author;
        this.blogName = blogName;
        this.blogDescription = blogDescription;
        this.blogDetail = blogDetail;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public String getBlogDescription() {
        return blogDescription;
    }

    public void setBlogDescription(String blogDescription) {
        this.blogDescription = blogDescription;
    }

    public String getBlogDetail() {
        return blogDetail;
    }

    public void setBlogDetail(String blogDetail) {
        this.blogDetail = blogDetail;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
