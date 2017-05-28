package ir.sbu.golestan.repository;

import ir.sbu.golestan.domain.Lecture;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Ali Asghar on 22/05/2017.
 */


public interface LectureRepository extends PagingAndSortingRepository<Lecture, Long> {
}
