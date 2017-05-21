package ir.sbu.golestan.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Ali Asghar on 17/05/2017.
 */
@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    private String userName;

    private String password;

    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String email;

    private boolean enabled;

    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;


    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User() { }

    public User(long id) {
        this.id = id;
    }

}
