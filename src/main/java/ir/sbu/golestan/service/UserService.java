package ir.sbu.golestan.service;

import ir.sbu.golestan.domain.User;
import ir.sbu.golestan.repository.UserRepository;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Ali Asghar on 11/06/2017.
 */

@Service
@Component
public class UserService extends AbstractPagingAndSortingEntityService<User> {

    @Autowired
    public UserService(UserRepository userRepository) {
        super.r = userRepository;
    }

    public User getByUserName(String username) {
        return ((UserRepository) r).findByUserName(username);
    }

    public User getByEmail(String email){
        return ((UserRepository) r).findByEmail(email);
    }

    public int getPrevTermAvg(String currentUserUserName) {

        return 0;
    }

    public int getAverage(String userName, int year, int semester){

        return 0;
    }
}
