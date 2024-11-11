package practice.banghyunwoocrudapi.member;

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

    public MemberResponse getMember(String id) {
        Member member = memberRepository.findById(id);
        return MemberResponse.from(member);
    }

    public void updateMember(String id, Member updateMemberRequest) {
        Member member = memberRepository.findById(id);
        Member updatedMember = UpdateMemberRequest.getMember(updateMemberRequest, member);
        memberRepository.save(updatedMember);
    }

    public void deleteMember(String id) {
        memberRepository.delete(id);
    }
}
