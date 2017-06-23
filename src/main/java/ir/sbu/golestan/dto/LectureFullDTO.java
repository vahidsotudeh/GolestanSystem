package ir.sbu.golestan.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.sbu.golestan.domain.Term;
import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ali Asghar on 18/06/2017.
 */
@Data
public class LectureFullDTO implements Serializable {

    @JsonProperty
    private long id;

    @JsonProperty
    Set<StudentLectureDTO> studentCourses = new HashSet<>();

    @JsonProperty
    private Term term;

    @JsonProperty
    private CourseLightDTO lecture;

    @JsonProperty
    private int roomNumber;

    @JsonProperty
    private MasterLightDTO master;
}
