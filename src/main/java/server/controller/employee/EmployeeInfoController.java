package server.controller.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import server.model.Employee;
import server.service.EmployeeService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/staff")
public class EmployeeInfoController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/myInfo")
    public String toEmployeeInfo(Model model, HttpSession session) {
        Employee employee = (Employee) session.getAttribute("employee");
        model.addAttribute("employee", employee);
        return "employee/employeeInformation";
    }

    @RequestMapping("/toUpdateInfo")
    public String toUpdateInfo(Model model, HttpSession session) {
        Employee employee = (Employee) session.getAttribute("employee");
        Integer employeeId = employee.getEmployeeId();
        List<Employee> employeeList = employeeService.selectByEmployeeId(employeeId);
        model.addAttribute("employee", employeeList.get(0));
        return "employee/updateEmployeeInformation";
    }

    @RequestMapping("/updateInfo")
    public String updateInfo(Employee employee, HttpSession session) {
        Employee employee1 = (Employee) session.getAttribute("employee");
        Integer employeeId = employee1.getEmployeeId();
        employee.setEmployeeId(employeeId);
        employee.setCoach(true);
        employeeService.updateEmployeeByEmployeeId(employee);
        return "employee/employeeInformation";
    }

}
