package furama.service.impl;

import furama.model.user.User;
import furama.repository.IUserRepository;
import furama.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository iUserRepository;

    @Override
    public User findByUserName(String username) {
        return this.iUserRepository.findByUserName(username);
    }
}
