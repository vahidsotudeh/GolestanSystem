package ir.sbu.golestan.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * Created by Ali Asghar on 25/06/2017.
 */
@Data
public class LectureTimeFullDTO {

    @JsonProperty
    private Long id;

    @JsonProperty
    private String day;

    @JsonProperty
    private Date startHour;

    @JsonProperty
    private Date endHour;
}
