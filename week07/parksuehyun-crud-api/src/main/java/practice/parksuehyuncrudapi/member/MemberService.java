package practice.parksuehyuncrudapi.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Component
public class MemberService {
    private final MemberRepository memberrepository;

    public void signup(CreateMemberRequest creatememberRequest) {
        Member member = creatememberRequest.toEntity();
        memberrepository.save(member);
    }
    public MemberResponse getmember(String username) {
        Member Member = memberrepository.getmember(username);
        return new MemberResponse(Member.getName(), Member.getEmail());
    }

    public void updatemember(String username, UpdateMemberRequest updatememberRequest) {
        Member member = memberrepository.getmember(username);
        member.updateProfile(updatememberRequest.getUsername(),updatememberRequest.getEmail());
        memberrepository.update(member);
    }

    public void deletemember(String username) {
        memberrepository.delete(username);
    }
}
