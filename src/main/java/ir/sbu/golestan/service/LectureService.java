package ir.sbu.golestan.service;

import ir.sbu.golestan.domain.*;
import ir.sbu.golestan.repository.LectureRepository;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.*;
import java.util.List;

/**
 * Created by Ali Asghar on 18/06/2017.
 */
@Component
@Service
public class LectureService extends AbstractPagingAndSortingEntityService<Lecture> {
    @Autowired
    public LectureService(LectureRepository repository) {
        super.r = repository;
    }


    public int getAdoptedUnits(User user, Term term){
        List<Lecture> lectures = r.findAll(new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder builder) {
                Join<Lecture, StudentLecture> join1 = root.join("studentLectures");
                Join<StudentLecture, Student> join2 = join1.join("student");
                Predicate studentPredicate = builder.equal(join2.get("id"), user.getId());

                Join<Lecture, Term> join3 = root.join("term");
                Predicate termPredicate = builder.equal(join3.get("id"), term.getId());
                return builder.and(studentPredicate, termPredicate);
            }
        });
        int unitCount = 0;
        for (Lecture l :
                lectures) {
            unitCount += l.getCourse().getPracticalUnitCount() + l.getCourse().getTheoreticalUnitCount();
        }
        return unitCount;
    }

}
