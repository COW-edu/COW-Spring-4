package practice.jungsukwoocrudapi.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.jungsukwoocrudapi.member.exception.MemberNotFoundException;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void signUp(CreateMemberRequest createMemberRequest) {
        Member member = createMemberRequest.toEntity();
        memberRepository.save(member);
    }

    public MemberResponse readMember(String name) {
            Member member = memberRepository.readMember(name);
        if (member == null) {
            throw new MemberNotFoundException("Member not found with name: " + name);
        }
            return new MemberResponse(member.getName(), member.getEmail());
    }

    public void updateMember(String name, UpdateMemberRequest updatedMember) {

            Member member = memberRepository.readMember(name);
            member.updateInfo(updatedMember.getUsername(), updatedMember.getEmail());
            memberRepository.updateMember(member);
        }

    public void deleteMember(String name) {
        memberRepository.delete(name);
    }

}
