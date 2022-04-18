package customer.service.impl;

import customer.model.Customer;
import customer.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements customer.service.ICustomerService {

    @Autowired
    ICustomerRepository iCustomerRepository ;

    public List<Customer> findAll() {
        return this.iCustomerRepository.findAll();
    }
}
