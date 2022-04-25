package furama.service;

import furama.model.service.RentType;
import furama.model.service.Service;
import furama.model.service.ServiceType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFuramaService {
    Page<Service> findAll(Pageable pageable);

    List<ServiceType> findAllServiceTypes();

    List<RentType> findAllRentTypes();

    ServiceType findServiceTypeById(Integer typeId);

    void save(Service service);

    List<Service> listService();

    Service findById(Integer id);
}
