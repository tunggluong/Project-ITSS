package server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.mapper.FeedbackEmployeeMapper;
import server.model.FeedbackEmployee;
import server.model.Feedback;
import server.service.feedback.FeedbackService;

import java.util.List;

@Service
public class FeedbackEmployeeService implements FeedbackService {

    @Autowired
    private FeedbackEmployeeMapper feedbackMapper;

    @Override
    public List<Feedback> findAll() {
        return feedbackMapper.findAll();
    }

    @Override
    public Boolean deleteByFeedbackId(Integer feedbackId) {
        return feedbackMapper.deleteByFeedbackId(feedbackId);
    }

    @Override
    public Boolean insertFeedback(Feedback feedback) {
        return feedbackMapper.insertFeedbackEmployee(feedback);
    }

    @Override
    public Boolean updateByFeedbackId(Feedback feedback) {
        return feedbackMapper.updateByFeedbackId(feedback);
    }

    @Override
    public List<Feedback> selectByFeedbackId(Integer feedbackId) {
        return feedbackMapper.selectByFeedbackId(feedbackId);
    }

    @Override
    public List<Feedback> selectByMemberAccount(String memberAccount) {
        return feedbackMapper.selectByMemberAccount(memberAccount);
    }

    public List<Feedback> selectByEmployeeId(Integer employeeId) {
        return feedbackMapper.selectByEmployeeId(employeeId);
    }
}
