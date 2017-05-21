package ir.sbu.golestan.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Ali Asghar on 21/05/2017.
 */
@Data
@Entity
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "permissions")
    private Collection<Role> roles;

    public Permission(String name){
        this.name = name;
    }
}
