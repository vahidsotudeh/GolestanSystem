package ir.sbu.golestan.repository;

import ir.sbu.golestan.domain.Role;

/**
 * Created by Ali Asghar on 21/05/2017.
 */

public interface RoleRepository extends PagingAndSortingRepositoryWithSpecifications<Role, Long>{
    Role findByName(String name);
}
