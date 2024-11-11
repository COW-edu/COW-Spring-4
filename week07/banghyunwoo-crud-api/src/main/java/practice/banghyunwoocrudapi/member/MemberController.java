package practice.banghyunwoocrudapi.member;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/members")
    public void signUp(@RequestBody CreateMemberRequest createMemberRequest){
        memberService.signUp(createMemberRequest);
        System.out.println(createMemberRequest.toString());
    }

    @GetMapping("/members/{id}")
    public MemberResponse getMember(@PathVariable String id){
        return memberService.getMember(id);
    }

    @PutMapping("/members/update/{id}")
    public void updateMember(@PathVariable("id") String id, @RequestBody UpdateMemberRequest updateMemberRequest){
        memberService.updateMember(id, updateMemberRequest);
    }

    @DeleteMapping("/members/delete/{id}")
    public void deleteMember(@PathVariable String id){
        memberService.deleteMember(id);
    }
}
