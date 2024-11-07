package com.example.junhyukcrudapi.member;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class MemberRepository {
    // Name은 Unique 해야한다.
    private final Map<String, Member> membersRepository = new ConcurrentHashMap<>();

    public void save(Member member) {
        membersRepository.put(member.getName(), member);
    }
}
