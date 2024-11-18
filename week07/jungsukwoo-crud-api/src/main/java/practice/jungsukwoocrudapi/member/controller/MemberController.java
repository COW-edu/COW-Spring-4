package practice.jungsukwoocrudapi.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import practice.jungsukwoocrudapi.member.controller.dto.request.CreateMemberRequest;
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

//    @PutMapping("/members/{name}")
//    public void updateMember(@PathVariable String name, @RequestBody UpdateMemberRequest updatedMember) {
//        memberService.updateMember(name, updatedMember);
//    }

    @DeleteMapping("{id}")
    public void deleteMember(@PathVariable("id") Long id) {
        memberService.deleteMember(id);
    }
//
//    @ExceptionHandler(MemberNotFoundException.class)
//    public ResponseEntity<String> handleMemberNotFoundException(MemberNotFoundException ex) {
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
//    }
}

