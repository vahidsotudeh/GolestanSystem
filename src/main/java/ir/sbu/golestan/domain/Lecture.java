package ir.sbu.golestan.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Ali Asghar on 22/05/2017.
 */
@Data
@Entity
@Table(name = "lectures")
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany
    @JoinColumn(name = "sub_group_id", referencedColumnName = "id")
    Collection<SubGroup> subGroups;

    @OneToMany
    Collection<Lecture> preRequiredLectures;

    @Column(nullable = false)
    private int unitCount;
}
