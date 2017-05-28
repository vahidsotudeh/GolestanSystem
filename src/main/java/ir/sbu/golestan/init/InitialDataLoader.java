package ir.sbu.golestan.init;

import ir.sbu.golestan.domain.*;
import ir.sbu.golestan.repository.*;
import jersey.repackaged.com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by Ali Asghar on 21/05/2017.
 */
@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private boolean alreadySetup = true;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;
    private final LectureRepository lectureRepository;
    private final SubGroupRepository subGroupRepository;


    @Autowired
    public InitialDataLoader(UserRepository userRepository, RoleRepository roleRepository, PermissionRepository permissionRepository, LectureRepository lectureRepository, SubGroupRepository subGroupRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.permissionRepository = permissionRepository;
        this.lectureRepository = lectureRepository;
        this.subGroupRepository = subGroupRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (alreadySetup)
            return;
        if(userRepository.findByUserName("92213055") == null) {
            Role sr = createRoleIfNotFound(Role.RoleTypes.STUDENT.name(), null);
            User student = new User();
            student.setRoles(Collections.singletonList(sr));
            student.setFirstName("Ali");
            student.setLastName("Taghizadeh");
            student.setPassword("st");
            student.setEmail("ali@google.com");
            student.setUserName("92213055");
            student.setEnabled(true);
            userRepository.save(student);
        }

        SubGroup sg = new SubGroup();
        sg.setName("مهندسی نرم افزار");
        subGroupRepository.save(sg);

        Lecture mabani = new Lecture();
        mabani.setName("مبانی کامپیوتر");
        mabani.setPracticalUnitCount(2);
        mabani.setTheoreticalUnitCount(1);
        mabani.setCode("41-22-132-11");
        mabani.setSubGroups(Sets.newHashSet(sg));
        lectureRepository.save(mabani);


        Lecture ap = new Lecture();
        ap.setName("برنامه نویسی پیشرفته");
        ap.setPracticalUnitCount(3);
        ap.setSubGroups(Sets.newHashSet(sg));
        ap.setCode("41-44-551-11");
        ap.setPreRequiredLectures(Sets.newHashSet(mabani));

        lectureRepository.save(ap);

        alreadySetup = true;
    }

    @Transactional
    private Permission createPermissionIfNotFound(String name) {
        Permission permission = permissionRepository.findByName(name);
        if (permission == null) {
            permission = new Permission(name);
            permissionRepository.save(permission);
        }
        return permission;
    }

    @Transactional
    private Role createRoleIfNotFound(String name, Collection<Permission> permissions) {
        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role(name);
            role.setPermissions(permissions);
            roleRepository.save(role);
        }
        return role;
    }
}
