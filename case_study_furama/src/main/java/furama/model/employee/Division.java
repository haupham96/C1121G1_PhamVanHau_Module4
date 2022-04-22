package furama.model.employee;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    private String name ;

    @OneToMany(mappedBy = "division")
    private Set<Employee> employee;

    public Division() {
    }

    public Division(String name) {
        this.name = name;
    }

}
