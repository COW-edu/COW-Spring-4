package practice.banghyunwoocrudapi.member.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import practice.banghyunwoocrudapi.member.entity.Member;

import java.util.Optional;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {

    Optional<Member> findById(Long id);
}
