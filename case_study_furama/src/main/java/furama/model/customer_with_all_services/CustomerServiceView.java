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

    private Double attachServicePrice;

    private Integer totalQuantity;

    private String totalMoney;

    public CustomerServiceView() {
    }

    public CustomerServiceView(Contract contract, Customer customer, Employee employee, Service service, String attachServiceName, Double attachServicePrice, Integer totalQuantity, String totalMoney) {
        this.contract = contract;
        this.customer = customer;
        this.employee = employee;
        this.service = service;
        this.attachServiceName = attachServiceName;
        this.attachServicePrice = attachServicePrice;
        this.totalQuantity = totalQuantity;
        this.totalMoney = totalMoney;
    }

    public String calculateTotalMoney() {
        Double calculateTotalMoney = Double.parseDouble(this.service.getPrice()) - Double.parseDouble(this.contract.getDeposit()) + (this.attachServicePrice * this.totalQuantity);
        String totalMoney = String.valueOf(calculateTotalMoney);
        return totalMoney;
    }
}
