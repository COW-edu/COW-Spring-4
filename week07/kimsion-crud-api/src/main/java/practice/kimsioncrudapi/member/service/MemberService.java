package practice.kimsioncrudapi.member.service;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.kimsioncrudapi.member.repository.MemberJpaRepository;
import practice.kimsioncrudapi.member.controller.dto.response.MemberResponse;
import practice.kimsioncrudapi.member.entity.Member;
import practice.kimsioncrudapi.member.controller.dto.request.CreateMemberRequest;

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
  public MemberResponse getMemberById(Long id) {
    Member member = memberJpaRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Member를 찾을 수 없습니다."));
    return MemberResponse.from(member);
  }

  public void updateInformation(Long id, CreateMemberRequest createMemberRequest) {
    Member member = memberJpaRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Member를 찾을 수 없습니다."));
    member.update(createMemberRequest);
  }

  public void deleteMember(Long id) {
    Member member = memberJpaRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Member를 찾을 수 없습니다!!!!!!"));
    memberJpaRepository.delete(member);
  }

}
