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
    public UserService(UserRepository userRepository){
        super.r = userRepository;
    }
}
