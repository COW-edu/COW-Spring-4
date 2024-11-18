package practice.jungsukwoocrudapi.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import practice.jungsukwoocrudapi.member.controller.dto.request.CreateMemberRequest;
import practice.jungsukwoocrudapi.member.controller.dto.request.UpdateMemberRequest;
import practice.jungsukwoocrudapi.member.controller.dto.response.MemberResponse;
import practice.jungsukwoocrudapi.member.service.MemberService;

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
    public MemberResponse getMemberById(@PathVariable("id") Long id){
        return memberService.getMemberById(id);
    }

    @PutMapping
    public MemberResponse updateMemberById(@PathVariable("id") Long id, @RequestBody UpdateMemberRequest updateMemberRequest){
        return memberService.updateMemberById(id, updateMemberRequest);
    }

    @DeleteMapping("{id}")
    public void deleteMemberById(@PathVariable("id") Long id) {
        memberService.deleteMemberById(id);
    }
}

