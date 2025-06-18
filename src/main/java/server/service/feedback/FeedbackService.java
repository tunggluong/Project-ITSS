package server.service.feedback;

import server.model.Feedback;
import server.model.FeedbackCourse;

import java.util.List;

public interface FeedbackService {
    List<Feedback> findAll();

    Boolean deleteByFeedbackId(Integer feedbackId);

    Boolean insertFeedback(Feedback feedback);

    Boolean updateByFeedbackId(Feedback feedback);

    List<Feedback> selectByFeedbackId(Integer feedbackId);

    List<Feedback> selectByMemberAccount(String memberAccount);
}
