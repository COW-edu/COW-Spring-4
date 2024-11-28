package practice.kimyunjincrudapi.member.repository;

import org.springframework.stereotype.Repository;
import practice.kimyunjincrudapi.member.Member;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class MemberRepository {

    private final Map<Long, Member> memberRepository = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public Long generateId() {
        return idGenerator.getAndIncrement();
    }

    public void save(Member member) {
        memberRepository.put(member.getId(), member);
    }

    public Collection<Member> findAll() {
        return memberRepository.values();
    }

    public Member findByName(String name) {
        return memberRepository.values().stream()
                .filter(member -> member.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public void deleteByName(String name) {
        Member member = findByName(name);
        if (member != null) {
            memberRepository.remove(member.getId());
        }
    }

    public void deleteAll() {
        memberRepository.clear();
    }
}
