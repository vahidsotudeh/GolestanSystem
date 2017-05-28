package ir.sbu.golestan.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Ali Asghar on 22/05/2017.
 */
@Data
@Entity
@Table(name = "student_course")
@IdClass(StudentCourse.StudentCourseId.class)
public class StudentCourse implements Serializable {

    class StudentCourseId implements Serializable {
        @ManyToOne
        private Student student;

        @ManyToOne
        private Course course;

        Student getStudent() {
            return student;
        }

        void setStudent(Student student) {
            this.student = student;
        }

        Course getCourse() {
            return course;
        }

        void setCourse(Course course) {
            this.course = course;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            StudentCourseId sci = (StudentCourseId) o;

            return (student != null ? student.equals(sci.student) : sci.student == null)
                    && (course != null ? course.equals(sci.course) : sci.course == null);
        }

        @Override
        public int hashCode() {
            int result;
            result = (student != null ? student.hashCode() : 0);
            result = 31 * result + (course != null ? course.hashCode() : 0);
            return result;
        }
    }

    @Id private Student student;
    @Id private Course course;

    private float grade;

}
