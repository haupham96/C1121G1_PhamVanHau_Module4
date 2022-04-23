package furama.repository;

import furama.model.customer_with_all_services.CustomerWithAllServices;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerWithAllServicesRepository extends JpaRepository<CustomerWithAllServices,Integer> {

}
