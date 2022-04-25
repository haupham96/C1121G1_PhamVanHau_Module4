package furama.model.customer_with_all_services;

import furama.model.customer.Customer;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@Getter
@Setter

@Entity
@Immutable
@Table(name = "customer_with_all_services")
public class CustomerWithAllServices {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name="contract_id")
    private Integer contract_id  ;

    @Column(name = "service_price")
    private Integer servicePrice;

    @Column(name = "deposit")
    private Integer deposit;

    @Column(name = "attach_service")
    private String attachServiceName;

    @Column(name = "attach_service_price")
    private Integer attachServicePrice;

    @Column(name = "total_quantity")
    private Integer totalQuantity;

    @Column(name = "total_money")
    private String totalMoney;

    @Column(name = "custonmer_id")
    private Integer customerId;

    @Column(name = "employee_id")
    private Integer employeeId;

    @JoinColumn(name = "service_id")
    private Integer serviceId;

    public CustomerWithAllServices() {
    }


    public CustomerWithAllServices(Integer servicePrice, Integer deposit, String attachServiceName, Integer attachServicePrice, Integer totalQuantity) {
        this.servicePrice = servicePrice;
        this.deposit = deposit;
        this.attachServiceName = attachServiceName;
        this.attachServicePrice = attachServicePrice;
        this.totalQuantity = totalQuantity;
        this.totalMoney = this.calculateMoney();
    }

    public String calculateMoney() {
        Integer money = this.servicePrice - this.deposit + (this.attachServicePrice * this.totalQuantity);
        String moneyString = String.valueOf(money);
        return moneyString;
    }
}
