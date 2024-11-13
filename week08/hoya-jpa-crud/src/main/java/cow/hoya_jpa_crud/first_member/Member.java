package cow.hoya_jpa_crud.first_member;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Member {

	private String name;

	private String email;

	private String password;

	@Builder
	private Member(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}
}
