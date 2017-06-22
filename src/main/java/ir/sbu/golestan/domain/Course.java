package ir.sbu.golestan.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Ali Asghar on 22/05/2017.
 */

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String code;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id")
            ,inverseJoinColumns = @JoinColumn(name= "group_id", referencedColumnName = "id")
    )
    private Set<Group> groups;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id")
            ,inverseJoinColumns = @JoinColumn(name = "pre_required_course_id", referencedColumnName = "id")
    )
    private Set<Course> preRequiredCourses;

    private int practicalUnitCount;

    private int theoreticalUnitCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public Set<Course> getPreRequiredCourses() {
        return preRequiredCourses;
    }

    public void setPreRequiredCourses(Set<Course> preRequiredCourses) {
        this.preRequiredCourses = preRequiredCourses;
    }

    public int getPracticalUnitCount() {
        return practicalUnitCount;
    }

    public void setPracticalUnitCount(int practicalUnitCount) {
        this.practicalUnitCount = practicalUnitCount;
    }

    public int getTheoreticalUnitCount() {
        return theoreticalUnitCount;
    }

    public void setTheoreticalUnitCount(int theoreticalUnitCount) {
        this.theoreticalUnitCount = theoreticalUnitCount;
    }
}
