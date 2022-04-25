package furama.service;

import furama.model.customer_with_all_services.CustomerServicesView;
import furama.model.customer_with_all_services.CustomerWithAllServices;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerWithAllServicesService {
    Page<CustomerWithAllServices> findAll(Pageable pageable);

    Page<CustomerServicesView> views (Pageable pageable);
}
