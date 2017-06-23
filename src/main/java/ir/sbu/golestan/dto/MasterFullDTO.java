package ir.sbu.golestan.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by Ali Asghar on 18/06/2017.
 */
@Data
public class MasterFullDTO implements Serializable {

    @JsonProperty
    private Long id;

    @JsonProperty
    private String userName;

    @JsonProperty
    private String firstName;

    @JsonProperty
    private String lastName;

    @JsonProperty
    private String password;

    @JsonProperty
    private String enabled;

    @JsonProperty
    private Set<LectureLightDTO> lectures;
}
