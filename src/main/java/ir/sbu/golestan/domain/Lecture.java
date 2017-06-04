package ir.sbu.golestan.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Ali Asghar on 22/05/2017.
 */
@Data
@Entity
@Table(name = "lectures")
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    Set<Group> groups;

    @ManyToMany(cascade = CascadeType.ALL)
    Set<Lecture> preRequiredLectures;

    private int practicalUnitCount;

    private int theoreticalUnitCount;

    @Column(unique = true)
    private String code;
}
