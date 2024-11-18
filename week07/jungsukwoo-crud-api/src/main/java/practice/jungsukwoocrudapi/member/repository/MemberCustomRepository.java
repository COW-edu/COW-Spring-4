package practice.jungsukwoocrudapi.member.repository;

import practice.jungsukwoocrudapi.member.entity.Member;

public interface MemberCustomRepository {
    void saveMap(Member member);

    Member findByNameWithCustom(String name);
}
