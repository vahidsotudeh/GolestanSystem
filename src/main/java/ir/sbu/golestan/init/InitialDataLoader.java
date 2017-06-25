package ir.sbu.golestan.init;

import ir.sbu.golestan.domain.*;
import ir.sbu.golestan.repository.*;
import jersey.repackaged.com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Date;

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
    private final StudentRepository studentRepository;
    private final LectureTimeRepository lectureTimeRepository;


    @Autowired
    public InitialDataLoader(UserRepository userRepository, RoleRepository roleRepository, PermissionRepository permissionRepository, CourseRepository courseRepository, GroupRepository groupRepository, TermRepository termRepository, LectureRepository lectureRepository, MasterRepository masterRepository, StudentRepository studentRepository, LectureTimeRepository lectureTimeRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.permissionRepository = permissionRepository;
        this.courseRepository = courseRepository;
        this.groupRepository = groupRepository;
        this.termRepository = termRepository;
        this.lectureRepository = lectureRepository;
        this.masterRepository = masterRepository;
        this.studentRepository = studentRepository;
        this.lectureTimeRepository = lectureTimeRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (alreadySetup)
            return;

        //adding roles and permissions
        if(!permissionRepository.findAll().iterator().hasNext()){
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


            Permission p33 = new Permission("READ_STUDENTLECTURE");
            Permission p34 = new Permission("CREATE_STUDENTLECTURE");
            Permission p35 = new Permission("UPDATE_STUDENTLECTURE");
            Permission p36 = new Permission("DELETE_STUDENTLECTURE");

            Permission p37 = new Permission("READ_TERM");
            Permission p38 = new Permission("CREATE_TERM");
            Permission p39 = new Permission("UPDATE_TERM");
            Permission p40 = new Permission("DELETE_TERM");

            Permission p41 = new Permission("READ_LECTURETIME");
            Permission p42 = new Permission("CREATE_LECTURETIME");
            Permission p43 = new Permission("UPDATE_LECTURETIME");
            Permission p44 = new Permission("DELETE_LECTURETIME");

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
            permissionRepository.save(p41);
            permissionRepository.save(p42);
            permissionRepository.save(p43);
            permissionRepository.save(p44);

            Role gr = new Role(Role.RoleTypes.GROUP_MANAGER.name());
            gr.setPermissions(Sets.newHashSet(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13,
                    p14, p15, p16, p17, p18, p19, p20, p21, p22, p23, p24, p25, p26, p27, p28, p29
                    ,p30, p31, p32, p33, p34, p35, p36, p37, p38, p39, p40, p41, p42, p43, p44));
            roleRepository.save(gr);

            Role sr = new Role(Role.RoleTypes.STUDENT.name());
            sr.setPermissions(Sets.newHashSet(p1, p3, p5, p6, p7, p21, p25, p29, p31, p33, p34, p35, p37, p41));
            roleRepository.save(sr);

            Role mr = new Role(Role.RoleTypes.MASTER.name());
            mr.setPermissions(Sets.newHashSet(p1, p3, p5, p7, p9, p13, p25,p17, p19, p21, p33, p35, p37, p39, p41));
            roleRepository.save(mr);


        }


        //adding super user
        if(userRepository.findByUserName("nazemi") == null){
            User groupManager = new User();
            groupManager.setRoles(Sets.newHashSet(roleRepository.findByName(Role.RoleTypes.GROUP_MANAGER.name()),
                    roleRepository.findByName(Role.RoleTypes.MASTER.name())));
            groupManager.setFirstName("Islam");
            groupManager.setLastName("Nazemi");
            groupManager.setPassword("gm");
            groupManager.setEmail("nazemi@gmail.com");
            groupManager.setUserName("nazemi");
            groupManager.setEnabled(true);
            userRepository.save(groupManager);
        }

        //adding default groups
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

        //sample courses
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

        //sampleTerms
        if(!termRepository.findAll().iterator().hasNext()){
            int year = 1380;
            for (int i = 0; i < 50; i++) {
                Term term = new Term();
                term.setYear(year);
                term.setSemester(i%2 == 0? 1:2);
                termRepository.save(term);
                if(i%2 != 0){
                    year++;
                }

            }
        }

        //sample masters
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
                master.setRoles(Sets.newHashSet(roleRepository.findByName(Role.RoleTypes.MASTER.name())));
                masterRepository.save(master);
            }

        }

        //sample lectures
        if(!lectureRepository.findAll().iterator().hasNext()){
            Date date1 = new Date();
            date1.setHours(13);
            date1.setMinutes(30);

            Date date2 = new Date();
            date2.setHours(15);
            date2.setMinutes(0);
            for (int i = 0; i < 50; i++) {
                Lecture lecture = new Lecture();
                lecture.setId(i + 1);
                lecture.setCode("12");
                lecture.setCourse(courseRepository.findOne((long) i + 1));
                lecture.setMaster(masterRepository.findOne((long) (i + 1)));
                lecture.setRoomNumber(100 + i);
                lecture.setTerm(termRepository.findOne((long) 1));

                LectureTime lectureTime1 = new LectureTime();
                lectureTime1.setDay(LectureTime.Days.Monday.name());
                lectureTime1.setStartHour(date1);
                lectureTime1.setEndHour(date2);
                lectureTimeRepository.save(lectureTime1);

                LectureTime lectureTime2 = new LectureTime();
                lectureTime2.setDay(LectureTime.Days.Saturday.name());
                lectureTime2.setStartHour(date1);
                lectureTime2.setEndHour(date2);
                lectureTimeRepository.save(lectureTime2);


                lecture.setLectureTimes(Sets.newHashSet(lectureTime1, lectureTime2));
                lectureRepository.save(lecture);
            }
        }


        //sample student
        if(!studentRepository.findAll().iterator().hasNext()) {
            Role sr = roleRepository.findByName(Role.RoleTypes.STUDENT.name());
            Student student = new Student();
            student.setRoles(Sets.newHashSet(sr));
            student.setFirstName("Ali");
            student.setLastName("Taghizadeh");
            student.setPassword("st");
            student.setEmail("ali@gmail.com");
            student.setUserName("92213055");
            student.setEnabled(true);
            student.setEntranceDate(new Date());
            student.setLevel(Student.StudentLevelTypes.BACHELOR.name());

            StudentLecture sl = new StudentLecture();
            sl.setLecture(lectureRepository.findOne((long) 1));
            sl.setStudent(student);
            student.getStudentLectures().add(sl);
            sl = new StudentLecture();
            sl.setLecture(lectureRepository.findOne((long) 2));
            sl.setStudent(student);
            student.getStudentLectures().add(sl);
            sl = new StudentLecture();
            sl.setLecture(lectureRepository.findOne((long) 3));
            sl.setStudent(student);
            student.getStudentLectures().add(sl);
            sl = new StudentLecture();
            sl.setLecture(lectureRepository.findOne((long) 4));
            sl.setStudent(student);
            student.getStudentLectures().add(sl);
            sl = new StudentLecture();
            sl.setLecture(lectureRepository.findOne((long) 5));
            sl.setStudent(student);
            student.getStudentLectures().add(sl);

            userRepository.save(student);

        }

        alreadySetup = true;
    }

    @Transactional
    private Role createRoleIfNotFound(String name) {
        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role(name);
            roleRepository.save(role);
        }
        return role;
    }
}
