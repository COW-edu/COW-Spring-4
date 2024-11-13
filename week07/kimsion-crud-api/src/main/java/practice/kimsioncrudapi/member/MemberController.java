package practice.kimsioncrudapi.member;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

  private final MemberService memberService;

  @PostMapping("/members")
  public void signUp(@RequestBody CreateMemberRequest createMemberRequest){
    memberService.signUp(createMemberRequest);
  }

  @GetMapping("/members/{id}")
  public MemberResponse getMember(@PathVariable("id") Integer id){
    return memberService.getMember(id);
  }

  @PatchMapping("/members/{id}")
  public MemberResponse patchMember(@PathVariable("id") Integer id, @RequestBody CreateMemberRequest createMemberRequest){
    return memberService.updateInformation(id, createMemberRequest);
  }

  @DeleteMapping("/members/{id}")
  public void deleteMember(@PathVariable("id") Integer id){
    memberService.deleteMember(id);
  }

}
