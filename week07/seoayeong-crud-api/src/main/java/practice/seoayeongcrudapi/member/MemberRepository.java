package practice.seoayeongcrudapi.member;

import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class MemberRepository {
    //name은 unique해야 한다.
    private final Map<String, Member> memberRepository = new ConcurrentHashMap<>();

    public void save(Member member) {
        memberRepository.put(member.getName(), member);
    }
    public void patch(String name, Member member) {
        memberRepository.remove(name);
        memberRepository.put(member.getName(), member);
    }
    public void delete(String name) {
        memberRepository.remove(name);
    }
    public Member findByName(String name) {
        return memberRepository.get(name);
    }
}
