package ir.sbu.golestan.repository;

import ir.sbu.golestan.domain.Role;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Ali Asghar on 21/05/2017.
 */

public interface RoleRepository extends CrudRepository<Role, Long>{
    Role findByName(String name);
}
