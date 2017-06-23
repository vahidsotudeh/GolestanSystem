package ir.sbu.golestan.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by Ali Asghar on 11/06/2017.
 */
@Data
public class UserFullDTO implements Serializable {

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
}
