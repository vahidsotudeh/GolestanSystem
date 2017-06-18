package ir.sbu.golestan.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by Ali Asghar on 11/06/2017.
 */
@Data
public class GroupLightDTO {
    @JsonProperty
    private Long id;
    @JsonProperty
    private String name;
}
