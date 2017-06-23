package ir.sbu.golestan.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by Ali Asghar on 24/06/2017.
 */
@Data
public class TermLightDTO {
    @JsonProperty
    private Long id;

    @JsonProperty
    private int year;

    @JsonProperty
    private int semester;
}
