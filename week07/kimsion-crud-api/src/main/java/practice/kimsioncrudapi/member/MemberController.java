package practice.kimsioncrudapi.member;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.web.servlet.error.DefaultErrorViewResolver;
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

}
