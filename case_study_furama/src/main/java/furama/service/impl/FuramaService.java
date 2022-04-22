package furama.service.impl;

import furama.model.service.RentType;
import furama.model.service.ServiceType;
import furama.repository.IFuramaServiceRepository;
import furama.repository.IRentTypeRepository;
import furama.repository.IServiceTypeRepository;
import furama.service.IFuramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuramaService implements IFuramaService {

    @Autowired
    IFuramaServiceRepository iFuramaServiceRepository;

    @Autowired
    IRentTypeRepository iRentTypeRepository;

    @Autowired
    IServiceTypeRepository iServiceTypeRepository;

    @Override
    public Page<furama.model.service.Service> findAll(Pageable pageable) {
        return this.iFuramaServiceRepository.findAll(pageable);
    }

    @Override
    public List<ServiceType> findAllServiceTypes() {
        return this.iServiceTypeRepository.findAll();
    }

    @Override
    public List<RentType> findAllRentTypes() {
        return this.iRentTypeRepository.findAll();
    }

    @Override
    public ServiceType findServiceTypeById(Integer typeId) {
        return this.iServiceTypeRepository.findById(typeId).orElse(null);
    }

    @Override
    public void save(furama.model.service.Service service) {
        this.iFuramaServiceRepository.save(service);
    }

}
