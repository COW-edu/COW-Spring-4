package practice.kimyunjincrudapi.member;

import lombok.Getter;

@Getter
public class CreateMemberRequest {

    private String username;
    private String email;
    private String password;

    public Member toEntity(Long id) {
        return Member.builder()
                .id(id)
                .name(username)
                .email(email)
                .password(password)
                .build();
    }
}
