package ir.sbu.golestan.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

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

    @JsonProperty
    private Date startTime;

    @JsonProperty
    private Date endTime;

    @JsonProperty
    private Set<LectureTimeFullDTO> lectureTimes;

    @JsonProperty
    private String code;
}
