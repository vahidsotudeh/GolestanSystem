package ir.sbu.golestan.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ali Asghar on 18/06/2017.
 */
@Data
public class StudentDTO {
    @JsonProperty
    private Long id;

    @JsonProperty
    private String userName;

    @JsonProperty
    private String firstName;

    @JsonProperty
    private String lastName;

    @JsonProperty
    Date entranceDate;

    @JsonProperty
    Date graduationDate;

    @JsonProperty
    String level;

    @JsonProperty
    GroupLightDTO group;

    @JsonProperty
    Set<StudentCourseDTO> studentCourses = new HashSet<>();
}
