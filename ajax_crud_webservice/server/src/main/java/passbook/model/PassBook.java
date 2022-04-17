package passbook.model;

import javax.persistence.*;

@Entity
public class PassBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "date")
    private String timeStart;
    private String period;
    private String money;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    private Customer customer ;

    public PassBook() {
    }

    public PassBook(String timeStart, String period, String money) {
        this.timeStart = timeStart;
        this.period = period;
        this.money = money;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
