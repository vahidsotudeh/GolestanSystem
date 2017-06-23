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

    private boolean alreadySetup = false;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;
    private final CourseRepository courseRepository;
    private final GroupRepository groupRepository;
    private final TermRepository termRepository;
    private final LectureRepository lectureRepository;
    private final MasterRepository masterRepository;

    @Autowired
    public InitialDataLoader(UserRepository userRepository, RoleRepository roleRepository, PermissionRepository permissionRepository, CourseRepository courseRepository, GroupRepository groupRepository, TermRepository termRepository, LectureRepository lectureRepository, MasterRepository masterRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.permissionRepository = permissionRepository;
        this.courseRepository = courseRepository;
        this.groupRepository = groupRepository;
        this.termRepository = termRepository;
        this.lectureRepository = lectureRepository;
        this.masterRepository = masterRepository;
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

            Permission p5 = new Permission("READ_USER");
            Permission p6 = new Permission("CREATE_USER");
            Permission p7 = new Permission("UPDATE_USER");
            Permission p8 = new Permission("DELETE_USER");

            Permission p9 = new Permission("READ_COURSE");
            Permission p10 = new Permission("CREATE_COURSE");
            Permission p11 = new Permission("UPDATE_COURSE");
            Permission p12 = new Permission("DELETE_COURSE");


            Permission p13 = new Permission("READ_GROUP");
            Permission p14 = new Permission("CREATE_GROUP");
            Permission p15 = new Permission("UPDATE_GROUP");
            Permission p16 = new Permission("DELETE_GROUP");

            Permission p17 = new Permission("READ_MASTER");
            Permission p18 = new Permission("CREATE_MASTER");
            Permission p19 = new Permission("UPDATE_MASTER");
            Permission p20 = new Permission("DELETE_MASTER");

            Permission p21 = new Permission("READ_PERMISSION");
            Permission p22 = new Permission("CREATE_PERMISSION");
            Permission p23 = new Permission("UPDATE_PERMISSION");
            Permission p24 = new Permission("DELETE_PERMISSION");

            Permission p25 = new Permission("READ_ROLE");
            Permission p26 = new Permission("CREATE_ROLE");
            Permission p27 = new Permission("UPDATE_ROLE");
            Permission p28 = new Permission("DELETE_ROLE");

            Permission p29 = new Permission("READ_STUDENT");
            Permission p30 = new Permission("CREATE_STUDENT");
            Permission p31 = new Permission("UPDATE_STUDENT");
            Permission p32 = new Permission("DELETE_STUDENT");


            Permission p33 = new Permission("READ_STUDENTCOURSE");
            Permission p34 = new Permission("CREATE_STUDENTCOURSE");
            Permission p35 = new Permission("UPDATE_STUDENTCOURSE");
            Permission p36 = new Permission("DELETE_STUDENTCOURSE");

            Permission p37 = new Permission("READ_TERM");
            Permission p38 = new Permission("CREATE_TERM");
            Permission p39 = new Permission("UPDATE_TERM");
            Permission p40 = new Permission("DELETE_TERM");

            permissionRepository.save(p1);
            permissionRepository.save(p2);
            permissionRepository.save(p3);
            permissionRepository.save(p4);
            permissionRepository.save(p5);
            permissionRepository.save(p6);
            permissionRepository.save(p7);
            permissionRepository.save(p8);
            permissionRepository.save(p9);
            permissionRepository.save(p10);
            permissionRepository.save(p11);
            permissionRepository.save(p12);
            permissionRepository.save(p13);
            permissionRepository.save(p14);
            permissionRepository.save(p15);
            permissionRepository.save(p16);
            permissionRepository.save(p17);
            permissionRepository.save(p18);
            permissionRepository.save(p19);
            permissionRepository.save(p20);
            permissionRepository.save(p21);
            permissionRepository.save(p22);
            permissionRepository.save(p23);
            permissionRepository.save(p24);
            permissionRepository.save(p25);
            permissionRepository.save(p26);
            permissionRepository.save(p27);
            permissionRepository.save(p28);
            permissionRepository.save(p29);
            permissionRepository.save(p30);
            permissionRepository.save(p31);
            permissionRepository.save(p32);
            permissionRepository.save(p33);
            permissionRepository.save(p34);
            permissionRepository.save(p35);
            permissionRepository.save(p36);
            permissionRepository.save(p37);
            permissionRepository.save(p38);
            permissionRepository.save(p39);
            permissionRepository.save(p40);

            Role gr = createRoleIfNotFound(Role.RoleTypes.GROUP_MANAGER.name(), null);
            gr.setPermissions(Sets.newHashSet(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13,
                    p14, p15, p16, p17, p18, p19, p20, p21, p22, p23, p24, p25, p26, p27, p28, p29
                    ,p30, p31, p32, p33, p34, p35, p36, p37, p38, p39, p40));
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

        if(groupRepository.findByName("نرم افزار") == null) {
            Group g1 = new Group();
            g1.setName("نرم افزار");
            groupRepository.save(g1);
        }

        if(groupRepository.findByName("سخت افزار") == null) {
            Group g2 = new Group();
            g2.setName("سخت افزار");
            groupRepository.save(g2);
        }

        if(!courseRepository.findAll().iterator().hasNext()) {
            for (int i = 0; i < 50; i++) {
                Course lecture11 = new Course();
                lecture11.setName("درس " + i);
                lecture11.setPracticalUnitCount(2);
                lecture11.setTheoreticalUnitCount(1);
                lecture11.setCode("41-22-132-11" + i);
                lecture11.setGroups(Sets.newHashSet(groupRepository.findByName("نرم افزار")));
                courseRepository.save(lecture11);

                Course lecture12 = new Course();
                lecture12.setName("درس وابسته" + i);
                lecture12.setPracticalUnitCount(3);
                lecture12.setGroups(Sets.newHashSet(groupRepository.findByName("نرم افزار")));
                lecture12.setCode("41-44-551-11" + i);
                lecture12.setPreRequiredCourses(Sets.newHashSet(lecture11));
                courseRepository.save(lecture12);
            }
        }
        if(!termRepository.findAll().iterator().hasNext()){
            for (int i = 0; i < 50; i++) {
                Term term = new Term();
                term.setYear(1380 + i);
                term.setSemester(i%2 == 0? 1:2);
                termRepository.save(term);
            }
        }

        if(!masterRepository.findAll().iterator().hasNext()){
            for (int i = 0; i < 50; i++) {
                Master master = new Master();
                master.setId(i);
                master.setFirstName("استاد" + i);
                master.setLastName("استادی");
                master.setUserName("ostad" + i);
                master.setPassword("pass" + i);
                master.setEnabled(true);
                master.setEmail("ostad" + i + "@hello.com");
                masterRepository.save(master);
            }

        }


        if(!lectureRepository.findAll().iterator().hasNext()){
            for (int i = 0; i < 50; i++) {
                Lecture lecture = new Lecture();
                lecture.setId(i);
                lecture.setCode("12");
                lecture.setCourse(courseRepository.findOne((long) i + 1));
                lecture.setMaster(masterRepository.findOne((long) (i + 1)));
                lecture.setRoomNumber(100 + i);
                lecture.setTerm(termRepository.findOne((long) i));
                lectureRepository.save(lecture);
            }
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
