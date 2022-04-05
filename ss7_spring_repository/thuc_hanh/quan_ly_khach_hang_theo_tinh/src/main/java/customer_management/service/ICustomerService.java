package customer_management.service;

import customer_management.model.Customer;
import customer_management.model.Province;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);

    List<Customer> findAllByProvince(Province province);
}
