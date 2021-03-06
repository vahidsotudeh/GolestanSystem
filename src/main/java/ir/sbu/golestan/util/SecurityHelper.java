package ir.sbu.golestan.util;

import ir.sbu.golestan.domain.User;
import ir.sbu.golestan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Created by Ali Asghar on 22/06/2017.
 */
@Component
public class SecurityHelper {

    @Autowired
    UserService userService;

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

    public User getCurrentUser(){
        String email = ((org.springframework.security.core.userdetails.User)
                SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        return  userService.getByEmail(email);
    }

    public String getCurrentUserUserName(){
        return getCurrentUser().getUserName();
    }

    public boolean hasAuthority(String authority){
        Collection authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        for (Object ga :
                authorities) {
            String auth = ((GrantedAuthority) ga).getAuthority();
            if(auth.equalsIgnoreCase(authority))
                return true;
        }
        return false;
    }

    public boolean hasRole(String role){
        return hasAuthority("ROLE_" + role);
    }
}
