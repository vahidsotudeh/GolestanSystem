package ir.sbu.golestan.controller;

import ir.sbu.golestan.domain.Student;
import ir.sbu.golestan.domain.Term;
import ir.sbu.golestan.service.LectureService;
import ir.sbu.golestan.service.TermService;
import ir.sbu.golestan.service.UserService;
import ir.sbu.golestan.util.SecurityHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.QueryParam;

/**
 * Created by Ali Asghar on 22/06/2017.
 */
@RestController
@RequestMapping("api/register")
public class RegisterController {

    @Autowired
    SecurityHelper securityHelper;

    @Autowired
    UserService userService;

    @Autowired
    LectureService lectureService;

    @Autowired
    TermService termService;

    @RequestMapping(value = "/addLecture" , method = RequestMethod.GET)
    public void addLecture(@QueryParam("lectureId") String courseID){
        if(securityHelper.hasUpdatePermission(Student.class.getSimpleName())){
            if(CanAdd(courseID)){

            }else{

            }
        }
    }

    private boolean CanAdd(String courseID) {
        Term term = termService.getPrevTerm();
//        float avg = lectureService.getAvg(securityHelper.getCurrentUserUserName(), term);
        return false;
    }

}
