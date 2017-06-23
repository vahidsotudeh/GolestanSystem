package ir.sbu.golestan.service;

import ir.sbu.golestan.domain.Lecture;
import ir.sbu.golestan.domain.Term;
import ir.sbu.golestan.domain.User;
import ir.sbu.golestan.repository.LectureRepository;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Created by Ali Asghar on 18/06/2017.
 */
@Component
@Service
public class LectureService extends AbstractPagingAndSortingEntityService {
    @Autowired
    public LectureService(LectureRepository repository) {
        super.r = repository;
    }

    public float getAvg(User user, Term term) {
        Iterable<Lecture> lectures = ((LectureRepository) r).findAll();
        return 0;
    }

    public static Specification<Lecture> currentUserTermLecutures(User user, Term term) {
        return new Specification<Lecture>() {
            @Override
            public Predicate toPredicate(Root<Lecture> root, CriteriaQuery<?> criteriaQuery,
                                         CriteriaBuilder criteriaBuilder) {
//                return criteriaBuilder.equal(root.get);
                return null;
            }
        };
    }
}
