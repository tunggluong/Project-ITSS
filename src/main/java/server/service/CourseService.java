package server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.mapper.CourseMapper;
import server.model.Course;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseMapper courseMapper;

    public List<Course> findAll() {
        return courseMapper.findAll();
    }

    public Boolean deleteCourseByCourseId(Integer courseId) {
        return courseMapper.deleteCourseByCourseId(courseId);
    }

    public Boolean insertCourse(Course course) {
        return courseMapper.insertCourse(course);
    }

    public Boolean updateCourseByCourseId(Course course) {
        return courseMapper.updateCourseByCourseId(course);
    }

    public Course selectByCourseId(Integer courseId) {
        return courseMapper.selectByCourseId(courseId);
    }

    public List<Course> selectByEmployeeId(Integer employeeId) {
        return courseMapper.selectByEmployeeId(employeeId);
    }

    public Boolean acceptCourseByCourseId(Integer courseId) {
        return courseMapper.acceptCourseByCourseId(courseId);
    }

    public Boolean deleteOrderByCourseId(Integer courseId) {
        return courseMapper.deleteOrderByCourseId(courseId);
    }

    // Thêm phương thức findCourseById
    public Course findCourseById(Integer courseId) {
        return courseMapper.selectByCourseId(courseId);  // Gọi phương thức trong CourseMapper
    }

    // CourseService.java
    public Boolean updateCourse(Course course) {
        return courseMapper.updateCourseByCourseId(course);  // Gọi phương thức update trong CourseMapper
    }

    public List<Course> findRequestedCourses() {
        return courseMapper.findRequestedCourses();  // Gọi đến phương thức trong CourseMapper
    }

}

