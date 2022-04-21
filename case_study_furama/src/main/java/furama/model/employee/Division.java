package furama.model.employee;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    private String name ;

    @OneToOne(mappedBy = "division")
    private Employee employee ;

    public Division() {
    }

    public Division(String name, Employee employee) {
        this.name = name;
        this.employee = employee;
    }

}
