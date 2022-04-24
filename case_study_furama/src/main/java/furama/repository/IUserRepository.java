package furama.repository;

import furama.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Integer> {

    User findByUserName(String username);
}
