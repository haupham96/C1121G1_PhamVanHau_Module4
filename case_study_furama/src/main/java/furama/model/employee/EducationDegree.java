package furama.model.employee;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class EducationDegree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    private String name ;

    @OneToOne(mappedBy = "educationDegree")
    private Employee employee ;

    public EducationDegree() {
    }

    public EducationDegree(String name) {
        this.name = name;
    }
}
