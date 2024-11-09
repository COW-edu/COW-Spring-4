package practice.banghyunwoocrudapi.member;

import lombok.Getter;

@Getter
public class CreateMemberRequest {

    private int id;
    private String username;
    private String email;
    private String password;

    public Member toEntity() {
        return Member.builder()
                .id(id)
                .name(username)
                .email(email)
                .password(password)
                .build();
    }
}
