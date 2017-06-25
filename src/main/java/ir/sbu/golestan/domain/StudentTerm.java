package ir.sbu.golestan.domain;

import javax.persistence.*;

/**
 * Created by Ali Asghar on 25/06/2017.
 */

@Table(name = "student_terms",
        uniqueConstraints = @UniqueConstraint(columnNames = {"student_id", "term_id"}))
@Entity
public class StudentTerm {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Term term;

    private float average;

    private int practicalUnitCount;

    private int theoreticalUnitCount;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term = term;
    }

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
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
