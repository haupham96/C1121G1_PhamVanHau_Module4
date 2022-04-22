package furama.model.employee;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class EducationDegree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    private String name ;

    @OneToMany(mappedBy = "educationDegree")
    private Set<Employee> employee;

    public EducationDegree() {
    }

    public EducationDegree(String name) {
        this.name = name;
    }
}
