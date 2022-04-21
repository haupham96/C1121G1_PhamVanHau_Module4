package furama.model.employee;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name ;

    @OneToOne(mappedBy = "position")
    private Employee employee;

    public Position() {
    }

    public Position(String name) {
        this.name = name;
    }

}
