package blog_security.repository;

import blog_security.model.Account;
import blog_security.model.RoleAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleAccountRepository extends JpaRepository<RoleAccount, Integer> {
    List<RoleAccount> findByAccount(Account account);
}
