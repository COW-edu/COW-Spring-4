package practice.banghyunwoocrudapi.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import practice.banghyunwoocrudapi.member.controller.dto.request.CreateMemberRequest;
import practice.banghyunwoocrudapi.member.controller.dto.response.MemberResponse;
import practice.banghyunwoocrudapi.member.service.MemberService;
import practice.banghyunwoocrudapi.member.controller.dto.request.UpdateMemberRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public void signUp(@RequestBody CreateMemberRequest createMemberRequest){
        memberService.signUp(createMemberRequest);
    }

    @GetMapping("/{id}")
    public MemberResponse getMember(@PathVariable Long id){
        return memberService.getMember(id);
    }

    @PutMapping("/{id}")
    public void updateMember(@PathVariable Long id,
                             @RequestBody UpdateMemberRequest updateMemberRequest){
        memberService.updateMember(id, updateMemberRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Long id){
        memberService.deleteMember(id);
    }
}
