package cow.hoya_jpa_crud.member.controller.dto.response;

import cow.hoya_jpa_crud.member.entity.Member;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberResponse {

	private String name;

	private String email;

	private String password;

	@Builder
	private MemberResponse(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public static MemberResponse from(Member member) {
		return MemberResponse.builder()
			.name(member.getName())
			.email(member.getEmail())
			.password(member.getPassword())
			.build();
	}
}
