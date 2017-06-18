package ir.sbu.golestan.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Set;

/**
 * Created by Ali Asghar on 18/06/2017.
 */
@Data
public class GroupDTO {

    @JsonProperty
    private long id;

    @JsonProperty
    private String name;

    @JsonProperty
    private Set<LectureLightDTO> lectures;
}
