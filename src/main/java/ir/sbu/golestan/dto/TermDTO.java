package ir.sbu.golestan.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ali Asghar on 18/06/2017.
 */
@Data
public class TermDTO implements Serializable {

    @JsonProperty
    private Long id;

    @JsonProperty
    private int year;

    @JsonProperty
    private int semester;

    @JsonProperty
    private Set<LectureLightDTO> lectures = new HashSet<>();

}
