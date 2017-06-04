package ir.sbu.golestan.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Created by Ali Asghar on 05/06/2017.
 */
@Component
public class PageHelper {
    public PageParams parse(Optional<String> page, Optional<String> size
            , Optional<String> sortBy, Optional<String> sortDir){
        int p = 0;
        int s = 0;
        String sb = null;
        String sd = null;
        try{
            p = Integer.valueOf(page.get());
        }catch (NoSuchElementException ignored) {

        }
        try{
            s = Integer.valueOf(size.get());
        }catch (NoSuchElementException ignored) {

        }
        try{
            sb = sortBy.get();
        }catch (NoSuchElementException ignored) {

        }
        try{
            sd = sortDir.get();
        }catch (NoSuchElementException ignored) {

        }
        return new PageParams(p, s, sb, sd);
    }

    public PageRequest getPageRequest(PageParams pageParams){
        if(pageParams.getSize() != 0 && pageParams.getSortBy() != null && pageParams.getDir() != null){
            return new PageRequest(pageParams.getPage(), pageParams.getSize()
                    , Sort.Direction.fromString(pageParams.getDir()), pageParams.getSortBy());

        }else if(pageParams.getSize() == 0 && pageParams.getDir() != null && pageParams.getSortBy() != null){
            return new PageRequest(0, Integer.MIN_VALUE
                    , Sort.Direction.fromString(pageParams.getDir()), pageParams.getSortBy());
        }
        else if(pageParams.getSize() != 0){
            return new PageRequest(pageParams.getPage(), pageParams.getSize());
        }else {
            return null;
        }
    }
}
