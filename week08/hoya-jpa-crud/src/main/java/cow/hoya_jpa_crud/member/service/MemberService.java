package cow.hoya_jpa_crud.member.service;

import org.springframework.stereotype.Service;

import cow.hoya_jpa_crud.member.controller.dto.request.CreateMemberRequest;
import cow.hoya_jpa_crud.member.controller.dto.response.MemberResponse;
import cow.hoya_jpa_crud.member.entity.Member;
import cow.hoya_jpa_crud.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;

	// public void signUp(CreateMemberRequest createMemberRequest) {
	// 	Member member = createMemberRequest.toEntity();
	// 	memberRepository.saveMap(member);
	// }
	//
	// public MemberResponse getMember(String name) {
	// 	Member member = memberRepository.findByNameWithCustom(name);
	// 	return MemberResponse.from(member);
	// }

	public void signUp(CreateMemberRequest createMemberRequest) {
		Member member = createMemberRequest.toEntity();
		memberRepository.save(member);
	}

	public MemberResponse getMemberByName(String name) {
		Member member = memberRepository.findByName(name)
			.orElseThrow(() -> new IllegalArgumentException("Member를 찾을 수 없습니다."));
		return MemberResponse.from(member);
	}

	public MemberResponse getMemberById(final Long id) {
		Member member = memberRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("Member를 찾을 수 없습니다."));
		return MemberResponse.from(member);
	}
}
