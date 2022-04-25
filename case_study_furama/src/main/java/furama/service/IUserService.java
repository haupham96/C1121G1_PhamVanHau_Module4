package furama.service;

import furama.model.user.User;

public interface IUserService {
    User findByUserName(String username);
}
