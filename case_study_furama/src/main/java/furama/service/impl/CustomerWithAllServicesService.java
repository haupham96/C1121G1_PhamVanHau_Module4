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
    public Page<CustomerWithAllServices> findAll(Pageable pageable) {

        Page<CustomerWithAllServices> page = this.iCustomerWithAllServicesRepository.findAll(pageable);

        for (CustomerWithAllServices obj : page) {
            obj.setTotalMoney(obj.calculateMoney());
        }
        return page;
    }

    @Override
    public Page<CustomerServicesView> views(Pageable pageable) {
        return null;
    }

    @Override
    public List<ICustomerServiceView> findAll() {
        List<ICustomerServiceView> list = iCustomerWithAllServicesRepository.findAllListICustomerView(ICustomerServiceView.class);
        return list;
    }

    public List<CustomerServiceView> findAllListCustomerServiceView() {
        List<CustomerServiceView> listCustomerServiceView = new ArrayList<>();

        List<ICustomerServiceView> list = this.findAll();

        for (ICustomerServiceView ls : list) {

            Contract contract = this.iContractService.findById(ls.getContractId());
            Employee employee = this.iEmployeeService.findById(ls.getEmployeeId());
            Customer customer = this.iCustomerService.findById(ls.getCustomerId());
            furama.model.service.Service service = this.iFuramaService.findById(ls.getServiceId());
            String attachService = ls.getAttachService();
            if (attachService == null) {
                attachService = "";
            }

            String attachServicePrice = ls.getAttachServicePrice();
            Double attachServicePriceDouble = 0.0 ;
            if (attachServicePrice != null) {
                attachServicePriceDouble = Double.valueOf(attachServicePrice);
            }

            Integer totalQuantity = ls.getTotalQuantity();
            if (totalQuantity == null) {
                totalQuantity = 0 ;
            }
            CustomerServiceView customerServiceView = new CustomerServiceView(contract, customer, employee, service, attachService, attachServicePriceDouble
                    , totalQuantity, ls.getTotalMoney());
            customerServiceView.setTotalMoney(customerServiceView.calculateTotalMoney());
            listCustomerServiceView.add(customerServiceView);
        }
        return listCustomerServiceView;
    }
}
