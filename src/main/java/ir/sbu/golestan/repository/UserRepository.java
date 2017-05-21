package ir.sbu.golestan.repository;

import ir.sbu.golestan.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


/**
 * Created by Ali Asghar on 17/05/2017.
 */

@RepositoryRestResource(path = "users")
public interface UserRepository extends PagingAndSortingRepository<User,Long>{
    User findByUserName(@Param("userName") String userName);

    User findByEmail(String email);
}
