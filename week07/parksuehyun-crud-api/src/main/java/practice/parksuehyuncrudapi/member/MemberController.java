package practice.parksuehyuncrudapi.member;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    @PostMapping
    public void signup(@RequestBody CreateMemberRequest creatememberRequest) {
        memberService.signup(creatememberRequest);
    }
    @GetMapping("/{username}")
    public MemberResponse getmember(@PathVariable String username){
        return memberService.getmember(username);
    }
    @PutMapping ("/{username}")
    public void update(@PathVariable String username, @RequestBody UpdateMemberRequest updatememberRequest){
        memberService.updatemember(username, updatememberRequest);
    }
    @DeleteMapping("/{username}")
    public void delete(@RequestBody String username){
        memberService.deletemember(username);
    }

}
