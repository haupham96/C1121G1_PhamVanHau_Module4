package phone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import phone.model.Smartphone;

public interface ISmartphoneRepository extends JpaRepository<Smartphone,Long> {

}
