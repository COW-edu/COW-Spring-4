package practice.seoayeongcrudapi.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.seoayeongcrudapi.member.controller.dto.request.CreateMemberRequest;
import practice.seoayeongcrudapi.member.controller.dto.request.UpdateMemberRequest;
import practice.seoayeongcrudapi.member.controller.dto.response.MemberResponse;
import practice.seoayeongcrudapi.member.entity.Member;
import practice.seoayeongcrudapi.member.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

//    public void signUp(CreateMemberRequest createMemberRequest) {
//        Member member = createMemberRequest.toEntity();
//        memberRepository.save(member);
//    }
//
//    public MemberResponse getMember(String name) {
//        Member member = memberRepository.findByName(name);
//        return MemberResponse.from(member);
//    }

    public void signUp(CreateMemberRequest createMemberRequest) {
        Member member = createMemberRequest.toEntity();
        memberRepository.save(member);
    }

    public MemberResponse getMemberByName(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Member를 찾을 수 없습니다."));
        return MemberResponse.from(member);
    }

    public void updateMember(Long id, UpdateMemberRequest updateMemberRequest) {
        Member updateMember = updateMemberRequest.toEntity();
        Member findMember = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(id + "으로 member를 찾을 수 없습니다."));
        findMember.update(updateMember);
    }

    public void deleteMember(Long id) {
        Member findMember = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(id + "으로 member를 찾을 수 없습니다."));
        memberRepository.delete(findMember);
    }

}