package server.controller.admin.feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import server.model.Feedback;
import server.service.EmployeeService;
import server.service.FeedbackEmployeeService;

import java.util.List;

@Controller
@RequestMapping("/feedback")
public class FeedbackEmployeeController {

    @Autowired
    private FeedbackEmployeeService feedbackEmployeeService;

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/selFeedbackEmployee")
    public String selectFeedbackEmployee(Model model) {
        List<Feedback> feedbackEmployeeList = feedbackEmployeeService.findAll();
        model.addAttribute("feedbackEmployeeList", feedbackEmployeeList);
        return "admin/selectFeedbackEmployee";
    }

    // Jump to the new course page
    @RequestMapping("/toViewFeedbackEmployee")
    public String toViewFeedbackEmployee(Integer employeeId, Model model) {
        List<Feedback> feedbackEmployeeList = feedbackEmployeeService.selectByEmployeeId(employeeId);
        model.addAttribute("feedbackEmployeeList", feedbackEmployeeList);
        return "admin/selectFeedbackEmployee";
    }
}
