package furama.service.impl;

import furama.model.customer.Customer;
import furama.model.customer_with_all_services.CustomerServicesView;
import furama.model.customer_with_all_services.CustomerWithAllServices;
import furama.model.employee.Employee;
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

import java.util.ArrayList;
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

    @Override
    public Page<CustomerWithAllServices> findAll(Pageable pageable) {

        Page<CustomerWithAllServices> page = this.iCustomerWithAllServicesRepository.findAll(pageable);

        for (CustomerWithAllServices obj : page) {
            obj.setTotalMoney(obj.calculateMoney());
        }
        return page;
    }

    @Override
    public Page<CustomerServicesView> views(Pageable pageable) {
        Page<CustomerWithAllServices> page = this.iCustomerWithAllServicesRepository.findAll(pageable);
        List<CustomerServicesView> listViews = new ArrayList<>();
        Page<CustomerServicesView> pageView;
        for (CustomerWithAllServices obj : page) {
            Employee employee = this.iEmployeeService.findById(obj.getEmployeeId());
            Customer customer = this.iCustomerService.findById(obj.getCustomerId());
            furama.model.service.Service service = this.iFuramaService.findById(obj.getServiceId());
            obj.setTotalMoney(obj.calculateMoney());
            CustomerServicesView customerServicesView = new CustomerServicesView(obj.getId(), obj.getContract_id(), obj.getServicePrice(), obj.getDeposit(), obj.getAttachServiceName(), obj.getAttachServicePrice(), obj.getTotalQuantity(), obj.getTotalMoney(), customer, employee, service);
            listViews.add(customerServicesView);
        }
        pageView = new PageImpl<>(listViews, pageable, page.getTotalPages());
        return pageView;
    }
}
