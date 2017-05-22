package ir.sbu.golestan.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Ali Asghar on 22/05/2017.
 */
@Data
@Entity
@Table(name = "masters")
public class Master extends User{

    @OneToMany
    private Collection<Course> courses;
}
