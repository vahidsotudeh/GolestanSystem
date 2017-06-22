package ir.sbu.golestan.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Collection;

/**
 * Created by Ali Asghar on 18/06/2017.
 */
@Data
public class TermDTO {

    @JsonProperty
    private long id;

    @JsonProperty
    private int year;

    @JsonProperty
    private int semester;

    @JsonProperty
    private Collection<LectureLightDTO> courses;

}
