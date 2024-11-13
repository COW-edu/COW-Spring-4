package practice.jungsukwoocrudapi.member;

import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class MemberRepository {

    //name은 unique 해야한다.
    private final Map<String, Member> memberRepository = new ConcurrentHashMap<>();

    public void save(Member member) {
        memberRepository.put(member.getName(), member);
    }

    public Member readMember(String name){
        return memberRepository.get(name);
    }

    public void updateMember(Member member) {
        memberRepository.put(member.getName(), member);
    }

    public void delete(String name) {
        memberRepository.remove(name);
    }
}
