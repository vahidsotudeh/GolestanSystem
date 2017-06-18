package ir.sbu.golestan.service;

import ir.sbu.golestan.repository.MasterRepository;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Ali Asghar on 18/06/2017.
 */
@Service
@Component
public class MasterService extends AbstractPagingAndSortingEntityService {

    @Autowired
    public MasterService(MasterRepository repository){
        super.r = repository;
    }

}
