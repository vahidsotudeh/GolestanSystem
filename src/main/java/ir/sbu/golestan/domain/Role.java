package ir.sbu.golestan.domain;

import lombok.Data;

import javax.persistence.*;
import java.security.InvalidParameterException;
import java.util.Collection;

/**
 * Created by Ali Asghar on 21/05/2017.
 */

@Data
@Entity
public class Role {

    public enum RoleTypes {
        STUDENT, MASTER, GROUP_MANAGER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;

    @ManyToMany
    @JoinTable(
            name = "roles_permissions",
            joinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "permission_id", referencedColumnName = "id"))
    private Collection<Permission> permissions;

    public Role(){
    }
    public Role(String name) {
        this.name = name;
    }

    public RoleTypes getRoleType(){
        return RoleTypes.valueOf(this.name.toUpperCase());
    }

    public void setRoleType (RoleTypes roleType){
        this.setName(roleType.name());
    }

    public void setName(String name){
        for(RoleTypes e : RoleTypes.values()){
            if(name.equals(e.name())){
                this.name = name;
                return;
            }
        }
        throw new InvalidParameterException("Role name should be set according to enum");
    }
}