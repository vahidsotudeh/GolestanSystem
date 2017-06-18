package ir.sbu.golestan.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by Ali Asghar on 28/05/2017.
 */
@Data
public class LectureLightDTO implements Serializable{
    @JsonProperty
    private Long id;
    @JsonProperty
    private String name;

    public LectureLightDTO(){

    }


    public LectureLightDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
