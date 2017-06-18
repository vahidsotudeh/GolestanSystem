package ir.sbu.golestan.repository;

import ir.sbu.golestan.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;


/**
 * Created by Ali Asghar on 17/05/2017.
 */

public interface UserRepository extends PagingAndSortingRepository<User,Long>{
    User findByUserName(@Param("userName") String userName);
    User findByEmail(String email);

}
