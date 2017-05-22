package ir.sbu.golestan.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Ali Asghar on 22/05/2017.
 */
@Data
@Entity
@Table(name = "terms")
public class Term {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany
    private Collection<Course> courses;
}
