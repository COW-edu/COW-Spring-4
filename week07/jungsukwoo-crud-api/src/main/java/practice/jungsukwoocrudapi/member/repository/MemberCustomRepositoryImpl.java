package practice.jungsukwoocrudapi.member.repository;

import practice.jungsukwoocrudapi.member.entity.Member;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MemberCustomRepositoryImpl implements MemberCustomRepository{

    private final Map<String, Member> memberRepository = new ConcurrentHashMap<String, Member>();

    public void saveMap(Member member){
        memberRepository.put(member.getName(), member);
    }

    public Member findByNameWithCustom(String name) {
        return memberRepository.get(name);
    }
}
