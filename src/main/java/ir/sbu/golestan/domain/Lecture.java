package ir.sbu.golestan.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ali Asghar on 22/05/2017.
 */

@Entity
@Table(name = "lectures")
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String code;

    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.PERSIST, mappedBy = "lecture")
    private Set<StudentLecture> studentLectures = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "term_id")
    private Term term;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(nullable = false)
    private int roomNumber;

    @ManyToOne
    @JoinColumn(name = "master_id")
    private Master master;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Set<StudentLecture> getStudentLectures() {
        return studentLectures;
    }

    public void setStudentLectures(Set<StudentLecture> studentLectures) {
        this.studentLectures = studentLectures;
    }

    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term = term;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }
}
