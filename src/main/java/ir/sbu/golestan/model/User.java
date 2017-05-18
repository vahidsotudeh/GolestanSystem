package ir.sbu.golestan.model;

import lombok.Data;

import javax.persistence.*;

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

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User() { }

    public User(long id) {
        this.id = id;
    }

}
