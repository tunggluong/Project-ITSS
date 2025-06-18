package server.mapper;

import server.model.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper {

    // Find all courses
    List<Course> findAll();

    // delete class by id
    Boolean deleteCourseByCourseId(Integer courseId);

    // add course
    Boolean insertCourse(Course course);

    // update course
    Boolean updateCourseByCourseId(Course course);

    // Query the class schedule by id
    Course selectByCourseId(Integer courseId);

    List<Course> selectByEmployeeId(Integer employeeId);

    Boolean acceptCourseByCourseId(Integer courseId);

    // Delete reserved courses according to id
    Boolean deleteOrderByCourseId(Integer courseId);

    List<Course> findRequestedCourses();  // Phương thức này sẽ gọi đến SQL trong CourseMapper.xml

}
