package ir.sbu.golestan.dto;

/**
 * Created by Ali Asghar on 28/05/2017.
 */
public class PreRequiredLectureDTO {
    private Long id;
    private String name;

    public PreRequiredLectureDTO(Long id, String name) {
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
