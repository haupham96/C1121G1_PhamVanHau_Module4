package furama.model.contract;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class ContractDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id ;

    @Column(columnDefinition = "int")
    private String quantity ;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "contract_id",referencedColumnName = "id")
    private Contract contract;

    @ManyToOne
    @JoinColumn(name = "attach_service_id",referencedColumnName = "id")
    private AttachService attachService ;

    public ContractDetail() {
    }

    public ContractDetail(String quantity) {
        this.quantity = quantity;
    }
}
