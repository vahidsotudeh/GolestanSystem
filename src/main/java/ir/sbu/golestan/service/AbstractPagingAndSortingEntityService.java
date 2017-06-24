package ir.sbu.golestan.service;

import ir.sbu.golestan.repository.PagingAndSortingRepositoryWithSpecifications;
import ir.sbu.golestan.util.PageHelper;
import ir.sbu.golestan.util.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Ali Asghar on 11/06/2017.
 */
public abstract class AbstractPagingAndSortingEntityService<E> {
    PagingAndSortingRepositoryWithSpecifications r;

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
        try {
            Long id = (long)e.getClass().getMethod("getId").invoke(e);
            if(r.exists(id)) {
                return add(e);
            }
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e1) {
            e1.printStackTrace();
        }
        throw new NoSuchElementException("This entity doesn't exist");
    }

    public E get(Long id){
        return (E) r.findOne(id);
    }

}
