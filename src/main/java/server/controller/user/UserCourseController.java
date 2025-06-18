package server.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import server.model.Course;
import server.model.CourseOrder;
import server.model.Member;
import server.service.CourseOrderService;
import server.service.CourseService;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
public class UserCourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseOrderService courseOrderService;

    // Jump to my course page
    @RequestMapping("/toUserCourse")
    public String toUserCourse(Model model, HttpSession session) {
        Member member = (Member) session.getAttribute("user");
        model.addAttribute("member", member);
        String memberAccount = member.getMemberAccount();
        List<CourseOrder> courseOrderList = courseOrderService.selectCourseOrderByMemberAccount(memberAccount);
        model.addAttribute("courseOrderList", courseOrderList);
        return "user/userCourse";
    }

    // Quit course
    @RequestMapping("delUserCourse")
    public String deleteUserCourse(Integer courseOrderId) {
        courseOrderService.deleteByCourseOrderId(courseOrderId);
        return "redirect:toUserCourse";
    }

    // Jump to the registration page
    @RequestMapping("/toApplyCourse")
    public String toUserApplyCourse(Model model, HttpSession session) {
        Member member = (Member) session.getAttribute("user");
        List<Course> courseList = courseService.findAll();
        model.addAttribute("member", member);
        model.addAttribute("courseList", courseList);

        String memberAccount = member.getMemberAccount();
        List<CourseOrder> courseOrderList = courseOrderService.selectCourseOrderByMemberAccount(memberAccount);
        List<Integer> courseOrderIdList = courseOrderList.stream().map(CourseOrder::getCourseId).collect(Collectors.toList());
        model.addAttribute("courseOrderIdList", courseOrderIdList);

        return "user/userApplyCourse";
    }

    // Sign up for courses
    @RequestMapping("/applyCourse")
    public String userApplyCourse(Integer courseId, Model model, HttpSession session) {
        Course course = courseService.selectByCourseId(courseId);
        Member member = (Member) session.getAttribute("user");

        Integer courseId1 = course.getCourseId();
        String courseName = course.getCourseName();
        Integer coachId = course.getCoachId();
        String coachName = course.getCoachName();
        String courseBegin = course.getCourseBegin();
        String memberName = member.getMemberName();
        String memberAccount = member.getMemberAccount();

        CourseOrder courseOrder = new CourseOrder(courseId1, courseName, coachId, coachName, memberAccount, memberName, courseBegin);
        String memberAccount1 = member.getMemberAccount();
        CourseOrder courseOrder1 = courseOrderService.selectMemberByCourseIdAndMemberAccount(courseId1, memberAccount1);

        if (courseOrder1 == null) {
            courseOrderService.insertCourseOrder(courseOrder);
        }

        return "redirect:toUserCourse";
    }
}
