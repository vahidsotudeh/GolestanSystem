package ir.sbu.golestan.service;

import ir.sbu.golestan.util.PageHelper;
import ir.sbu.golestan.util.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by Ali Asghar on 11/06/2017.
 */
public abstract class AbstractPagingAndSortingEntityService<E> {
    PagingAndSortingRepository r;

    @Autowired
    PageHelper ph;

    public List<E> getList(PageParams pageParams){
        PageRequest pageRequest = ph.getPageRequest(pageParams);
        return r.findAll(pageRequest).getContent();
    }

    public boolean delete(Long id){
        if(r.exists(id)){
            r.delete(id);
            return true;
        }
        return false;
    }

    public  boolean add(E e){
        try{
            r.save(e);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return false;
    }

    public boolean update(E e){
        return add(e);
    }

    public E get(Long id){
        return (E) r.findOne(id);
    }
}
