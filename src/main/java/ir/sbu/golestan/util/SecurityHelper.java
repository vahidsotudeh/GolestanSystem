package ir.sbu.golestan.util;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Created by Ali Asghar on 22/06/2017.
 */
@Component
public class SecurityHelper {
    public boolean hasReadPermission(String resource){
        return hasPermission("READ_" + resource.toUpperCase());
    }

    public boolean hasUpdatePermission(String resource){
        return hasPermission("UPDATE_" + resource.toUpperCase());
    }

    public boolean hasDeletePermission(String resource){
        return hasPermission("DELETE_" + resource.toUpperCase());
    }

    public boolean hasCreatePermission(String resource){
        return hasPermission("CREATE_" + resource.toUpperCase());
    }

    public boolean hasPermission(String permission) {
        Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>)
                SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        boolean hasPermission = false;
        for (GrantedAuthority authority : authorities) {
            hasPermission = authority.getAuthority().equals(permission);
            if (hasPermission) {
                break;
            }
        }
        return hasPermission;
    }
}
