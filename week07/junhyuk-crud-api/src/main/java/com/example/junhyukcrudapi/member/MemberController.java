package com.example.junhyukcrudapi.member;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public void updateMember(@PathVariable String name, @RequestBody UpdateMemberRequest updateMemberRequest) {
        memberService.updateMember(name, updateMemberRequest);
    }

    @DeleteMapping("/members/{name}")
    public ResponseEntity<Object> deleteMember(@PathVariable String name) {
        memberService.deleteMember(name);
        return ResponseEntity.noContent().build();
    }
}
