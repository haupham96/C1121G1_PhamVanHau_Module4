package furama.model.employee;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name ;

    @OneToMany(mappedBy = "position")
    private Set<Employee> employee;

    public Position() {
    }

    public Position(String name) {
        this.name = name;
    }

}
