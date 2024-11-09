package cow.hoya_jpa_crud.member.repository;

import cow.hoya_jpa_crud.member.entity.Member;

public interface MemberCustomRepository {
	void saveMap(Member member);

	Member findByNameWithCustom(String name);
}
