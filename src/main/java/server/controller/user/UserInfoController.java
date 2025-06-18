package server.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import server.model.Employee;
import server.model.FeedbackEmployee;
import server.model.Member;
import server.service.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private MemberService memberService;

    // Jump to personal information page
    @RequestMapping("/toUserInfo")
    public String toUserInformation(Model model, HttpSession session) {
        Member member = (Member) session.getAttribute("user");
        model.addAttribute("member", member);
        return "user/userInformation";
    }

    // Jump to modify personal information page
    @RequestMapping("/toUpdateInfo")
    public String toUpdateUserInformation(HttpSession session, Model model) {
        Member member1 = (Member) session.getAttribute("user");
        List<Member> member = memberService.selectByMemberAccount(member1.getMemberAccount());
        model.addAttribute("member", member.get(0));
        return "user/updateUserInformation";
    }

    // Modify Personal Information
    @RequestMapping("/updateInfo")
    public String updateUserInformation(HttpSession session, Member member) {
        Member member1 = (Member) session.getAttribute("user");
        member.setMemberAccount(member1.getMemberAccount());
        memberService.updateMemberByMemberAccount(member);
        return "user/userInformation";
    }
}

