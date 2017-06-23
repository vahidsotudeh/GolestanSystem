package ir.sbu.golestan.controller;

import ir.sbu.golestan.domain.Role;
import ir.sbu.golestan.domain.User;
import ir.sbu.golestan.dto.AuthoritiesDTO;
import ir.sbu.golestan.dto.UserDto;
import ir.sbu.golestan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by Ali Asghar on 18/05/2017.
 */
@RestController
@RequestMapping("api/users")
public class UserController extends AbstractPagingAndSortingController<User, UserDto> {
    @Autowired
    public UserController(UserService userService) {
        super.s = userService;
        super.eClass = User.class;
        super.dClass = UserDto.class;
    }

    @GetMapping("authorities")
    public ResponseEntity getRoles() {
        if(!securityHelper.hasReadPermission(Role.class.getSimpleName()))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        Collection authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        if (authorities == null || authorities.size() == 0)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("You don't have permission for this.");

        AuthoritiesDTO authoritiesDTO = new AuthoritiesDTO();
        for (Object ga :
                authorities) {
            String authority = ((GrantedAuthority) ga).getAuthority();
            if(authority.startsWith("ROLE_")){
                authoritiesDTO.addRole(authority);
            }else{
                authoritiesDTO.addPermissions(authority);
            }
        }
        return ResponseEntity.ok(authoritiesDTO);
    }
}
