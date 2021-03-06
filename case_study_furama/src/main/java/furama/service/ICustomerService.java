package furama.service;

import furama.model.customer.Customer;
import furama.model.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable);

    List<CustomerType> findAllCustomerType();

    void save(Customer customer);

    Customer findById(Integer id);

    void deleteById(Integer idDelete);

    Page<Customer> searchByCustomerName(String s, Pageable pageable);

    List<Customer> listCustomer();

    void deleteMultiple(List<String> iDString);
}
