package ir.sbu.golestan.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Ali Asghar on 22/05/2017.
 */

@Entity
@Data
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    private String name;

}
