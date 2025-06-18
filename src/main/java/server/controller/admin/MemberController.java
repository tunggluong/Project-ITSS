package server.controller.admin;

import server.model.Member;
import server.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    // Query members
    @RequestMapping("/selMember")
    public String selectMember(Model model) {
        List<Member> memberList = memberService.findAll();
        model.addAttribute("memberList", memberList);
        return "admin/selectMember";
    }

    // Jump to the new member page
    @RequestMapping("/toAddMember")
    public String toAddMember() {
        return "admin/addMember";
    }

    // Add new member
    @RequestMapping("/addMember")
    public String addMember(Member member, Model model) {
        List<Member> memberList = memberService.selectByMemberAccount(member.getMemberAccount());
        if (memberList.isEmpty()) {
            memberService.insertMember(member);
            return "redirect:selMember";
        }
        model.addAttribute("msg", "Duplicate account! Please change account!");
        return "admin/addMember";
    }

    // delete member
    @RequestMapping("/delMember")
    public String deleteMember(String memberAccount) {
        memberService.deleteByMemberAccount(memberAccount);
        return "redirect:selMember";
    }

    // Jump to member modification page
    @RequestMapping("/toUpdateMember")
    public String toUpdateMember(String memberAccount, Model model) {
        List<Member> memberList = memberService.selectByMemberAccount(memberAccount);
        model.addAttribute("memberList", memberList);
        return "admin/updateMember";
    }

    // Modify member information
    @RequestMapping("/updateMember")
    public String updateMember(Member member) {
        memberService.updateMemberByMemberAccount(member);
        return "redirect:selMember";
    }

}
