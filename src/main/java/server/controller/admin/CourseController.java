package server.controller.admin;

import server.model.Course;
import server.model.CourseOrder;
import server.model.Employee;
import server.service.CourseOrderService;
import server.service.CourseService;
import server.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseOrderService courseOrderService;

    @Autowired
    private EmployeeService employeeService;

    // Hiển thị danh sách khóa học
    @RequestMapping("/selCourse")
    public String selectCourse(Model model) {
        List<Course> courseList = courseService.findAll();
        model.addAttribute("courseList", courseList);
        return "admin/selectCourse";
    }

    // Hiển thị form chỉnh sửa khóa học
    @RequestMapping("/selCourseUpdate")
    public String showUpdateCourseForm(Integer courseId, Model model) {
        // Lấy thông tin khóa học từ database
        Course course = courseService.findCourseById(courseId);
        // Truyền thông tin khóa học vào form
        model.addAttribute("course", course);
        return "admin/updateCourse";  // Trả về trang updateCourse.html
    }

    // Cập nhật thông tin khóa học
    @RequestMapping("/updateCourse")
    public String updateCourse(Course course) {
        // Cập nhật thông tin khóa học trong database
        courseService.updateCourse(course);
        return "redirect:/course/selCourse";  // Sau khi cập nhật xong, quay lại trang danh sách khóa học
    }

    // Jump to the new course page
    @RequestMapping("/toAddCourse")
    public String toAddCourse(Model model) {
        List<Employee> employeeList = employeeService.findCoaches();
        model.addAttribute("employeeList", employeeList);
        return "admin/addCourse";
    }

    @RequestMapping("/addCourse")
    public String addCourse(Course course) {
        // Nếu coachId không được chọn (null hoặc 0), thì gán null cho coachId
        if (course.getCoachId() == null || course.getCoachId() == 0) {
            course.setCoachId(null);  // Bạn có thể để là null hoặc bất kỳ giá trị mặc định nào
        }

        // Cập nhật trạng thái khóa học thành "accepted"
        course.setStatus("accepted");

        // Kiểm tra xem thông tin khóa học đã hợp lệ chưa (có thể thêm kiểm tra cho các trường khác)
        if (course.getCourseName() == null || course.getCourseBegin() == null || course.getCourseTime() == null || course.getPrice() == null) {
            // Nếu thiếu thông tin cần thiết, trả về một thông báo lỗi
            return "redirect:/course/toAddCourse?error=true";  // Chuyển hướng đến trang add course với thông báo lỗi
        }

        // Thêm khóa học vào cơ sở dữ liệu
        courseService.insertCourse(course);

        // Sau khi thêm khóa học thành công, quay lại danh sách khóa học
        return "redirect:/course/selCourse";
    }



    // Delete course
    @RequestMapping("/delCourse")
    public String deleteCourse(Integer courseId) {
//        courseService.deleteOrderByCourseId(courseId);
        courseService.deleteCourseByCourseId(courseId);
        return "redirect:selCourse";
    }

    @RequestMapping("/selRequestedCourse")
    public String selectRequestedCourse(Model model) {
        List<Course> courseList = courseService.findAll();
        model.addAttribute("courseList", courseList);
        return "admin/selectRequestedCourse";
    }

    // Query course registration information
    @RequestMapping("/selCourseOrder")
    public String selectCourseOrder(Integer courseId, Model model) {
        List<CourseOrder> courseOrderList = courseOrderService.selectMemberOrderList(courseId);
        model.addAttribute("courseOrderList", courseOrderList);
        return "admin/selectCourseOrder";
    }

    @RequestMapping("/acceptCourse")
    public String acceptCourse(Integer courseId) {
        courseService.acceptCourseByCourseId(courseId);
        return "redirect:selCourse";
    }

    @RequestMapping("/updateAcceptCourseOrder")
    public String updateAcceptCourseOrder(Integer courseId, Integer courseOrderId, RedirectAttributes redirectAttributes) {
        courseOrderService.updateStatusByOrderId(courseOrderId);
        redirectAttributes.addAttribute("courseId", courseId);
        return "redirect:selCourseOrder";
    }
}

