package ir.sbu.golestan.domain;

import javax.persistence.*;
import java.security.InvalidParameterException;
import java.util.Collection;
import java.util.Set;

/**
 * Created by Ali Asghar on 21/05/2017.
 */

@Entity
@Table(name = "roles")
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
    private Set<Permission> permissions;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }
}