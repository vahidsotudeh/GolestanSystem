package ir.sbu.golestan.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by Ali Asghar on 24/06/2017.
 */
@Data
public class RoleLightDTO implements Serializable {
    @JsonProperty
    private Long id;

    @JsonProperty
    private String name;

    @JsonProperty
    private Set<PermissionLightDTO> permissions;
}
