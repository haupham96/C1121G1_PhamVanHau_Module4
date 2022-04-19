package blog_security.repository;

import blog_security.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository extends JpaRepository<Account, Integer> {

    Account findByUserName(String username);
}
