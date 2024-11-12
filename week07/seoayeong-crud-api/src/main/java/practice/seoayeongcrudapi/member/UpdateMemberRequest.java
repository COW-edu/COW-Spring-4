package practice.seoayeongcrudapi.member;

import lombok.Getter;


@Getter
public class UpdateMemberRequest {

    private String username;

    private String email;

    public Member toEntity() {
        return Member.builder()
                .name(username)
                .email(email)
                .build();
    }
}
