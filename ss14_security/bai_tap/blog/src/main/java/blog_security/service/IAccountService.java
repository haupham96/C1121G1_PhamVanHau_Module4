package blog_security.service;

import blog_security.model.Account;

public interface IAccountService {
    Account findByUserName(String username);
}
