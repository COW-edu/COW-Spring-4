package practice.banghyunwoocrudapi.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.banghyunwoocrudapi.member.controller.dto.request.CreateMemberRequest;
import practice.banghyunwoocrudapi.member.controller.dto.response.MemberResponse;
import practice.banghyunwoocrudapi.member.controller.dto.request.UpdateMemberRequest;
import practice.banghyunwoocrudapi.member.entity.Member;
import practice.banghyunwoocrudapi.member.repository.MemberJpaRepository;


@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberJpaRepository memberJpaRepository;

    public void signUp(CreateMemberRequest createMemberRequest) {
        Member member = createMemberRequest.toEntity();
        memberJpaRepository.save(member);
    }

    @Transactional(readOnly = true)
    public MemberResponse getMember(Long id) {
        Member member = memberJpaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 이름으로 member를 찾을 수 없습니다."));
        return MemberResponse.from(member);
    }

    public void updateMember(Long id, UpdateMemberRequest request) {
        Member member = memberJpaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 이름으로 member를 찾을 수 없습니다."));
        member.updateMember(request);
    }

    public void deleteMember(Long id) {
        Member member = memberJpaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 이름으로 member를 찾을 수 없습니다."));
        memberJpaRepository.delete(member);
    }
}
