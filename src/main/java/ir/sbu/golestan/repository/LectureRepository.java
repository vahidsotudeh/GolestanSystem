package ir.sbu.golestan.repository;

import ir.sbu.golestan.domain.Lecture;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 * Created by Ali Asghar on 22/05/2017.
 */

@RepositoryRestResource(path = "lectures")
@PreAuthorize("hasRole(GROUP_MANAGER)")
public interface LectureRepository extends PagingAndSortingRepository<Lecture, Long> {
}
