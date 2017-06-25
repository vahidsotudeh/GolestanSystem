package ir.sbu.golestan.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Ali Asghar on 22/05/2017.
 */

@Entity
@Table(name = "student_lecture",
    uniqueConstraints = @UniqueConstraint(columnNames = {"student_id", "lecture_id"}))
public class StudentLecture implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Lecture lecture;

    private float grade;


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
