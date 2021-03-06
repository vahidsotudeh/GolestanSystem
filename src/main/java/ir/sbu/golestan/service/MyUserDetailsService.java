package ir.sbu.golestan.service;

import ir.sbu.golestan.domain.Permission;
import ir.sbu.golestan.domain.Role;
import ir.sbu.golestan.domain.User;
import ir.sbu.golestan.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Ali Asghar on 21/05/2017.
 */

@Component
@Service("userDetailsService")
@Transactional
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private static final Logger LOGGER = LoggerFactory.getLogger(MyUserDetailsService.class);

    private final UserRepository userRepository;

    @Autowired
    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName)
            throws UsernameNotFoundException {

        LOGGER.info("finding user with username " + userName);

        User user = userRepository.findByUserName(userName);
        if (user == null) {
            LOGGER.error("no user found");
            return null;
        }

        LOGGER.info("user found with name " + user.getFirstName());

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPassword(), user.isEnabled(), true, true,
                true, getAuthorities(user.getRoles()));
    }



    private Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {

        return getGrantedAuthorities(getPermissions(roles));
    }

    private List<String> getPermissions(Collection<Role> roles) {
        List<String> permissions = new ArrayList<>();
        for (Role role : roles) {
            permissions.add("ROLE_" + role.getName());
            for(Permission permission: role.getPermissions()){
                permissions.add(permission.getName());
            }
        }
        return permissions;
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<String> permissions) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String permission : permissions) {
            authorities.add(new SimpleGrantedAuthority(permission));
        }
        LOGGER.info("user authorities are " + authorities.toString());
        return authorities;
    }
}
