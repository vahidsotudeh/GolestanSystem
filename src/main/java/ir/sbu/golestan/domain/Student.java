package ir.sbu.golestan.domain;

import lombok.Data;

import javax.persistence.*;
import java.security.InvalidParameterException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ali Asghar on 22/05/2017.
 */
@Data
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
    @JoinColumn(name = "sub_group_id", referencedColumnName = "id")
    SubGroup subGroup;

    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy = "student")
    Set<StudentCourse> studentCourses = new HashSet<>();


    public void setLevel(String level){
        for(StudentLevelTypes e : StudentLevelTypes.values()){
            if(level.toUpperCase().equals(e.name())){
                this.level = level.toUpperCase();
                return;
            }
        }
        throw new InvalidParameterException("Student level should be set according to enum. See student class.");
    }


}
