package furama.repository;

import furama.model.customer_with_all_services.CustomerWithAllServices;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICustomerWithAllServicesRepository extends JpaRepository<CustomerWithAllServices, Integer> {
    @Query(value = "select contract.id as contractId, contract.custonmer_id as customerId,contract.employee_id as employeeId ,contract.service_id as serviceId, service.price as servicePrice , contract.deposit as deposit , " +
            "attach_service.name as attachService, attach_service.price as attachServicePrice, contract_detail.quantity as totalQuantity ,  " +
            "service.price - contract.deposit + (ifnull(attach_service.price,0)*ifnull(contract_detail.quantity,0)) as totalMoney " +
            "from contract " +
            "left join service on service.id = contract.service_id " +
            "left join contract_detail on contract_detail.contract_id = contract.id " +
            "left join attach_service on attach_service.id = contract_detail.attach_service_id ; "
            , nativeQuery = true)
    <T> List<T> findAllListICustomerView(Class<T> classType);

    @Query(value = "select contract.id as contractId, contract.custonmer_id as customerId,contract.employee_id as employeeId ," +
            "contract.service_id as serviceId, service.price as servicePrice , contract.deposit as deposit , " +
            "attach_service.name as attachService, attach_service.price as attachServicePrice, contract_detail.quantity as totalQuantity ,  " +
            " ( service.price - contract.deposit + (ifnull(attach_service.price,0) * ifnull(contract_detail.quantity,0)) ) as totalMoney " +
            "from contract " +
            "left join service on service.id = contract.service_id  " +
            "left join contract_detail on contract_detail.contract_id = contract.id  " +
            "left join attach_service on attach_service.id = contract_detail.attach_service_id  "
            ,
            countQuery = "select count(*) from contract " +
                    "left join service on service.id = contract.service_id " +
                    "left join contract_detail on contract_detail.contract_id = contract.id " +
                    "left join attach_service on attach_service.id = contract_detail.attach_service_id  "
            ,
            nativeQuery = true)
    <T> Page<T> findAllPageStudentView(Class<T> classType, Pageable pageable);
}
