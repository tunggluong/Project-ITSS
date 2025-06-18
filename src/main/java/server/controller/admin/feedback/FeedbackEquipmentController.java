package server.controller.admin.feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import server.model.Feedback;
import server.service.EquipmentService;
import server.service.FeedbackEquipmentService;

import java.util.List;

@Controller
@RequestMapping("/feedback")
public class FeedbackEquipmentController {
    @Autowired
    private FeedbackEquipmentService feedbackEquipmentService;

    @Autowired
    private EquipmentService EquipmentService;

    @RequestMapping("/selFeedbackEquipment")
    public String selectFeedbackEquipment(Model model) {
        List<Feedback> feedbackEquipmentList = feedbackEquipmentService.findAll();
        model.addAttribute("feedbackEquipmentList", feedbackEquipmentList);
        return "admin/selectFeedbackEquipment";
    }

    // Jump to the new Equipment page
    @RequestMapping("/toViewFeedbackEquipment")
    public String toViewFeedbackEquipment(Integer equipmentId, Model model) {
        List<Feedback> feedbackEquipmentList = feedbackEquipmentService.selectByEquipmentId(equipmentId);
        model.addAttribute("feedbackEquipmentList", feedbackEquipmentList);
        return "admin/selectFeedbackEquipment";
    }
}
