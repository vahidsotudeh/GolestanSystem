package ir.sbu.golestan.init;

import ir.sbu.golestan.domain.*;
import ir.sbu.golestan.repository.*;
import jersey.repackaged.com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Set;

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
            student.setRoles(Sets.newHashSet(sr));
            student.setFirstName("Ali");
            student.setLastName("Taghizadeh");
            student.setPassword("st");
            student.setEmail("ali@gmail.com");
            student.setUserName("92213055");
            student.setEnabled(true);
            userRepository.save(student);

        }


        if(userRepository.findByUserName("nazemi") == null){
            Permission p1 = new Permission("READ_LECTURE");
            Permission p2 = new Permission("CREATE_LECTURE");
            Permission p3 = new Permission("UPDATE_LECTURE");
            Permission p4 = new Permission("DELETE_LECTURE");
            permissionRepository.save(p1);
            permissionRepository.save(p2);
            permissionRepository.save(p3);
            permissionRepository.save(p4);
            Role gr = createRoleIfNotFound(Role.RoleTypes.GROUP_MANAGER.name(), null);
            gr.setPermissions(Sets.newHashSet(p1, p2, p3, p4));
            roleRepository.save(gr);
            User groupManager = new User();
            groupManager.setRoles(Sets.newHashSet(gr));
            groupManager.setFirstName("Islam");
            groupManager.setLastName("Nazemi");
            groupManager.setPassword("gm");
            groupManager.setEmail("nazemi@gmail.com");
            groupManager.setUserName("nazemi");
            groupManager.setEnabled(true);
            userRepository.save(groupManager);
        }

        Group g1 = new Group();
        g1.setName("نرم افزار");
        subGroupRepository.save(g1);

        Group g2 = new Group();
        g2.setName("سخت افزار");
        subGroupRepository.save(g2);

        for(int i = 0; i < 50; i++){
            Lecture lecture1 = new Lecture();
            lecture1.setName("درس " + i);
            lecture1.setPracticalUnitCount(2);
            lecture1.setTheoreticalUnitCount(1);
            lecture1.setCode("41-22-132-11" + i);
            lecture1.setGroups(Sets.newHashSet(g1));
            lectureRepository.save(lecture1);


            Lecture lecture2 = new Lecture();
            lecture2.setName("درس وابسته" + i);
            lecture2.setPracticalUnitCount(3);
            lecture2.setGroups(Sets.newHashSet(g1));
            lecture2.setCode("41-44-551-11" + i);
            lecture2.setPreRequiredLectures(Sets.newHashSet(lecture1));

            lectureRepository.save(lecture2);
        }
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
    private Role createRoleIfNotFound(String name, Set<Permission> permissions) {
        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role(name);
            role.setPermissions(permissions);
            roleRepository.save(role);
        }
        return role;
    }
}
