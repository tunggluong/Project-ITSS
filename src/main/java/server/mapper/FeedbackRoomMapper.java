package server.mapper;

import server.model.Feedback;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FeedbackRoomMapper {

    List<Feedback> findAll();

    Boolean deleteByFeedbackId(Integer feedbackId);

    Boolean insertFeedbackRoom(Feedback feedback);

    Boolean updateByFeedbackId(Feedback feedback);

    List<Feedback> selectByFeedbackId(Integer feedbackId);

    List<Feedback> selectByMemberAccount(String memberAccount);

    List<Feedback> selectByRoomId(Integer RoomId);
}
