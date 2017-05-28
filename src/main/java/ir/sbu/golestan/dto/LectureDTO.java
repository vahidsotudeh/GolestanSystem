package ir.sbu.golestan.dto;

import ir.sbu.golestan.domain.Lecture;
import ir.sbu.golestan.domain.SubGroup;
import lombok.Data;

import java.util.Set;

/**
 * Created by Ali Asghar on 28/05/2017.
 */
@Data
public class LectureDTO {
    private Long id;
    private String name;
    private String code;
    private Set<SubGroup> subGroups;
    private Set<Lecture> preRequiredLectures;
    private int practicalUnitCount;
    private int theoreticalUnitCount;

}
