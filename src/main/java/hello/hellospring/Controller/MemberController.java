package hello.hellospring.Controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

//Controller 생성시 controller 객체 생성후 Spring contailner에 담김
// == Spring Bean 생성 이라함.
// 등록하면 Spring Container 로 부터 Controller를 받아서 써야함.

@Controller
public class MemberController {
    private final MemberService memberService;

    // 생성자 주입 -> 요즘 국룰
    // Autowired는 Spring container로 부터 memberService 객체(Bean)를 가져와 Controller와 연결 시켜줌
    @Autowired // Dependency Injection
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
        System.out.println("class : " + memberService.getClass());
    }
    // 필드 주입
    // @Autowired private MemberService memberService;

    // Setter 주입 -> setter 가 public 에 노출 되므로 위험함.
    // 한번 Setting되면 바꾸는 경우가 거의 없으므로 필요 없는듯.
    /*@Atuowired
    publid void setMemberController(MemberService memberService) {
        this.memberService = memberService;
    }
     */

    //get 요청 처리
    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    //post 요청 처리
    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
       List<Member> members =  memberService.findMembers();
       model.addAttribute("members",members);
       return "members/memberList";
    }







}
