package practice.seoayeongcrudapi.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import practice.seoayeongcrudapi.member.controller.dto.request.CreateMemberRequest;
import practice.seoayeongcrudapi.member.controller.dto.request.UpdateMemberRequest;
import practice.seoayeongcrudapi.member.controller.dto.response.MemberResponse;
import practice.seoayeongcrudapi.member.service.MemberService;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping()
    public void signUp(@RequestBody CreateMemberRequest createMemberRequest) {
        memberService.signUp(createMemberRequest);
    }

    @GetMapping("/{id}")
    public MemberResponse getMember(@PathVariable("id") Long id) {
        return memberService.getMemberByName(id);
    }

    @PutMapping("/{id}")
    public void updateMember(@RequestBody UpdateMemberRequest updateMemberRequest, @PathVariable("id") Long id) {
        memberService.updateMember(id, updateMemberRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable("id") Long id) {
        memberService.deleteMember(id);
    }
}