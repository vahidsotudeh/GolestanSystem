package ir.sbu.golestan.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
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
    private long id;

    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.PERSIST, mappedBy = "lecture")
    Set<StudentCourse> studentCourses = new HashSet<>();

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "term_id", referencedColumnName = "id")
    private Term term;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course;

    @Column(nullable = false)
    private int roomNumber;

    @ManyToOne
    @JoinColumn(name = "master_id", referencedColumnName = "id")
    private Master master;

}
