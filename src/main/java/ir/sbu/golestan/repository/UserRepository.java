package ir.sbu.golestan.repository;

import ir.sbu.golestan.domain.User;


/**
 * Created by Ali Asghar on 17/05/2017.
 */

public interface UserRepository extends PagingAndSortingRepositoryWithSpecifications<User,Long>{
    User findByUserName(String userName);
    User findByEmail(String email);

}
