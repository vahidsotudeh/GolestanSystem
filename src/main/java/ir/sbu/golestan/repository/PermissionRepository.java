package ir.sbu.golestan.repository;

import ir.sbu.golestan.domain.Permission;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Ali Asghar on 21/05/2017.
 */
public interface PermissionRepository extends CrudRepository<Permission, Long> {
    Permission findByName(String name);
}
