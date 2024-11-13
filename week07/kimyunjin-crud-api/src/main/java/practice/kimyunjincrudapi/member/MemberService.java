package practice.kimyunjincrudapi.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    public MemberResponse updateMember(String name, UpdateMemberRequest request) {
        Member member = memberRepository.findByName(name);
        member.update(request.getUsername(), request.getEmail());
        return MemberResponse.from(member);
    }

    public void deleteMember(String name) {
        Member member = memberRepository.findByName(name);
        memberRepository.deleteByName(name);
    }
}
