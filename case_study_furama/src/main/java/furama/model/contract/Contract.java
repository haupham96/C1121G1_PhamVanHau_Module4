package furama.model.contract;

import furama.model.customer.Customer;
import furama.model.employee.Employee;
import furama.model.service.Service;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    @Column(columnDefinition = "date",nullable = false)
    private String startDate;

    @Column(columnDefinition = "date",nullable = false)
    private String endDate;

    @Column(columnDefinition = "double")
    private String deposit ;

    @Column(columnDefinition = "double")
    private String totalMoney ;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "custonmer_id",referencedColumnName = "id")
    private Customer customer;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="employee_id",referencedColumnName = "id")
    private Employee employee;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="service_id",referencedColumnName = "id")
    private Service service ;

    public Contract() {
    }

    public Contract(String startDate, String endDate, String deposit, String totalMoney) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.totalMoney = totalMoney;
    }
}
