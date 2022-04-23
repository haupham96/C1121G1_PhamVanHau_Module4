package furama.service.impl;

import furama.model.customer_with_all_services.CustomerWithAllServices;
import furama.repository.ICustomerWithAllServicesRepository;
import furama.service.ICustomerWithAllServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerWithAllServicesService implements ICustomerWithAllServicesService {

    @Autowired
    private ICustomerWithAllServicesRepository iCustomerWithAllServicesRepository;

    @Override
    public Page<CustomerWithAllServices> findAll(Pageable pageable) {
        Page<CustomerWithAllServices> page = this.iCustomerWithAllServicesRepository.findAll(pageable);
        for(CustomerWithAllServices obj:page){
            obj.setTotalMoney(obj.calculateMoney());
        }
        return page ;
    }
}
