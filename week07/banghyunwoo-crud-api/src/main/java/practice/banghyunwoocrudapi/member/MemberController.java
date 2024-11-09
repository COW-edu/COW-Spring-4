package practice.banghyunwoocrudapi.member;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/members/{id}")
    public void signUp(@RequestBody CreateMemberRequest createMemberRequest){
        memberService.signUp(createMemberRequest);
        System.out.println(createMemberRequest.toString());
    }

    @GetMapping("/members/{id}")
    public MemberResponse getMember(@RequestBody MemberResponse memberResponse){
        return memberService.getMember(memberResponse.getId());
    }

    @PutMapping("/members/{id}")
    public void updateMember(@PathVariable("id") String id, @RequestBody Member member){
        memberService.updateMember(id, member);
    }

}