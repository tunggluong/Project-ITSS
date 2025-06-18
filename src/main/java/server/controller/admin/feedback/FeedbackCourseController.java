package server.controller.admin.feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import server.model.Feedback;
import server.service.CourseService;
import server.service.FeedbackCourseService;

import java.util.List;

@Controller
@RequestMapping("/feedback")
public class FeedbackCourseController {
    @Autowired
    private FeedbackCourseService feedbackCourseService;

    @Autowired
    private CourseService courseService;

    @RequestMapping("/selFeedbackCourse")
    public String selectFeedbackCourse(Model model) {
        List<Feedback> feedbackCourseList = feedbackCourseService.findAll();
        model.addAttribute("feedbackCourseList", feedbackCourseList);
        return "admin/selectFeedbackCourse";
    }

    // Jump to the new course page
    @RequestMapping("/toViewFeedbackCourse")
    public String toViewFeedbackCourse(Integer courseId, Model model) {
        List<Feedback> feedbackCourseList = feedbackCourseService.selectByCourseId(courseId);
        model.addAttribute("feedbackCourseList", feedbackCourseList);
        return "admin/selectFeedbackCourse";
    }
}
