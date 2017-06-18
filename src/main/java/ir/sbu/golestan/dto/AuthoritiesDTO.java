package ir.sbu.golestan.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ali Asghar on 18/06/2017.
 */
public class AuthoritiesDTO{
    @JsonProperty
    private List<String> roles = new ArrayList<>();
    @JsonProperty
    private List<String> permissions = new ArrayList<>();

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    public void addRole(String role){
        roles.add(role);
    }

    public void addPermissions(String permission){
        permissions.add(permission);
    }

}