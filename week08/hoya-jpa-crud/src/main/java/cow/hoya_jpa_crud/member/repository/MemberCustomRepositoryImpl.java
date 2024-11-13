package cow.hoya_jpa_crud.member.repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import cow.hoya_jpa_crud.member.entity.Member;

@Repository
public class MemberCustomRepositoryImpl implements MemberCustomRepository {

	//name은 unique해야 한다.
	private final Map<String, Member> memberRepository = new ConcurrentHashMap<>();

	public void saveMap(Member member) {
		memberRepository.put(member.getName(), member);
	}

	public Member findByNameWithCustom(String name) {
		return memberRepository.get(name);
	}
}
