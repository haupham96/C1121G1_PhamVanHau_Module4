package validate.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import validate.model.User;

public interface IUserService {
    Page<User> findAll(Pageable pageable);

    void save(User user);
}
