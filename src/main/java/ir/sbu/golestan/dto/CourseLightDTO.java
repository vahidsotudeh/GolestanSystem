package ir.sbu.golestan.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by Ali Asghar on 28/05/2017.
 */
@Data
public class CourseLightDTO implements Serializable{

    @JsonProperty
    private Long id;
    @JsonProperty
    private String name;

    @JsonProperty
    private String code;

    public CourseLightDTO(){

    }

    public CourseLightDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
