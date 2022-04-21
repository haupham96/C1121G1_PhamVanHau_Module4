package furama.model.service;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class RentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(columnDefinition = "double")
    private String price;



    public RentType() {
    }

    public RentType(String name, String price) {
        this.name = name;
        this.price = price;
    }

}
