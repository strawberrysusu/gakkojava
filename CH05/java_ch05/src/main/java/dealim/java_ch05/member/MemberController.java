package dealim.java_ch05.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    public MemberController() {
        System.out.println("MemberController()");
    }

    @RequestMapping("/signUp")
    public String signUp() {
        return "sign_up";
    }

    @RequestMapping("/signIn")
    public String signIn() {
        return "sign_in";
    }

    @RequestMapping("/signUpConfirm")
    public String signUpConfirm(MemberVo memberVo) {
        System.out.println("MemberController::signUpConfirm()");

        System.out.println("id: " + memberVo.getId());
        System.out.println("password: " + memberVo.getPassword());
        System.out.println("email: " + memberVo.getEmail());
        System.out.println("phone: " + memberVo.getPhone());

        memberService.signUpConfirm(memberVo);
        return "sign_up_ok";
    }

    @RequestMapping("/signInConfirm")
    public String signInConfirm(MemberVo memberVo) {
        System.out.println("MemberController::signInConfirm()");

        System.out.println("id: " + memberVo.getId());
        System.out.println("password: " + memberVo.getPassword());
        System.out.println("email: " + memberVo.getEmail());
        System.out.println("phone: " + memberVo.getPhone());

        if (memberService.signInConfirm(memberVo) != null) {
            return "sign_in_ok";
        } else {
            return "sign_in_ng";
        }
    }
}
