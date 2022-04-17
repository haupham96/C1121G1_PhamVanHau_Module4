package passbook.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private String name ;

    @JsonBackReference
    @OneToMany(mappedBy = "customer")
    Set<PassBook> passBooks ;

    public Customer() {
    }

    public Customer(String name) {
        this.name = name;
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

    public Set<PassBook> getPassBooks() {
        return passBooks;
    }

    public void setPassBooks(Set<PassBook> passBooks) {
        this.passBooks = passBooks;
    }
}
