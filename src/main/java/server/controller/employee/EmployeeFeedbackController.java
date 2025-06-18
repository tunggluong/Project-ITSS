package server.controller.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import server.model.Employee;
import server.model.Feedback;
import server.service.FeedbackEmployeeService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/staff")
public class EmployeeFeedbackController {

    @Autowired
    private FeedbackEmployeeService feedbackEmployeeService;

    @RequestMapping("/selFeedback")
    public String selectFeedback(Model model, HttpSession session) {
        Employee employee = (Employee) session.getAttribute("employee");
        model.addAttribute("employee", employee);
        Integer employeeId = employee.getEmployeeId();
        List<Feedback> feedbackEmployeeList = feedbackEmployeeService.selectByEmployeeId(employeeId);
        model.addAttribute("feedbackEmployeeList", feedbackEmployeeList);
        return "employee/selectFeedback";
    }
}
