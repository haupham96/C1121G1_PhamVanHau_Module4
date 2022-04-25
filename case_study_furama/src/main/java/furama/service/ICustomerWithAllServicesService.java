package furama.service;

import furama.model.customer_with_all_services.CustomerServiceView;
import furama.model.customer_with_all_services.CustomerServicesView;
import furama.model.customer_with_all_services.CustomerWithAllServices;
import furama.model.customer_with_all_services.ICustomerServiceView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerWithAllServicesService {
    Page<CustomerWithAllServices> findAll(Pageable pageable);

    Page<CustomerServicesView> views (Pageable pageable);

    List<ICustomerServiceView> findAll();

    List<CustomerServiceView> findAllListCustomerServiceView();
}
