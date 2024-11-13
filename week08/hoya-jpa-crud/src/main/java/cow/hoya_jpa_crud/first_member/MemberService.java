package cow.hoya_jpa_crud.first_member;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;

	public void signUp(CreateMemberRequest createMemberRequest) {
		Member member = createMemberRequest.toEntity();
		memberRepository.save(member);
	}

	public MemberResponse getMember(String name) {
		Member member = memberRepository.findByName(name);
		return MemberResponse.from(member);
	}
}
