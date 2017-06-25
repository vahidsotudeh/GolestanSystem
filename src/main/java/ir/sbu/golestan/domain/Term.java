package ir.sbu.golestan.domain;

import javax.persistence.*;
import java.security.InvalidParameterException;
import java.util.Set;

/**
 * Created by Ali Asghar on 22/05/2017.
 */

@Entity
@Table(name = "terms")
public class Term {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int year;

    private int semester;

    @OneToMany(mappedBy = "term")
    private Set<Lecture> lectures;

    @OneToMany(mappedBy = "term", fetch = FetchType.LAZY)
    private Set<StudentTerm> studentTerms;

    private boolean finished;

    public void setSemester(int semester){
        if(semester == 1 || semester == 2){
            this.semester = semester;
        }else {
            throw new InvalidParameterException("semester number is 1 or 2");
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSemester() {
        return semester;
    }

    public Set<Lecture> getLectures() {
        return lectures;
    }

    public void setLectures(Set<Lecture> lectures) {
        this.lectures = lectures;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public Set<StudentTerm> getStudentTerms() {
        return studentTerms;
    }

    public void setStudentTerms(Set<StudentTerm> studentTerms) {
        this.studentTerms = studentTerms;
    }
}
