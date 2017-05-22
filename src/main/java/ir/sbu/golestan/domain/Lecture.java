package ir.sbu.golestan.domain;

import lombok.Data;

import javax.persistence.*;

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
}
