package validate.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import validate.model.User;

public interface IUserRepository extends JpaRepository<User,Integer> {
}
