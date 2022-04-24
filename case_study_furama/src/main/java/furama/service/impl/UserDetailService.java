package furama.service.impl;

import furama.model.user.RoleUser;
import furama.model.user.User;
import furama.repository.IRoleRepository;
import furama.repository.IRoleUserRepository;
import furama.repository.IUserRepository;
import furama.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    IUserRepository iUserRepository;

    @Autowired
    IRoleRepository iRoleRepository;

    @Autowired
    IRoleUserRepository iRoleUserRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.iUserRepository.findByUserName(username);

        if (user == null) {
            System.out.println("not found : " + username);
            throw new UsernameNotFoundException("not found User " + username);
        }
        List<RoleUser> roleUsers = this.iRoleUserRepository.findByUser(user);
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        if (roleUsers != null) {
            for (RoleUser role : roleUsers) {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRole().getName());
                grantedAuthorities.add(grantedAuthority);
            }
        }

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassWord(), grantedAuthorities);

        return userDetails;
    }
}
