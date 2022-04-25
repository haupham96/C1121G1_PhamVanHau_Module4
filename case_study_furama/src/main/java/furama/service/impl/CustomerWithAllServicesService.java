package furama.service.impl;

import furama.model.customer.Customer;
import furama.model.customer_with_all_services.CustomerServicesView;
import furama.model.customer_with_all_services.CustomerWithAllServices;
import furama.model.customer_with_all_services.ICustomerServiceView;
import furama.model.employee.Employee;
import furama.repository.ICustomerServiceViewRepository;
import furama.repository.ICustomerWithAllServicesRepository;
import furama.service.ICustomerService;
import furama.service.ICustomerWithAllServicesService;
import furama.service.IEmployeeService;
import furama.service.IFuramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerWithAllServicesService implements ICustomerWithAllServicesService {

    @Autowired
    private ICustomerWithAllServicesRepository iCustomerWithAllServicesRepository;

    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private IFuramaService iFuramaService;

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    ICustomerServiceViewRepository iCustomerServiceViewRepository;

    @Override
    public Page<CustomerWithAllServices> findAll(Pageable pageable) {

        Page<CustomerWithAllServices> page = this.iCustomerWithAllServicesRepository.findAll(pageable);

        for (CustomerWithAllServices obj : page) {
            obj.setTotalMoney(obj.calculateMoney());
        }
        ;
        ;
        return page;
    }

    @Override
    public Page<CustomerServicesView> views(Pageable pageable) {
        return null;
    }

    @Override
    public List<ICustomerServiceView> findAll() {
        return iCustomerServiceViewRepository.findAllListICustomerView(ICustomerServiceView.class);
    }
}
