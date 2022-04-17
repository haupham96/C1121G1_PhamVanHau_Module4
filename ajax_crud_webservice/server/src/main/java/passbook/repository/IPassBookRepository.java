package passbook.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import passbook.model.PassBook;

public interface IPassBookRepository extends JpaRepository<PassBook,Integer> {

}
