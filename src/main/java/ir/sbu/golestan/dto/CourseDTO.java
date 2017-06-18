package ir.sbu.golestan.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.sbu.golestan.domain.Term;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ali Asghar on 18/06/2017.
 */
@Data
public class CourseDTO {

    @JsonProperty
    private long id;

    @JsonProperty
    Set<StudentCourseDTO> studentCourses = new HashSet<>();

    @JsonProperty
    private String name;

    @JsonProperty
    private Term term;

    @JsonProperty
    private LectureLightDTO lecture;

    @JsonProperty
    private int roomNumber;

    @JsonProperty
    private MasterLightDTO master;
}
