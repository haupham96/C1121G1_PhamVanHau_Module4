package passbook.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import passbook.model.PassBook;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Set;

public class CustomerDTO {
    private Integer id ;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z ]+$")
    private String name ;

    Set<PassBook> passBooks ;

    public CustomerDTO() {
    }

    public CustomerDTO(String name) {
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
