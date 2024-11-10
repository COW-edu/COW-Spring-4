package cow.hoya_jpa_crud.first_member;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

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
}
