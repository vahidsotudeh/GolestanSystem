package ir.sbu.golestan.repository;

import ir.sbu.golestan.domain.SubGroup;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Ali Asghar on 22/05/2017.
 */
@RepositoryRestResource(path = "sub_groups")
public interface SubGroupRepository extends PagingAndSortingRepository<SubGroup,Long > {
}
