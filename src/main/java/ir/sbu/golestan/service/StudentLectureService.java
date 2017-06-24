package ir.sbu.golestan.service;

import ir.sbu.golestan.domain.*;
import ir.sbu.golestan.repository.StudentLectureRepository;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.*;
import java.util.List;

/**
 * Created by Ali Asghar on 18/06/2017.
 */
@Service
@Component
public class StudentLectureService extends AbstractPagingAndSortingEntityService<StudentLecture> {
    @Autowired
    public StudentLectureService(StudentLectureRepository repository) {
        super.r = repository;
    }

    public float getAvg(User user, Term term) {
        List<StudentLecture> studentLectures = r.findAll(new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Join<StudentLecture, Lecture> j1 = root.join("lecture");
                Join<Lecture, Term> j2 = j1.join("term");
                Predicate termPredicate = criteriaBuilder.equal(j2.get("id"), term.getId());
                Join<StudentLecture, Student> j3 = root.join("student");
                Predicate studentPredicate = criteriaBuilder.equal(j3.get("id"), user.getId());
                return criteriaBuilder.and(termPredicate, studentPredicate);
            }
        });

        float gradeSum = 0;
        float unitSum = 0;
        for (StudentLecture sl : studentLectures) {
            int unit = sl.getLecture().getCourse().getPracticalUnitCount() + sl.getLecture().getCourse().getTheoreticalUnitCount();
            gradeSum += sl.getGrade() * unit;
            unitSum += unit;
        }
        return gradeSum / unitSum;
    }
}
