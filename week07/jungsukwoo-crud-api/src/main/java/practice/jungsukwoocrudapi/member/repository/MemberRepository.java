package practice.jungsukwoocrudapi.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.jungsukwoocrudapi.member.entity.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByName(String name);
}
