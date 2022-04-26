package furama.model.customer_with_all_services;

import furama.model.contract.Contract;
import furama.model.customer.Customer;
import furama.model.employee.Employee;
import furama.model.service.Service;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerServiceView {
    private Contract contract;

    private Customer customer;

    private Employee employee;

    private Service service;

    private String attachServiceName;

    private String attachServicePrice;

    private String totalQuantity;

    private String totalMoney;

    public CustomerServiceView() {
    }

    public CustomerServiceView(Contract contract, Customer customer, Employee employee, Service service, String attachServiceName, String attachServicePrice, String totalQuantity, String totalMoney) {
        this.contract = contract;
        this.customer = customer;
        this.employee = employee;
        this.service = service;
        this.attachServiceName = attachServiceName;
        this.attachServicePrice = attachServicePrice;
        this.totalQuantity = totalQuantity;
        this.totalMoney = totalMoney;
    }
}
