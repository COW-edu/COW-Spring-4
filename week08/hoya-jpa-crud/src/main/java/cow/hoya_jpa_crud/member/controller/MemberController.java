package cow.hoya_jpa_crud.member.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cow.hoya_jpa_crud.member.controller.dto.request.CreateMemberRequest;
import cow.hoya_jpa_crud.member.controller.dto.response.MemberResponse;
import cow.hoya_jpa_crud.member.service.MemberService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;

	@PostMapping("/members")
	public void signUp(@RequestBody CreateMemberRequest createMemberRequest) {
		memberService.signUp(createMemberRequest);
	}

	// @GetMapping("/members/{name}")
	// public MemberResponse getMemberByName(@PathVariable("name") String name) {
	// 	return memberService.getMemberByName(name);
	// }

	@GetMapping("/members/{id}")
	public MemberResponse getMemberById(@PathVariable("id") Long id) {
		return memberService.getMemberById(id);
	}
}
