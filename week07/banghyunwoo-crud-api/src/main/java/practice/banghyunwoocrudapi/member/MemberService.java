package practice.banghyunwoocrudapi.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void updateMember(String id, Member updateMemberRequest) {
        Member member = memberRepository.findById(id);
        Member updatedMember = getMember(updateMemberRequest, member);
        memberRepository.save(updatedMember);
    }

    public void signUp(CreateMemberRequest createMemberRequest) {
        Member member = createMemberRequest.toEntity();
        memberRepository.save(member);
    }

    public MemberResponse getMember(String id) {
        Member member = memberRepository.findById(id);
        return MemberResponse.from(member);
    }

    private static Member getMember(Member updateMemberRequest, Member member) {
        Member updatedMember = member.toBuilder()
                .name(updateMemberRequest.getName() != null ? updateMemberRequest.getName() : member.getName())
                .email(updateMemberRequest.getEmail() != null ? updateMemberRequest.getEmail() : member.getEmail())
                .password(updateMemberRequest.getPassword() != null ? updateMemberRequest.getPassword() : member.getPassword())
                .build();
        return updatedMember;
    }

}
