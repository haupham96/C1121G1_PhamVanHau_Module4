package furama.service.impl;

import furama.model.contract.Contract;
import furama.model.customer.Customer;
import furama.model.customer_with_all_services.CustomerServiceView;
import furama.model.customer_with_all_services.CustomerServicesView;
import furama.model.customer_with_all_services.CustomerWithAllServices;
import furama.model.customer_with_all_services.ICustomerServiceView;
import furama.model.employee.Employee;
import furama.repository.ICustomerWithAllServicesRepository;
import furama.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerWithAllServicesService implements ICustomerWithAllServicesService {

    @Autowired
    private ICustomerWithAllServicesRepository iCustomerWithAllServicesRepository;

    @Autowired
    ICustomerService iCustomerService;

    @Autowired
    IEmployeeService iEmployeeService;

    @Autowired
    IFuramaService iFuramaService;

    @Autowired
    IContractService iContractService;


    @Override
    public Page<ICustomerServiceView> findAllPageCustomerServiceView(Pageable pageable) {
        return this.iCustomerWithAllServicesRepository.findAllPageStudentView(ICustomerServiceView.class,pageable);
    }
}
