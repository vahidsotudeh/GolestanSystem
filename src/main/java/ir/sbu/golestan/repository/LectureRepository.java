package ir.sbu.golestan.repository;

import ir.sbu.golestan.domain.Lecture;
import ir.sbu.golestan.domain.Master;

import java.util.List;

/**
 * Created by Ali Asghar on 22/05/2017.
 */
public interface LectureRepository extends PagingAndSortingRepositoryWithSpecifications<Lecture, Long>{
    List<Lecture> findByMaster(Master master);
}
