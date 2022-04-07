package validate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import validate.model.User;
import validate.repository.IUserRepository;
import validate.service.IUserService;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository repository;

    @Override
    public Page<User> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void save(User user) {
        repository.save(user);
    }
}
