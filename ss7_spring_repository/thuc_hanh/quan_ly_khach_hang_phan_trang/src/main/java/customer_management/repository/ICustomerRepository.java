package customer_management.repository;

import customer_management.model.Customer;
import customer_management.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findCustomerByProvince(Province province);
    Page<Customer> findAllByFirstNameContaining(String name, Pageable pageable);
}
