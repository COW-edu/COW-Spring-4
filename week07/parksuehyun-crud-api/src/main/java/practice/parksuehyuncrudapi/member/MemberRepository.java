package practice.parksuehyuncrudapi.member;

import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class MemberRepository {
    //name은 unique 해야한다.
    private final Map<String, Member> memberrepository = new ConcurrentHashMap<>();

    public void save(Member member) {
        memberrepository.put(member.getName(), member);
    }
    public Member getmember(String name) {
        return memberrepository.get(name);
    }
    public void update(Member member) {
        memberrepository.put(member.getName(), member);
    }
    public void delete(String name) {
        memberrepository.remove(name);
    }


}
