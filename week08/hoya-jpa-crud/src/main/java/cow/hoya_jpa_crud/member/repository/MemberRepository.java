package cow.hoya_jpa_crud.member.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cow.hoya_jpa_crud.member.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberCustomRepository {
	Optional<Member> findByName(String name);
}
