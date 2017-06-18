package ir.sbu.golestan.controller;

import ir.sbu.golestan.service.AbstractPagingAndSortingEntityService;
import ir.sbu.golestan.util.PageHelper;
import ir.sbu.golestan.util.PageParams;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Ali Asghar on 11/06/2017.
 */
@CrossOrigin(origins = "*")
@EnableSwagger2
public abstract class AbstractPagingAndSortingController<E, D> {
    AbstractPagingAndSortingEntityService<E> s;

    @Autowired
    PageHelper ph;
    @Autowired
    ModelMapper modelMapper;

    Class<D> dClass;
    Class<E> eClass;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<D>> getList(@RequestParam("start") Optional<String> start,
                                     @RequestParam("size") Optional<String> size,
                                     @RequestParam("sortBy") Optional<String> sortBy,
                                     @RequestParam("sortDir") Optional<String> sortDir){
        if(!hasReadPermission()){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
        PageParams pageParams = ph.parse(start, size, sortBy, sortDir);
        List<E> list = s.getList(pageParams);
        List<D> response = list.stream().map(this::convertToDto).collect(Collectors.toList());
        return  ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<D> getLecture(@PathVariable("id") Long id){
        if(!hasReadPermission()){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(convertToDto(s.get(id)));
    }

    @RequestMapping(value = "delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        if(!hasDeletePermission()){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
        try {
            s.delete(id);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("entity doesn't exists");
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE)
    public ResponseEntity<String> addLecture(@RequestBody D dto){
        if(!hasCreatePermission()){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
        if(s.add(convertToEntity(dto))) {
            return ResponseEntity.status(HttpStatus.CREATED).body("entity created successfully");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("couldn't add entity");
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<String> update(@RequestBody D dto){
        if(!hasUpdatePermission()){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
        if(s.update(convertToEntity(dto))) {
            return ResponseEntity.status(HttpStatus.CREATED).body("entity updated successfully");
        }else{
            return ResponseEntity.status(HttpStatus.CREATED).body("couldn't update entity");
        }
    }

    protected D convertToDto(E e) {
        return modelMapper.map(e, dClass);
    }

    protected E convertToEntity(D d){
        return modelMapper.map(d, eClass);
    }


    protected boolean hasReadPermission(){
        return hasPermission("READ_" + eClass.getSimpleName().toUpperCase());
    }

    protected boolean hasUpdatePermission(){
        return hasPermission("UPDATE_" + eClass.getSimpleName().toUpperCase());
    }

    protected boolean hasDeletePermission(){
        return hasPermission("DELETE_" + eClass.getSimpleName().toUpperCase());
    }

    protected boolean hasCreatePermission(){
        return hasPermission("CREATE_" + eClass.getSimpleName().toUpperCase());
    }

    protected boolean hasPermission(String permission) {
        Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>)
                SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        boolean hasPermission = false;
        for (GrantedAuthority authority : authorities) {
            hasPermission = authority.getAuthority().equals(permission);
            if (hasPermission) {
                break;
            }
        }
        return hasPermission;
    }
}
