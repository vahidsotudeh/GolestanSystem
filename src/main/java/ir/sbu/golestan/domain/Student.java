package ir.sbu.golestan.domain;

import javax.persistence.*;
import java.security.InvalidParameterException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ali Asghar on 22/05/2017.
 */

@Entity
@Table(name = "students")
public class Student extends User{

    public enum StudentLevelTypes{BACHELOR, SENIOR, PHD}

    @Column(nullable = false)
    Date entranceDate;

    Date graduationDate;

    @Column(nullable = false)
    String level;

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    Group group;

    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy = "student")
    Set<StudentLecture> studentLectures = new HashSet<>();


    public void setLevel(String level){
        for(StudentLevelTypes e : StudentLevelTypes.values()){
            if(level.toUpperCase().equals(e.name())){
                this.level = level.toUpperCase();
                return;
            }
        }
        throw new InvalidParameterException("Student level should be set according to enum. See student class.");
    }

    public Date getEntranceDate() {
        return entranceDate;
    }

    public void setEntranceDate(Date entranceDate) {
        this.entranceDate = entranceDate;
    }

    public Date getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(Date graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getLevel() {
        return level;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Set<StudentLecture> getStudentLectures() {
        return studentLectures;
    }

    public void setStudentLectures(Set<StudentLecture> studentLectures) {
        this.studentLectures = studentLectures;
    }
}
