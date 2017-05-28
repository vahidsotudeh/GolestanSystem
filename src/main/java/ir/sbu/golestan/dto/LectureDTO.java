package ir.sbu.golestan.dto;

import ir.sbu.golestan.domain.SubGroup;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ali Asghar on 28/05/2017.
 */
@Data
public class LectureDTO {
    private Long id;
    private String name;
    private String code;
    private Set<SubGroup> subGroups = new HashSet<>();
    private Set<PreRequiredLectureDTO> preRequiredLectures = new HashSet<>();
    private int practicalUnitCount;
    private int theoreticalUnitCount;



}
