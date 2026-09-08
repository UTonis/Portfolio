package spring.member.controller;

import org.springframework.ui.Model;
import spring.member.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import spring.member.service.MemberService;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "/members/register";
    }
    @PostMapping("/members/new")
    public String create(MemberFrom From) {
        Member member = new Member();
        member.setName(From.getName());
        member.setEmail(From.getEmail());
        member.setPassword(From.getPassword());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(){
        return "members/login";
    }

    @PostMapping("/login")
    public String login(LoginFrom From) {
        Member member = new Member();
        member.setEmail(From.getEmail());
        member.setPassword(From.getPassword());

        if(memberService.Login(member.getEmail(), member.getPassword()).isPresent()) {
            System.out.println("로그인 성공");
            return "redirect:/";
        }else{
            System.out.println("로그인 실패");
            return "/members/login";
        }
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "member/memberlist";
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }
}
