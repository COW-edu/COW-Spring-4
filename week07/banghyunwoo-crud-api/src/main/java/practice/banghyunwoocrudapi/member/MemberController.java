package practice.banghyunwoocrudapi.member;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public void signUp(@RequestBody CreateMemberRequest createMemberRequest){
        memberService.signUp(createMemberRequest);
    }

    @GetMapping("/:{id}")
    public MemberResponse getMember(@PathVariable String id){
        return memberService.getMember(id);
    }

    @PutMapping("/:{id}")
    public void updateMember(@PathVariable("id") String id,
                             @RequestBody UpdateMemberRequest updateMemberRequest){
        memberService.updateMember(id, updateMemberRequest);
    }

    @DeleteMapping("/:{id}")
    public void deleteMember(@PathVariable String id){
        memberService.deleteMember(id);
    }
}
