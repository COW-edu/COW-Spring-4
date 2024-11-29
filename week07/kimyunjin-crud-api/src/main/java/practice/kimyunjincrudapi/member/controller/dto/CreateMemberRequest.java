package practice.kimyunjincrudapi.member.controller.dto;

import lombok.Getter;
import practice.kimyunjincrudapi.member.Member;

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
