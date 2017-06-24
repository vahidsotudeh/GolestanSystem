package ir.sbu.golestan.repository;

import ir.sbu.golestan.domain.Group;

/**
 * Created by Ali Asghar on 22/05/2017.
 */

public interface GroupRepository extends PagingAndSortingRepositoryWithSpecifications<Group,Long > {
    Group findByName(String name);
}
