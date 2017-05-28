package ir.sbu.golestan.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Ali Asghar on 26/05/2017.
 */
@Data
@Entity
@IdClass(PreRequiredLecture.PreRequiredLectureId.class)
public class PreRequiredLecture {

    class PreRequiredLectureId implements Serializable{
        @ManyToOne
        @JoinColumn(name = "lecture_id", referencedColumnName = "id")
        private Lecture lecture;

        @ManyToOne
        @JoinColumn(name = "pre_required_lecture_id", referencedColumnName = "id")
        private Lecture preRequiredLecture;

        @ManyToOne
        @JoinColumn(name = "sub_group_id", referencedColumnName = "id")
        private SubGroup subGroup;

        public Lecture getLecture() {
            return lecture;
        }

        public void setLecture(Lecture lecture) {
            this.lecture = lecture;
        }

        public Lecture getPreRequiredLecture() {
            return preRequiredLecture;
        }

        public void setPreRequiredLecture(Lecture preRequiredLecture) {
            this.preRequiredLecture = preRequiredLecture;
        }

        public SubGroup getSubGroup() {
            return subGroup;
        }

        public void setSubGroup(SubGroup subGroup) {
            this.subGroup = subGroup;
        }
    }

    @Id Lecture lecture;
    @Id Lecture preRequiredLecture;
    @Id SubGroup subGroup;


}
