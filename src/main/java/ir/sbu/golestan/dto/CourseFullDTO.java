package ir.sbu.golestan.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ali Asghar on 28/05/2017.
 */
@Data
public class CourseFullDTO implements Serializable{
    @JsonProperty
    private Long id;

    @JsonProperty
    private String name;

    @JsonProperty
    private String code;

    @JsonProperty
    private Set<GroupLightDTO> groups = new HashSet<>();
    @JsonProperty
    private Set<CourseLightDTO> preRequiredLectures = new HashSet<>();
    @JsonProperty
    private int practicalUnitCount;
    @JsonProperty
    private int theoreticalUnitCount;



}
