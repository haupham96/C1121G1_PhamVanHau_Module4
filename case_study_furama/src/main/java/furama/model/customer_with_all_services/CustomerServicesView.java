package furama.model.customer_with_all_services;

import furama.model.customer.Customer;
import furama.model.employee.Employee;
import furama.model.service.Service;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerServicesView {
    private String id;

    private Integer contract_id  ;

    private Integer servicePrice;

    private Integer deposit;

    private String attachServiceName;

    private Integer attachServicePrice;

    private Integer totalQuantity;

    private String totalMoney;

    private Customer customer;

    private Employee employee;

    private Service service;

    public CustomerServicesView() {
    }

    public CustomerServicesView(String id, Integer contract_id, Integer servicePrice, Integer deposit, String attachServiceName, Integer attachServicePrice, Integer totalQuantity, String totalMoney, Customer customer, Employee employee, Service service) {
        this.id = id;
        this.contract_id = contract_id;
        this.servicePrice = servicePrice;
        this.deposit = deposit;
        this.attachServiceName = attachServiceName;
        this.attachServicePrice = attachServicePrice;
        this.totalQuantity = totalQuantity;
        this.totalMoney = totalMoney;
        this.customer = customer;
        this.employee = employee;
        this.service = service;
    }
}
