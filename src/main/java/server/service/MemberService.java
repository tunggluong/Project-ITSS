package server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.mapper.MemberMapper;
import server.model.Member;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberMapper memberMapper;

    public List<Member> findAll() {
        return memberMapper.findAll();
    }

    public Boolean insertMember(Member member) {
        return memberMapper.insertMember(member);
    }

    public Boolean updateMemberByMemberAccount(Member member) {
        return memberMapper.updateMemberByMemberAccount(member);
    }

    public Member userLogin(Member member) {
        return memberMapper.selectByAccountAndPassword(member);
    }

    public Boolean deleteByMemberAccount(String memberAccount) {
        return memberMapper.deleteByMemberAccount(memberAccount);
    }

    public Integer selectTotalCount() {
        return memberMapper.selectTotalCount();
    }

    public List<Member> selectByMemberAccount(String memberAccount) {
        return memberMapper.selectByMemberAccount(memberAccount);
    }
}
