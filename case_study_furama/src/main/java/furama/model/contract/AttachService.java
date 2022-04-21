package furama.model.contract;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class AttachService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    private String name ;

    @Column(columnDefinition = "double")
    private String price ;

    @Column(columnDefinition = "int")
    private String unit ;

    private String status ;

    public AttachService() {
    }

    public AttachService(String name, String price, String unit, String status) {
        this.name = name;
        this.price = price;
        this.unit = unit;
        this.status = status;
    }
}
