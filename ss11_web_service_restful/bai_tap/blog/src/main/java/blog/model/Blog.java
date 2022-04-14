package blog.model;

import javax.persistence.*;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    private String name ;
    private String author ;
    private String description ;
    private String detail ;


    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private Category category ;

    public Blog() {
    }

    public Blog(String name, String author, String description, String detail) {
        this.name = name;
        this.author = author;
        this.description = description;
        this.detail = detail;
    }

    public Blog(Integer id, String name, String author, String description, String detail) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.description = description;
        this.detail = detail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
