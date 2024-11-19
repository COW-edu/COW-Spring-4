package practice.seoayeongcrudapi.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import practice.seoayeongcrudapi.member.controller.dto.request.CreateMemberRequest;
import practice.seoayeongcrudapi.member.controller.dto.request.UpdateMemberRequest;
import practice.seoayeongcrudapi.member.controller.dto.response.MemberResponse;
import practice.seoayeongcrudapi.member.service.MemberService;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/members")
    public void signUp(@RequestBody CreateMemberRequest createMemberRequest) {
        memberService.signUp(createMemberRequest);
    }

    @GetMapping("/members/{id}")
    public MemberResponse getMember(@PathVariable("id") Long id) {
        return memberService.getMemberByName(id);
    }

    @PutMapping("/members/{id}")
    public void updateMember(@RequestBody UpdateMemberRequest updateMemberRequest, @PathVariable("id") Long id) {
        memberService.updateMember(id, updateMemberRequest);
    }

    @DeleteMapping("/members/{id}")
    public void deleteMember(@PathVariable("id") Long id) {
        memberService.deleteMember(id);
    }
}