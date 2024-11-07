package com.example.junhyukcrudapi.member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service // 서비스 명시 bean으로 등록
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void signup(CreateMemberRequest createMemberRequest) {
        Member member = createMemberRequest.toEntity();
        memberRepository.save(member);
    }
}
