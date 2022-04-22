package furama.repository;

import furama.model.service.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFuramaServiceRepository extends JpaRepository<Service,Integer> {

}
