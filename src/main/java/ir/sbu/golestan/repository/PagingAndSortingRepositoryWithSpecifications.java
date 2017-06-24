package ir.sbu.golestan.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

/**
 * Created by Ali Asghar on 24/06/2017.
 */
@NoRepositoryBean
public interface PagingAndSortingRepositoryWithSpecifications<T, ID extends Serializable>
        extends PagingAndSortingRepository<T, ID>
        , JpaSpecificationExecutor<T> {
}
