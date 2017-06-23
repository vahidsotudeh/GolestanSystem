package ir.sbu.golestan.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by Ali Asghar on 18/06/2017.
 */
@Data
public class LectureFullDTO implements Serializable {

    @JsonProperty
    private long id;

    @JsonProperty
    private TermLightDTO term;

    @JsonProperty
    private CourseLightDTO course;

    @JsonProperty
    private int roomNumber;

    @JsonProperty
    private MasterLightDTO master;
}
