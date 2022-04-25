package furama.model.customer_with_all_services;

import org.springframework.stereotype.Service;

public interface ICustomerServiceView {
    Integer getId();

    Integer getContractId();

    Integer getCustomerId();

    Integer getEmployeeId();

    Integer getServiceId();

    String getServicePrice();

    String getDeposit();

    String getAttachService();

    String getAttachServicePrice();

    Integer getTotalQuantity();

    String getTotalMoneytotalMoney();

}
