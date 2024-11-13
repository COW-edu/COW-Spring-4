package practice.seoayeongcrudapi.member;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/members")
    public void signUp(@RequestBody CreateMemberRequest createMemberRequest) {
        memberService.signUp(createMemberRequest);
    }

    @GetMapping("/members/{name}")
    public MemberResponse getMember(@PathVariable("name") String name) {
        return memberService.getMember(name);
    }

    @PutMapping("/members/{name}")
    public void updateMember(@RequestBody UpdateMemberRequest updateMemberRequest, @PathVariable("name") String name) {
        memberService.updateMember(name, updateMemberRequest);
    }

    @DeleteMapping("/members/{name}")
    public void deleteMember(@PathVariable("name") String name) {
        memberService.deleteMember(name);
    }


}