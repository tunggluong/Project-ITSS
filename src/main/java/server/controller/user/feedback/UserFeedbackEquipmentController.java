package server.controller.user.feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import server.model.Equipment;
import server.model.FeedbackEquipment;
import server.model.Feedback;
import server.model.Member;
import server.service.EquipmentService;
import server.service.FeedbackEquipmentService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserFeedbackEquipmentController {
    @Autowired
    private FeedbackEquipmentService feedbackEquipmentService;

    @Autowired
    private EquipmentService EquipmentService;

    @RequestMapping("/userFeedbackEquipment")
    public String userFeedbackEquipment(Model model, HttpSession session) {
        Member member = (Member) session.getAttribute("user");
        model.addAttribute("member", member);
        String memberAccount = member.getMemberAccount();
        List<Feedback> feedbackEquipmentList = feedbackEquipmentService.selectByMemberAccount(memberAccount);
        model.addAttribute("feedbackEquipmentList", feedbackEquipmentList);
        return "user/userFeedbackEquipment";
    }

    @RequestMapping("/toAddFeedbackEquipment")
    public String toAddEquipment(Model model) {
        List<Equipment> equipmentList = EquipmentService.findAll();
        model.addAttribute("equipmentList", equipmentList);
        return "user/addFeedbackEquipment";
    }

    @RequestMapping("/addFeedbackEquipment")
    public String addFeedbackEquipment(FeedbackEquipment feedbackEquipment, HttpSession session) {
        Member member = (Member) session.getAttribute("user");
        feedbackEquipment.setMemberAccount(member.getMemberAccount());
        feedbackEquipmentService.insertFeedback(feedbackEquipment);
        return "redirect:userFeedbackEquipment";
    }

    // Jump to the new course page
    @RequestMapping("/delFeedbackEquipment")
    public String deleteFeedbackEquipment(Integer feedbackId) {
        feedbackEquipmentService.deleteByFeedbackId(feedbackId);
        return "redirect:userFeedbackEquipment";
    }

    @RequestMapping("/toUpdateFeedbackEquipment")
    public String toUpdateFeedbackEquipment(Integer feedbackId, Model model) {
        List<Feedback> feedbackEquipmentList = feedbackEquipmentService.selectByFeedbackId(feedbackId);
        model.addAttribute("feedbackEquipmentList", feedbackEquipmentList);
        return "user/updateFeedbackEquipment";
    }
    @RequestMapping("/updateFeedbackEquipment")
    public String updateFeedbackEquipment(FeedbackEquipment feedbackEquipment) {
        feedbackEquipmentService.updateByFeedbackId(feedbackEquipment);
        return "redirect:userFeedbackEquipment";
    }
}
