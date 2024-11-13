package practice.kimsioncrudapi.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

  private final MemberRepository memberRepository;

  public void signUp(CreateMemberRequest createMemberRequest){
    Member member = createMemberRequest.toEntity();
    memberRepository.save(member);
  }

  public MemberResponse getMember(Integer id){
    Member member = memberRepository.findById(id);
    return MemberResponse.from(member);
  }

  public MemberResponse updateInformation(Integer id , CreateMemberRequest createMemberRequest){
    Member member = memberRepository.findById(id);
    member.update(createMemberRequest);
    memberRepository.save(member);
    return MemberResponse.from(member);
  }

  public void deleteMember(Integer id) {
    memberRepository.delete(id);
  }

}
