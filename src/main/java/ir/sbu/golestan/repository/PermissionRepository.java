package ir.sbu.golestan.repository;

import ir.sbu.golestan.domain.Permission;

/**
 * Created by Ali Asghar on 21/05/2017.
 */
public interface PermissionRepository extends PagingAndSortingRepositoryWithSpecifications<Permission, Long> {
    Permission findByName(String name);
}
