package practice.jungsukwoocrudapi.member;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import practice.jungsukwoocrudapi.member.exception.MemberNotFoundException;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/members")
    public void signUp(@RequestBody CreateMemberRequest createMemberRequest) {
        memberService.signUp(createMemberRequest);
    }

    @GetMapping("/members/{name}")
    public MemberResponse getMember(@PathVariable String name){
        return memberService.readMember(name);
    }

    @PutMapping("/members/{name}")
    public void updateMember(@PathVariable String name, @RequestBody UpdateMemberRequest updatedMember) {
        memberService.updateMember(name, updatedMember);
    }

    @DeleteMapping("/members/{name}")
    public void deleteMember(@PathVariable("name") String name) {
        System.out.println(name + " DELETE name");
        memberService.deleteMember(name);
    }

    @ExceptionHandler(MemberNotFoundException.class)
    public ResponseEntity<String> handleMemberNotFoundException(MemberNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}

