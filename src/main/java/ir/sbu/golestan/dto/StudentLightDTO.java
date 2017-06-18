package ir.sbu.golestan.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by Ali Asghar on 18/06/2017.
 */
@Data
public class StudentLightDTO {
    @JsonProperty
    private Long id;

    @JsonProperty
    private String userName;
}
