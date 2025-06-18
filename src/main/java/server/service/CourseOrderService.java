package server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.mapper.CourseOrderMapper;
import server.model.CourseOrder;

import java.util.List;

@Service
public class CourseOrderService {

    @Autowired
    private CourseOrderMapper courseOrderMapper;

    public List<CourseOrder> findAll() {
        return courseOrderMapper.findAll();
    }

    public Boolean insertCourseOrder(CourseOrder courseOrder) {
        return courseOrderMapper.insertCourseOrder(courseOrder);
    }

    public List<CourseOrder> selectCourseOrderByMemberAccount(String memberAccount) {
        return courseOrderMapper.selectCourseOrderByMemberAccount(memberAccount);
    }

    public Boolean deleteByCourseOrderId(Integer courseOrderId) {
        return courseOrderMapper.deleteByCourseOrderId(courseOrderId);
    }

    public CourseOrder selectMemberByCourseIdAndMemberAccount(Integer courseId, String memberAccount) {
        return courseOrderMapper.selectMemberByCourseIdAndMemberAccount(courseId, memberAccount);
    }

    public List<CourseOrder> selectMemberOrderList(Integer courseId) {
        return courseOrderMapper.selectMemberOrderList(courseId);
    }

    public Boolean updateStatusByOrderId(Integer courseOrderId) {
        return courseOrderMapper.updateStatusByOrderId(courseOrderId);
    }

    public Boolean deleteOrderByOrderId(Integer courseOrderId) {
        return courseOrderMapper.deleteOrderByOrderId(courseOrderId);
    }
}
