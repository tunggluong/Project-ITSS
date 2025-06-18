package server.controller.admin.feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import server.model.Feedback;
import server.service.RoomService;
import server.service.FeedbackRoomService;

import java.util.List;

@Controller
@RequestMapping("/feedback")
public class FeedbackRoomController {
    @Autowired
    private FeedbackRoomService feedbackRoomService;

    @Autowired
    private RoomService RoomService;

    @RequestMapping("/selFeedbackRoom")
    public String selectFeedbackRoom(Model model) {
        List<Feedback> feedbackRoomList = feedbackRoomService.findAll();
        model.addAttribute("feedbackRoomList", feedbackRoomList);
        return "admin/selectFeedbackRoom";
    }

    // Jump to the new Room page
    @RequestMapping("/toViewFeedbackRoom")
    public String toViewFeedbackRoom(Integer roomId, Model model) {
        List<Feedback> feedbackRoomList = feedbackRoomService.selectByRoomId(roomId);
        model.addAttribute("feedbackRoomList", feedbackRoomList);
        return "admin/selectFeedbackRoom";
    }
}