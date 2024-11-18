package practice.jungsukwoocrudapi.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.jungsukwoocrudapi.member.controller.dto.request.CreateMemberRequest;
import practice.jungsukwoocrudapi.member.controller.dto.response.MemberResponse;
import practice.jungsukwoocrudapi.member.entity.Member;
import practice.jungsukwoocrudapi.member.repository.MemberRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public void signUp(CreateMemberRequest createMemberRequest) {
        Member member = createMemberRequest.toEntity();
        memberRepository.save(member);
    }

//    public MemberResponse getMemberByName(String name){
//        Member member = memberRepository.findByName(name)
//                .orElseThrow(()->new IllegalArgumentException("Member를 찾을 수 없습니다."));
//        return MemberResponse.from(member);
//    }

    @Transactional(readOnly = true)
    public MemberResponse getMemberById(final Long id) {
           Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Member를 찾을 수 없습니다."));
           return MemberResponse.from(member);
    }

    public MemberResponse updateMemberById(final Long id){
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

    public void deleteMemberById(Long id) {
        memberRepository.deleteById(id);
    }

}
