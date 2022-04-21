package furama.model.customer;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    private String customerCode;

    private String name ;

    @Column(columnDefinition = "DATE")
    private String birthday;

    @Column(columnDefinition = "BIT(1)")
    private Integer gender ;

    private String idCard ;
    private String phone ;
    private String email ;
    private String address ;

    @OneToOne
    @JoinColumn(name = "customer_type_id",referencedColumnName = "id")
    private CustomerType customerType ;

    public Customer() {
    }

    public Customer(String name, String birthday, Integer gender, String idCard, String phone, String email, String address) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }
}
