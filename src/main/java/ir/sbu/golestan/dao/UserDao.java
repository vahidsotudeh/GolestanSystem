package ir.sbu.golestan.dao;

import ir.sbu.golestan.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;


/**
 * Created by Ali Asghar on 17/05/2017.
 */

@Transactional
@RepositoryRestResource(path = "users")
public interface UserDao extends PagingAndSortingRepository<User,Long>{
    User findByUserName(@Param("userName") String userName);
}
