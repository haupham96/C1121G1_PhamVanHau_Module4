package blog_security.service.impl;

import blog_security.model.Account;
import blog_security.repository.IAccountRepository;
import blog_security.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {

    @Autowired
    IAccountRepository iAccountRepository;

    @Override
    public Account findByUserName(String username) {
        return iAccountRepository.findByUserName(username);
    }
}
