package ir.sbu.golestan.repository;

import ir.sbu.golestan.domain.Group;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Ali Asghar on 22/05/2017.
 */

public interface GroupRepository extends PagingAndSortingRepository<Group,Long > {
}
