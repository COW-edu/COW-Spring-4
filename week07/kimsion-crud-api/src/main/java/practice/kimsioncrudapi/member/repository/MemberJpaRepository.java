package practice.kimsioncrudapi.member.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practice.kimsioncrudapi.member.entity.Member;

@Repository
public interface MemberJpaRepository extends JpaRepository<Member, Long>{
  Optional<Member> findByName(String name);
}
