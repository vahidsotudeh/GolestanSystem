package ir.sbu.golestan.repository;

import ir.sbu.golestan.domain.Lecture;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by Ali Asghar on 22/05/2017.
 */
public interface LectureRepository extends PagingAndSortingRepositoryWithSpecifications
        <Lecture, Long>,JpaSpecificationExecutor<Lecture>{

}
