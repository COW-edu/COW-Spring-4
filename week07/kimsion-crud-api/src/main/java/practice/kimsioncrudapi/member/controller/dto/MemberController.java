package practice.kimsioncrudapi.member.controller.dto;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import practice.kimsioncrudapi.member.controller.dto.request.CreateMemberRequest;
import practice.kimsioncrudapi.member.controller.dto.response.MemberResponse;
import practice.kimsioncrudapi.member.service.MemberService;

@RestController
@RequiredArgsConstructor
public class MemberController {

  private final MemberService memberService;

  @PostMapping("/members")
  public void signUp(@RequestBody CreateMemberRequest createMemberRequest){
    memberService.signUp(createMemberRequest);
  }

  @GetMapping("/members/{id}")
  public MemberResponse getMember(@PathVariable("id") Long id){
    return memberService.getMemberById(id);
  }

  @PatchMapping("/members/{id}")
  public void patchMember(@PathVariable("id") Long id, @RequestBody CreateMemberRequest createMemberRequest){
    memberService.updateInformation(id, createMemberRequest);
  }

  @DeleteMapping("/members/{id}")
  public void deleteMember(@PathVariable("id") Long id){
    memberService.deleteMember(id);
  }

}
