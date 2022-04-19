package blog_security.service;

import blog_security.model.Account;
import blog_security.model.RoleAccount;
import blog_security.repository.IAccountRepository;
import blog_security.repository.IRoleRepository;
import blog_security.repository.RoleAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    IAccountRepository accountRepository;

    @Autowired
    IRoleRepository roleRepository;

    @Autowired
    RoleAccountRepository roleAccountRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUserName(username);

        if (account == null) {
            System.out.println("not found account : " + username);
            throw new UsernameNotFoundException("not found User " + username);
        }

        System.out.println("found user : " + username);

        List<RoleAccount> roleAccounts = this.roleAccountRepository.findByAccount(account);

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        if (roleAccounts != null) {
            for (RoleAccount role : roleAccounts) {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRole().getRoleName());
                grantedAuthorities.add(grantedAuthority);
            }
        }

        UserDetails userDetails = (UserDetails) new User(account.getUserName(), account.getPassWord(), grantedAuthorities);

        return userDetails;
    }
}
