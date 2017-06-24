package ir.sbu.golestan.domain;

import javax.persistence.*;
import java.security.InvalidParameterException;
import java.util.Date;

/**
 * Created by Ali Asghar on 25/06/2017.
 */
@Entity
@Table(name = "lecture_times")
public class LectureTime {
    public enum Days {Saturday, Sunday, Monday, Tuesday, Wednesday, Thursday, Friday}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String day;

    @Column(nullable = false)
    private Date startHour;

    @Column(nullable = false)
    private Date endHour;

    public String getDay() {
        return day;
    }

    public void setDay(String day){
        for(Days d : Days.values()){
            if(day.equals(d.name())){
                this.day = day;
                return;
            }
        }
        throw new InvalidParameterException("day should be set according to enum");
    }

    public Date getStartHour() {
        return startHour;
    }

    public void setStartHour(Date startHour) {
        this.startHour = startHour;
    }

    public Date getEndHour() {
        return endHour;
    }

    public void setEndHour(Date endHour) {
        this.endHour = endHour;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
