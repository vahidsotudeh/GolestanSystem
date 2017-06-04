package ir.sbu.golestan.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by Ali Asghar on 28/05/2017.
 */
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
