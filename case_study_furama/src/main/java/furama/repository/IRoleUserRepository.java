package furama.repository;

import furama.model.user.RoleUser;
import furama.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

public interface IRoleUserRepository extends JpaRepository<RoleUser,Integer> {

    List<RoleUser> findByUser(User user);
}
