package server.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import server.model.Admin;
import server.model.Employee;
import server.model.Member;
import server.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
public class LoginController {

    @Autowired
    private MemberService memberService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EquipmentService equipmentService;
    @Autowired
    private OrderRecordService orderRecordService;

    // Home-page, jump to login page
    @RequestMapping("/")
    public String toUserLogin(Model model) {
        String msg = (String) model.asMap().get("msg");
        model.addAttribute("msg", msg);
        return "login";
    }

    @RequestMapping("/login")
    public String login(@ModelAttribute("account") String account,
                        @ModelAttribute("password") String password,
                        @ModelAttribute("loginType") String loginType,
                        RedirectAttributes redirectAttributes) {
        switch (loginType) {
            case "admin":
                Admin admin = new Admin();
                admin.setAdminAccount(account);
                admin.setAdminPassword(password);
                redirectAttributes.addFlashAttribute("admin", admin);
                return "redirect:/adminMain";

            case "member":
                Member member = new Member();
                member.setMemberAccount(account);
                member.setMemberPassword(password);
                redirectAttributes.addFlashAttribute("member", member);
                return "redirect:/userMain";

            case "employee":
                Employee employee = new Employee();
                employee.setEmployeeAccount(account);
                employee.setEmployeePassword(password);
                redirectAttributes.addFlashAttribute("employee", employee);
                return "redirect:/staff";

            default:
                return "redirect:/";
        }
    }

    // admin login 
    @RequestMapping("/adminMain")
    public String adminMain(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        Admin admin = (Admin) model.asMap().get("admin");
        Admin admin1 = adminService.adminLogin(admin);
        if (admin1 != null) {
            session.setAttribute("admin", admin1);
        }
        if (session.getAttribute("admin") != null) {
            // number of members
            Integer memberTotal = memberService.selectTotalCount();
            model.addAttribute("memberTotal", memberTotal);
            session.setAttribute("memberTotal", memberTotal);

            // Number of employees
            Integer employeeTotal = employeeService.selectTotalCount();
            model.addAttribute("employeeTotal", employeeTotal);
            session.setAttribute("employeeTotal", employeeTotal);

            // Total number of people
            Integer humanTotal = memberTotal + employeeTotal;
            model.addAttribute("humanTotal", humanTotal);
            session.setAttribute("humanTotal", humanTotal);

            // Number of equipment
            Integer equipmentTotal = equipmentService.selectTotalCount();
            model.addAttribute("equipmentTotal", equipmentTotal);
            session.setAttribute("equipmentTotal", equipmentTotal);

            // Revenue by day (10 days nearest)
            List<Integer> revenueDayList = new ArrayList<>();
            for (int numDay=9; numDay>=0; numDay--) {
                revenueDayList.add(orderRecordService.selectRevenueByNPreviousDay(numDay));
            }
            model.addAttribute("revenueDayList", revenueDayList);
            session.setAttribute("revenueDayList", revenueDayList);

            // Revenue by month (12 months nearest)
            List<Integer> revenueMonthList = new ArrayList<>();
            for (int numMonth=11; numMonth>=0; numMonth--) {
                revenueMonthList.add(orderRecordService.selectRevenueByNPreviousMonth(numMonth));
            }
            model.addAttribute("revenueMonthList", revenueMonthList);
            session.setAttribute("revenueMonthList", revenueMonthList);

            // Revenue by quarter (4 quarters nearest)
            List<Integer> revenueQuarterList = new ArrayList<>();
            for (int numQuarter=3; numQuarter>=0; numQuarter--) {
                revenueQuarterList.add(orderRecordService.selectRevenueByNPreviousQuarter(numQuarter));
            }
            model.addAttribute("revenueQuarterList", revenueQuarterList);
            session.setAttribute("revenueQuarterList", revenueQuarterList);

            // Revenue by year (3 years nearest)
            List<Integer> revenueYearList = new ArrayList<>();
            for (int numYear=2; numYear>=0; numYear--) {
                revenueYearList.add(orderRecordService.selectRevenueByNPreviousYear(numYear));
            }
            model.addAttribute("revenueYearList", revenueYearList);
            session.setAttribute("revenueYearList", revenueYearList);

            return "admin/adminMain";
        }
        else {
            redirectAttributes.addFlashAttribute("msg", "The account or password you entered is wrong, please re-enter");
            return "redirect:/";
        }
    }

    // User Login
    @RequestMapping("/userMain")
    public String userMain(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        Member member = (Member) model.asMap().get("member");
        Member member1 = memberService.userLogin(member);
        if (memberService.userLogin(member) != null) {
            model.addAttribute("member", member1);
            session.setAttribute("user", member1);

        }
        if (session.getAttribute("user") != null) {
            Member member_login = (Member) session.getAttribute("user");
            model.addAttribute("member", member_login);
            return "user/userMain";
        }
        else {
            redirectAttributes.addFlashAttribute("msg", "The account or password you entered is wrong, please re-enter!");
            return "redirect:/";
        }
    }

    @RequestMapping("/staff")
    public String staff(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        Employee employee = (Employee) model.asMap().get("employee");
        Employee employee1 = employeeService.employeeLogin(employee);
        if (employeeService.employeeLogin(employee) != null) {
            model.addAttribute("employee", employee1);
            session.setAttribute("employee", employee1);

        }
        if (session.getAttribute("employee") != null) {
            Employee employee_login = (Employee) session.getAttribute("employee");
            model.addAttribute("employee", employee_login);
            return "employee/employeeMain";
        }
        else {
            redirectAttributes.addFlashAttribute("msg", "The account or password you entered is wrong, please re-enter!");
            return "redirect:/";
        }
    }

    @RequestMapping("/register")
    public String toUserRegistration() {
        return "user/userRegistration";
    }

    @RequestMapping("/userRegistration")
    public String userRegistration(Member member, Model model, HttpSession session) {
        List<Member> memberList = memberService.selectByMemberAccount(member.getMemberAccount());
        if (memberList.isEmpty()) {
            memberService.insertMember(member);
            model.addAttribute("member", member);
            model.addAttribute("msg", "Register successfully!");
            session.setAttribute("user", member);
            return "user/userMain";
        }
        else {
            model.addAttribute("msg", "Duplicate account! Please change your Account!");
            return "user/userRegistration";
        }
    }

    // Jump to admin home page
    @RequestMapping("/toAdminMain")
    public String toAdminMain(Model model, HttpSession session) {
        Integer memberTotal = (Integer) session.getAttribute("memberTotal");
        Integer employeeTotal = (Integer) session.getAttribute("employeeTotal");
        Integer humanTotal = (Integer) session.getAttribute("humanTotal");
        Integer equipmentTotal = (Integer) session.getAttribute("equipmentTotal");
        model.addAttribute("memberTotal", memberTotal);
        model.addAttribute("employeeTotal", employeeTotal);
        model.addAttribute("humanTotal", humanTotal);
        model.addAttribute("equipmentTotal", equipmentTotal);
        return "admin/adminMain";
    }

    // Jump to member home page
    @RequestMapping("/toUserMain")
    public String toUserMain(Model model, HttpSession session) {
        Member member = (Member) session.getAttribute("user");
        model.addAttribute("member", member);
        return "user/userMain";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

}
