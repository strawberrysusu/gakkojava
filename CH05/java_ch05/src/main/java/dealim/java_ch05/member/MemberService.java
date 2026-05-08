package dealim.java_ch05.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberDao memberDao;

    public int signUpConfirm(MemberVo memberVo) {
        System.out.println("MemberService::signUpConfirm");

        System.out.println("id: " + memberVo.getId());
        System.out.println("password: " + memberVo.getPassword());
        System.out.println("email: " + memberVo.getEmail());
        System.out.println("phone: " + memberVo.getPhone());

        memberDao.insertMember(memberVo);
        return 0;
    }

    public MemberVo signInConfirm(MemberVo memberVo) {
        System.out.println("MemberService::signInConfirm");

        System.out.println("id: " + memberVo.getId());
        System.out.println("password: " + memberVo.getPassword());
        System.out.println("email: " + memberVo.getEmail());
        System.out.println("phone: " + memberVo.getPhone());

        return memberDao.getMember(memberVo);
    }
}
