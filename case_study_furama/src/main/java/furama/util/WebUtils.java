package furama.util;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class WebUtils {
    public static String toString(User user) {
        StringBuilder sb = new StringBuilder();
        sb.append("User : ").append(user.getUsername());
        Collection<GrantedAuthority> grantedAuthorities = user.getAuthorities();
        if (grantedAuthorities != null && !grantedAuthorities.isEmpty()) {
            sb.append("(");
            boolean first = true;
            for (GrantedAuthority authority : grantedAuthorities) {
                if (first) {
                    sb.append(authority.getAuthority());
                    first = false;
                } else {
                    sb.append(",").append(authority.getAuthority());
                }
            }
            sb.append(")");
        }
        return sb.toString();
    }
}
