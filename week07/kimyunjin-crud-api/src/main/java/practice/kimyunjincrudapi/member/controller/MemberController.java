package practice.kimyunjincrudapi.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import practice.kimyunjincrudapi.member.controller.dto.CreateMemberRequest;
import practice.kimyunjincrudapi.member.controller.dto.MemberResponse;
import practice.kimyunjincrudapi.member.controller.dto.UpdateMemberRequest;
import practice.kimyunjincrudapi.member.service.MemberService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping()
    public ResponseEntity<CreateMemberRequest> signUp(@RequestBody CreateMemberRequest createMemberRequest) {
        memberService.signUp(createMemberRequest);
        return ResponseEntity.ok(createMemberRequest);
    }

    @GetMapping("/members")
    public ResponseEntity<List<MemberResponse>> getAllMembers() {
        List<MemberResponse> members = memberService.getAllMembers();
        return ResponseEntity.ok(members);
    }

    @GetMapping("/members/{name}")
    public MemberResponse getMember(@PathVariable("name") String name) {
        return memberService.getMember(name);
    }

    @PutMapping("/members/{name}")
    public MemberResponse updateMember(
            @PathVariable("name") String name,
            @RequestBody UpdateMemberRequest updateMemberRequest) {
        return memberService.updateMember(name, updateMemberRequest);
    }

    @DeleteMapping("/members/{name}")
    public ResponseEntity<Object> deleteMember(@PathVariable("name") String name) {
        memberService.deleteMember(name);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/members")
    public ResponseEntity<Void> deleteAllMembers() {
        memberService.deleteAllMembers();

        return ResponseEntity.noContent().build();
    }
}
