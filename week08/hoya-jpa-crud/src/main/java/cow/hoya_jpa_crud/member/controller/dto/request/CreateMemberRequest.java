package cow.hoya_jpa_crud.member.controller.dto.request;

import cow.hoya_jpa_crud.member.entity.Member;
import lombok.Getter;

@Getter
public class CreateMemberRequest {

	private String name;

	private String email;

	private String password;

	public Member toEntity() {
		return Member.builder()
			.name(name)
			.email(email)
			.password(password)
			.build();
	}
}
