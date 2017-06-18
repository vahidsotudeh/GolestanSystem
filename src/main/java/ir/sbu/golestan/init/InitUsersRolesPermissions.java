//package ir.sbu.golestan.init;
//
//import ir.sbu.golestan.domain.*;
//import ir.sbu.golestan.repository.PermissionRepository;
//import org.apache.tomcat.jni.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//
///**
// * Created by Ali Asghar on 15/06/2017.
// */
//public class InitUsersRolesPermissions implements ApplicationListener<ContextRefreshedEvent> {
//    private boolean alreadySetup = false;
//
//    @Autowired
//    PermissionRepository permissionRepository;
//
//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//        if(alreadySetup) return;
//        alreadySetup = true;
//        initPermissions();
//        initRoles();
//        initUsers();
//    }
//
//    private void initUsers(){
//
//    }
//
//    private void initRoles(){
//
//    }
//
//    private void addPermissionToRole(Role r, String ... permissions){
//        for (String permission :
//                permissions) {
//            Permission p = permissionRepository.findByName(permission);
//            if(p != null){
//                r.getPermissions().add(p);
//            }
//        }
//    }
//
//    private void initPermissions(){
//        addAllPermissions(Lecture.class.getSimpleName());
//        addAllPermissions(User.class.getSimpleName());
//        addAllPermissions(Course.class.getSimpleName());
//        addAllPermissions(Group.class.getSimpleName());
//        addAllPermissions(Master.class.getSimpleName());
//        addAllPermissions(Permission.class.getSimpleName());
//        addAllPermissions(Role.class.getSimpleName());
//        addAllPermissions(Student.class.getSimpleName());
//        addAllPermissions(StudentCourse.class.getSimpleName());
//        addAllPermissions(Term.class.getSimpleName());
//    }
//
//    private void addAllPermissions(String name){
//        addCreatePermission(name.toUpperCase());
//        addReadPermission(name.toUpperCase());
//        addUpdatePermission(name.toUpperCase());
//        addDeletePermission(name.toUpperCase());
//    }
//
//    private void addReadPermission(String name){
//        addPermissionIfNotExists(getReadPermission(name));
//    }
//
//    private void addCreatePermission(String name){
//        addPermissionIfNotExists(getCreatePersmission(name));
//    }
//
//    private void addDeletePermission(String name){
//        addPermissionIfNotExists(getDeletePermission(name));
//    }
//
//    private void addUpdatePermission(String name){
//        addPermissionIfNotExists(getUpdatePermission(name));
//    }
//
//    private void addPermissionIfNotExists(String name){
//        if(permissionRepository.findByName(name) == null){
//            permissionRepository.save(new Permission(name));
//        }
//    }
//
//    private String getReadPermission(String name){
//        return "READE_"+name;
//    }
//
//    private String getCreatePersmission(String name){
//        return "CREATE_"+name;
//    }
//
//    private String getDeletePermission(String name){
//        return "DELETE_"+name;
//    }
//
//    private String getUpdatePermission(String name){
//        return "UPDATE_"+name;
//    }
//}
