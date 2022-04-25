package furama.repository;

import furama.model.customer_with_all_services.ICustomerServiceView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICustomerServiceViewRepository  {

    @Query(value = "select CONCAT(contract.id,contract.custonmer_id,contract.employee_id,contract.service_id,ifnull(attach_service.id,0)) as id , contract.id as contractId, contract.custonmer_id as customerId,contract.employee_id as employeeId ,contract.service_id as serviceId, ifnull(service.price,0) as servicePrice , contract.deposit as deposit , " +
            "attach_service.name as attachService, ifnull(attach_service.price,0) as attachServicePrice, ifnull(contract_detail.quantity,0) as totalQuantity ,  " +
            "contract.total_money as totalMoney " +
            "from contract " +
            "left join service on service.id = contract.service_id  " +
            "left join contract_detail on contract_detail.contract_id = contract.id  " +
            "left join attach_service on attach_service.id = contract_detail.attach_service_id  " +
            "; ", nativeQuery = true)
    <T> List<T> findAllListICustomerView(Class<T> classType);
}
