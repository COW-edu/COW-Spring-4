package practice.jungsukwoocrudapi.member.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.jungsukwoocrudapi.member.controller.dto.request.CreateMemberRequest;
import practice.jungsukwoocrudapi.member.controller.dto.response.MemberResponse;
import practice.jungsukwoocrudapi.member.entity.Member;
import practice.jungsukwoocrudapi.member.repository.MemberRepository;

@Service
@RequiredArgsConstructor
@Transactional //조회외에는 이거 달아주고 조회에는 readOnly = true를 달아준다. 플러쉬까지 갈 필요 없으니까 조회만하니까..?
public class MemberService {

    private final MemberRepository memberRepository;

    public void signUp(CreateMemberRequest createMemberRequest) {
        Member member = createMemberRequest.toEntity();
        memberRepository.save(member);
    }

    public MemberResponse getMemberByName(String name){
        Member member = memberRepository.findByName(name)
                .orElseThrow(()->new IllegalArgumentException("Member를 찾을 수 없습니다."));
        return MemberResponse.from(member);
    }

    public MemberResponse getMemberById(final Long id) {
           Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Member를 찾을 수 없습니다."));
           return MemberResponse.from(member);
    }

//    public void updateMember(String name, UpdateMemberRequest updatedMember) {
//
//            Member member = memberRepository.readMember(name);
//            member.updateInfo(updatedMember.getUsername(), updatedMember.getEmail());
//            memberRepository.updateMember(member);
//        }
//
    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

}
