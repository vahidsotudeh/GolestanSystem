package ir.sbu.golestan.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * Created by Ali Asghar on 22/05/2017.
 */
@Data
@Entity
@Table(name = "masters")
public class Master extends User{

    @OneToMany
    private Set<Lecture> cours;
}