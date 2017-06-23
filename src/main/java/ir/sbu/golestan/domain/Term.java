package ir.sbu.golestan.domain;

import lombok.Data;

import javax.persistence.*;
import java.security.InvalidParameterException;
import java.util.Set;

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

    private int year;

    private int semester;

    @OneToMany(mappedBy = "term")
    private Set<Lecture> lectures;

    public void setSemester(int semester){
        if(semester == 1 || semester == 2){
            this.semester = semester;
        }else {
            throw new InvalidParameterException("semester number is 1 or 2");
        }
    }
}
