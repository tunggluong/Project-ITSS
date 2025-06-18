package server.mapper;

import server.model.FeedbackEquipment;
import server.model.Feedback;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FeedbackEquipmentMapper {

    List<Feedback> findAll();

    Boolean deleteByFeedbackId(Integer feedbackId);

    Boolean insertFeedbackEquipment(Feedback feedback);

    Boolean updateByFeedbackId(Feedback feedback);

    List<Feedback> selectByFeedbackId(Integer feedbackId);

    List<Feedback> selectByMemberAccount(String memberAccount);

    List<Feedback> selectByEquipmentId(Integer EquipmentId);
}
