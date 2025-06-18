package server.mapper;

import server.model.Feedback;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface FeedbackEmployeeMapper {

    List<Feedback> findAll();

    Boolean deleteByFeedbackId(Integer feedbackId);

    Boolean insertFeedbackEmployee(Feedback feedback);

    Boolean updateByFeedbackId(Feedback feedback);

    List<Feedback> selectByFeedbackId(Integer feedbackId);

    List<Feedback> selectByMemberAccount(String memberAccount);

    List<Feedback> selectByEmployeeId(Integer employeeId);
}
