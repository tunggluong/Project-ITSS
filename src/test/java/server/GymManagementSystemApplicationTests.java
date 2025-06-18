package server;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import server.mapper.AdminMapper;
import server.mapper.CourseMapper;
import server.mapper.CourseOrderMapper;
import server.mapper.EmployeeMapper;
import server.mapper.EquipmentMapper;
import server.mapper.FeedbackCourseMapper;
import server.mapper.FeedbackEmployeeMapper;
import server.mapper.FeedbackEquipmentMapper;
import server.mapper.FeedbackRoomMapper;
import server.mapper.MemberMapper;
import server.mapper.RoomMapper;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class GymManagementSystemApplicationTests {

    @Autowired
    AdminMapper adminMapper;
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    CourseOrderMapper courseOrderMapper;
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    EquipmentMapper equipmentMapper;
    @Autowired
    FeedbackCourseMapper feedbackCourseMapper;
    @Autowired
    FeedbackEmployeeMapper feedbackEmployeeMapper;
    @Autowired
    FeedbackEquipmentMapper feedbackEquipmentMapper;
    @Autowired
    FeedbackRoomMapper feedbackRoomMapper;
    @Autowired
    MemberMapper memberMapper;
    @Autowired
    RoomMapper roomMapper;

    @Test
    void contextLoads() {
        assertNotNull(adminMapper);
        assertNotNull(courseMapper);
        assertNotNull(courseOrderMapper);
        assertNotNull(employeeMapper);
        assertNotNull(equipmentMapper);
        assertNotNull(feedbackCourseMapper);
        assertNotNull(feedbackEmployeeMapper);
        assertNotNull(feedbackEquipmentMapper);
        assertNotNull(feedbackRoomMapper);
        assertNotNull(memberMapper);
        assertNotNull(roomMapper);
    }
}
